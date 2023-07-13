package com.example.dao;

import com.example.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Component
public class RoleDAO {
    @Autowired
    EntityManager entityManager;

    public Role findByID(int id) {
        String queryStr = "select a from Role a where a.id = :id";
        TypedQuery<Role> query = entityManager.createQuery(queryStr, Role.class).setParameter("id", id);
        return query.getSingleResult();
    }
}
