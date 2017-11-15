package com.example.inventory.models;


import com.example.common.models.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@NamedQueries
        ({
                @NamedQuery(name = "All Discharges", query = "SELECT discharge FROM Discharge discharge"),
                @NamedQuery(name = "Discharge by employee", query = "SELECT discharge FROM Discharge discharge WHERE discharge.employee =:employee"),
                @NamedQuery(name = "Discharge by date", query = "SELECT discharge FROM Discharge discharge WHERE discharge.date =:date")

        })


@Data
@Entity
@Table(name = "descarga")
public class Discharge extends BaseModel{

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "employee")
    private Long employee;

    @Column(name = "total")
    private Long total;
}
