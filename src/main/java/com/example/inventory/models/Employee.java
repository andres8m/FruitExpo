package com.example.inventory.models;

import com.example.common.models.BaseModel;
import lombok.Data;

import javax.persistence.*;

@NamedQueries
        ({
                @NamedQuery(name = "All Employees", query = "SELECT user FROM Employee user"),
                @NamedQuery(name = "Employee by user", query = "SELECT user FROM Employee user WHERE user.user =:user")
        })


@Data
@Table(name = "employee")
@Entity
public class Employee extends BaseModel{


    @Column(name="name")
    private String name;

    @Column(name="user")
    private Long user;

}
