package com.example.inventory.models;


import com.example.common.models.BaseModel;
import lombok.Data;

import javax.persistence.*;

@NamedQueries
        ({
                @NamedQuery(name = "All ProductDischarges", query = "SELECT productDischarge FROM ProductDischarge productDischarge")
//                @NamedQuery(name = "ProductDischarge by employee", query = "SELECT productDischarge FROM ProductDischarge productDischarge WHERE productDischarge.employee =:employee"),
//                @NamedQuery(name = "ProductDischarge by date", query = "SELECT productDischarge FROM ProductDischarge productDischarge WHERE productDischarge.date =:date")

        })


@Data
@Entity
@Table(name = "productos_descarga")
public class ProductDischarge extends BaseModel {

        @Column(name = "product")
        private Long product;

        @Column(name = "price")
        private Long price;

        @Column(name = "quantity")
        private Long quantity;

        @Column(name = "discharge")
        private Long discharge;

}
