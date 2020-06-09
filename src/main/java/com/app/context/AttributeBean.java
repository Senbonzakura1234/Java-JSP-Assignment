package com.app.context;

import com.app.entity.Attribute;
import com.app.model.returnResult.DatabaseQueryResult;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "AttributeEJB")
public class AttributeBean {
    @PersistenceUnit
    EntityManagerFactory emf;
    public AttributeBean() {
    }


    public List<Attribute> getAllAttribute(String query) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            List<Attribute> list;
            if (query != null && !query.isEmpty()) {
                list = em.createQuery(
                        "SELECT c from Attribute c where name like :queryString and status != :queryStatus",
                        Attribute.class).setParameter("queryString", "%" + query + "%")
                        .setParameter("queryStatus", Attribute.StatusEnum.DELETED).getResultList();
            } else {
                list =  em.createQuery("SELECT c from Attribute c where status != :queryStatus",
                        Attribute.class).setParameter("queryStatus", Attribute.StatusEnum.DELETED)
                        .getResultList();
            }
            em.getTransaction().commit();
            em.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
            return new ArrayList<>();
        }
    }


    public Attribute getAttribute(String id) {
        if(id != null && !id.isEmpty()){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                Attribute attribute = em.find(Attribute.class, id);
                em.getTransaction().commit();
                em.close();
                return attribute.getStatus() != Attribute.StatusEnum.DELETED? attribute : null;
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

    public DatabaseQueryResult addAttribute(Attribute attribute) {
        if(attribute != null){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(attribute);
                em.getTransaction().commit();
                em.close();
                return new DatabaseQueryResult(true, "addAttribute success");
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false, "addAttribute fail, " + e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false, "addAttribute fail, input is null");
        }
    }

    public DatabaseQueryResult updateAttribute(Attribute attribute, String id) {
        if(attribute != null && id != null && !id.isEmpty()){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                Attribute u = em.find(Attribute.class, id);
                if(u != null && u.getStatus() != Attribute.StatusEnum.DELETED){
                    u.setName(attribute.getName());
                    if(attribute.getStatus() != Attribute.StatusEnum.DELETED){
                        u.setStatus(attribute.getStatus());
                    }
                    u.setUpdatedAt(System.currentTimeMillis());

                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(true,
                            "updateAttribute success");
                }else {
                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(false,
                            "updateAttribute failed, Attribute not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false,
                        "updateAttribute failed, " + e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false,
                    "updateAttribute failed, bad request");
        }
    }

    public DatabaseQueryResult deleteAttribute(String id) {
        if(id != null && !id.isEmpty()){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                Attribute u = em.find(Attribute.class, id);
                if(u != null && u.getStatus() != Attribute.StatusEnum.DELETED){
                    u.setStatus(Attribute.StatusEnum.DELETED);
                    u.setUpdatedAt(System.currentTimeMillis());
                    u.setDeletedAt(System.currentTimeMillis());

                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(true,
                            "deleteAttribute success");
                }else {
                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(false,
                            "deleteAttribute failed, Attribute not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false,
                        "deleteAttribute failed, " + e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false,
                    "deleteAttribute failed, bad request");
        }
    }
}
