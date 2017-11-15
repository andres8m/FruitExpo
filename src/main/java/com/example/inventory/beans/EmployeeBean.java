package com.example.inventory.beans;


import com.example.inventory.models.Employee;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class EmployeeBean {

    @PersistenceContext
    EntityManager db;

    public List<Employee> all()
    {
        return db.createNamedQuery("All Employees", Employee.class).getResultList();
    }

    public Employee byId(Long id)
    {
        return db.find(Employee.class,id);
    }

    public void persistEmployee(Employee employee)
    {
        db.persist(employee);
    }

    public void mergeEmployee(Employee employee)
    {
        db.merge(employee);
    }

}
