package com.example.dao;

import com.example.model.Account;
import com.example.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class RoleDAO {
    @Autowired
    EntityManager entityManager;

    public List<Role> getAllRole() {
        String queryStr = "select r from Role r";
        TypedQuery<Role> query = entityManager.createQuery(queryStr, Role.class);
        return query.getResultList();
    }

    public Role findRoleByID(int idRole) {
        String queryStr = "select r from Role r where r.id = : id";
        TypedQuery<Role> query = entityManager.createQuery(queryStr, Role.class);
        query.setParameter("id", idRole);
        return query.getSingleResult();
    }

    public int findIndexRole(int idRole) {
        TypedQuery<Integer> query = entityManager.createQuery("select r.id from Role r where r.id = :id", Integer.class);
        query.setParameter("id", idRole);
        return query.getSingleResult();
    }
}
