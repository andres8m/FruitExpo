package com.example.inventory.beans;


import com.example.inventory.models.Discharge;
import com.example.inventory.models.Load;
import com.example.inventory.models.Product;
import com.example.inventory.models.ProductDischarge;
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

    public List<Load> allLoads()
    {

        return db.createNamedQuery("All Loads", Load.class).getResultList();

    }

    public List<Discharge> allDischarges()
    {

        return db.createNamedQuery("All Discharges", Discharge.class).getResultList();

    }

    public List<Product> allProducts()
    {
        return db.createNamedQuery("All Products", Product.class).getResultList();
    }



    public void persistLoad(Load load)
    {
        db.persist(load);
    }

    public void persistDischarge(Discharge discharge)
    {
        db.persist(discharge);
    }

    public void persistProductDischarge(ProductDischarge productDischarge)
    {
        db.persist(productDischarge);
    }


}
