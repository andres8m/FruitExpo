package com.example.inventory.models;


import com.example.common.models.BaseModel;
import lombok.Data;

import javax.persistence.*;

@NamedQueries
        ({
                @NamedQuery(name = "All Products", query = "SELECT product FROM Product product")
//                @NamedQuery(name = "Product by employee", query = "SELECT product FROM Product product WHERE product.employee =:employee"),
//                @NamedQuery(name = "Product by date", query = "SELECT product FROM Product product WHERE product.date =:date")

        })


@Data
@Entity
@Table(name = "product")
public class Product extends BaseModel{

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private Long type;
}
