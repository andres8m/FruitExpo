package com.example.inventory.models;

import com.example.common.models.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@NamedQueries
        ({
                @NamedQuery(name = "All Loads", query = "SELECT load FROM Load load"),
                @NamedQuery(name = "Load by employee", query = "SELECT load FROM Load load WHERE load.employee =:employee"),
                @NamedQuery(name = "Load by date", query = "SELECT load FROM Load load WHERE load.date =:date")

        })


@Data
@Entity
@Table(name = "carga")
public class Load extends BaseModel {

    @Column(name = "cantidad")
    private Long quantity;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "employee")
    private Long employee;

}
