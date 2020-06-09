package com.app.context;

import com.app.entity.*;
import com.app.model.returnResult.DatabaseQueryResult;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Stateless(name = "ProductEJB")
public class ProductBean {
    @PersistenceUnit
    EntityManagerFactory emf;

    public ProductBean() {
    }

    public Product getProduct(String id) {
        if(id != null && !id.isEmpty()){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                Product product = em.find(Product.class, id);
                em.getTransaction().commit();
                em.close();
                return product.getStatus() != Product.StatusEnum.DELETED? product : null;
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return null;
            }
        }else {
            return null;
        }
    }

    public List<Product> getAllProduct(String query) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            List<Product> list;
            if (query != null && !query.isEmpty()) {
                list = em.createQuery(
                        "SELECT c from Product c where name like :queryString and status != :queryStatus",
                        Product.class).setParameter("queryString", "%" + query + "%")
                        .setParameter("queryStatus", Product.StatusEnum.DELETED).getResultList();
            } else {
                list =  em.createQuery("SELECT c from Product c where status != :queryStatus",
                        Product.class).setParameter("queryStatus", Product.StatusEnum.DELETED)
                        .getResultList();
            }
            em.getTransaction().commit();
            em.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
            return null;
        }
    }

    public List<Product> getProductsOfShop(String id) {
        if (id == null || id.isEmpty()) return null;
        List<Product> list;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            list = em.createQuery(
                    "select c from Product  c where shopId = :queryString and status != :queryStatus",
                    Product.class)
                    .setParameter("queryString", id)
                    .setParameter("queryStatus", Product.StatusEnum.DELETED)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
            return null;
        }
    }

    public List<Product> getProductsOfCategory(String id) {
        if (id == null || id.isEmpty()) return null;
        List<Product> list;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            list = em.createQuery(
                    "select c from Product  c where categoryId = :queryString and status != :queryStatus",
                    Product.class)
                    .setParameter("queryString", id)
                    .setParameter("queryStatus", Product.StatusEnum.DELETED)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
            return null;
        }
    }

    public List<Product> getProductsOfAttribute(String id) {
        if (id == null || id.isEmpty()) return null;
        List<Product> list;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            list = em.createQuery(
                    "select c from Product  c where attributeId = :queryString and status != :queryStatus",
                    Product.class)
                    .setParameter("queryString", id)
                    .setParameter("queryStatus", Product.StatusEnum.DELETED)
                    .getResultList();
            em.getTransaction().commit();
            em.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
            return null;
        }
    }

    public DatabaseQueryResult addProduct(Product product) {
        if(product != null){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                if (em.find(Attribute.class, product.getAttributeId()) == null) return new DatabaseQueryResult(
                        false,
                        "addProduct fail, Attribute not found");

                if (em.find(Category.class, product.getCategoryId()) == null) return new DatabaseQueryResult(
                        false,
                        "addProduct fail, Category not found");

                em.persist(product);
                em.getTransaction().commit();
                em.close();
                return new DatabaseQueryResult(true, "addProduct success");
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false, "addProduct fail, " + e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false, "addProduct fail, input is null");
        }
    }

    public DatabaseQueryResult updateProduct(Product product) {
        if(product != null){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();

                Product u = em.find(Product.class, product.getId());
                if(u != null && u.getStatus() != Product.StatusEnum.DELETED){
                    u.setName(product.getName());
                    if (!(em.find(Attribute.class, product.getAttributeId()) == null)){
                        u.setAttributeId(product.getAttributeId());
                    }else {
                        em.getTransaction().rollback();
                        em.getTransaction().commit();
                        em.close();
                        return new DatabaseQueryResult(false,
                                "updateProduct failed");
                    }

                    if (!(em.find(Category.class, product.getCategoryId()) == null)){
                        u.setCategoryId(product.getCategoryId());
                    }else {
                        em.getTransaction().rollback();
                        em.getTransaction().commit();
                        em.close();
                        return new DatabaseQueryResult(false,
                                "updateProduct failed");
                    }

                    u.setInStock(product.getInStock());
                    u.setPrice(product.getPrice());

                    if(product.getStatus() != Product.StatusEnum.DELETED){
                        u.setStatus(product.getStatus());
                    }else {
                        em.getTransaction().rollback();
                        em.getTransaction().commit();
                        em.close();
                        return new DatabaseQueryResult(false,
                                "updateProduct failed");
                    }
                    u.setUpdatedAt(System.currentTimeMillis());
                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(true,
                            "updateProduct success");
                }else {
                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(false,
                            "updateProduct failed, Product not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false,
                        "updateProduct failed, " + e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false,
                    "updateProduct failed, bad request");
        }
    }

    public DatabaseQueryResult deleteProduct(String id) {
        if(id != null && !id.isEmpty()){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                Product u = em.find(Product.class, id);
                if(u != null && u.getStatus() != Product.StatusEnum.DELETED){
                    u.setStatus(Product.StatusEnum.DELETED);
                    u.setUpdatedAt(System.currentTimeMillis());
                    u.setDeletedAt(System.currentTimeMillis());

                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(true,
                            "deleteProduct success");
                }else {
                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(false,
                            "deleteProduct failed, Product not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false,
                        "updateProduct failed" + e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false,
                    "deleteProduct failed, bad request");
        }
    }
}
