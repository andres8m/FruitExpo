package com.example.inventory.beans;


import com.example.users.models.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class InventoryBean {

    @PersistenceContext
    EntityManager db;

    public List<User> all()
    {

        return db.createNamedQuery("All Users", User.class).getResultList();

    }


}
