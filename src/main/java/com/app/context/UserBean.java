package com.app.context;

import com.app.entity.User;
import com.app.jsonmodel.User.UpdatePasswordJsonModel;
import com.app.jsonmodel.User.UpdateStatusJsonModel;
import com.app.model.returnResult.DatabaseQueryResult;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Stateless(name = "UserEJB")
public class UserBean {
    @PersistenceUnit
    EntityManagerFactory emf;
    public UserBean() {
    }

    public List<User> getAllUser(String query) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            List<User> list;
            if (query != null && !query.isEmpty()) {
                list = em.createQuery(
                        "SELECT c from User c where username like :queryString and status = :queryStatus",
                        User.class).setParameter("queryString","%" + query + "%")
                        .setParameter("queryStatus", User.StatusEnum.ACTIVE).getResultList();
            } else {
                list =  em.createQuery("SELECT c from User c where status = :queryStatus",
                        User.class).setParameter("queryStatus", User.StatusEnum.ACTIVE).getResultList();
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

    public User getUser(String id) {
        if(id != null && !id.isEmpty()){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                User u = em.find(User.class, id);
                em.getTransaction().commit();
                em.close();
                return u.getStatus() != User.StatusEnum.DELETED? u : null;
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

    public DatabaseQueryResult addUser(User user) {
        if(user != null){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
                em.close();
                return new DatabaseQueryResult(true,
                        "addUser success");
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false,
                        "addUser fail, " + e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false,
                    "addUser fail, input is null");
        }
    }

    public DatabaseQueryResult updateUser(User user, String id) {
        if(user != null && id != null && !id.isEmpty()){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                User u = em.find(User.class, id);
                if(u != null && u.getStatus() != User.StatusEnum.DELETED){
                    u.setFirstname(user.getFirstname());
                    u.setLastname(user.getLastname());
                    u.setGender(user.getGender());
                    u.setBirthday(user.getBirthday());
                    u.setPhone(user.getPhone());
                    u.setEmail(user.getEmail());
                    u.setAddress(user.getAddress());
                    u.setUpdatedAt(System.currentTimeMillis());

                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(true,
                            "updateUser success");
                }else {
                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(false,
                            "updateUser failed, User not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false,
                        "updateUser failed, " + e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false,
                    "updateUser failed, bad request");
        }
    }

    public DatabaseQueryResult deleteUser(String id) {
        if(id != null && !id.isEmpty()){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                User u = em.find(User.class, id);
                if(u != null && u.getStatus() != User.StatusEnum.DELETED){
                    u.setStatus(User.StatusEnum.DELETED);
                    u.setUpdatedAt(System.currentTimeMillis());
                    u.setDeletedAt(System.currentTimeMillis());

                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(true,
                            "deleteUser success");
                }else {
                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(false,
                            "deleteUser failed, User not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false,
                        "deleteUser failed, " + e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false,
                    "deleteUser failed, bad request");
        }
    }

    public DatabaseQueryResult checkEmail(String email){
        if (email != null && !email.isEmpty()) {
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                List<User> list;
                list = em.createQuery(
                        "SELECT c from User c where email = :queryEmail and status != :queryStatus",
                        User.class).setParameter("queryEmail",email).setParameter("queryStatus",
                        User.StatusEnum.DELETED)
                        .getResultList();
                em.getTransaction().commit();
                em.close();
                if(list.isEmpty()){
                    return new DatabaseQueryResult(true,
                            "email valid");
                }else {
                    return new DatabaseQueryResult(false,
                            "email has been resisted");
                }
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false,
                        e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false,
                    "input is empty");
        }
    }

    public DatabaseQueryResult updateUserStatus (UpdateStatusJsonModel model){
        if(model.getId() != null && !model.getId().isEmpty()){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                User u = em.find(User.class, model.getId());
                if(u != null){
                    u.setStatus(model.getStatus());
                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(true,
                            "update status success");
                }else {
                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(false,
                            "user not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false,
                        e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false,
                    "input is empty");
        }
    }

    public DatabaseQueryResult updatePassword (UpdatePasswordJsonModel model){
        if(model.getId() != null && !model.getId().isEmpty()){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                User u = em.find(User.class, model.getId());
                if(u != null){
                    u.setPassword(model.getNewPassword());
                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(true,
                            "update status success");
                }else {
                    em.getTransaction().commit();
                    em.close();
                    return new DatabaseQueryResult(false,
                            "user not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
                return new DatabaseQueryResult(false,
                        e.getMessage());
            }
        }else {
            return new DatabaseQueryResult(false,
                    "input is empty");
        }
    }
}
