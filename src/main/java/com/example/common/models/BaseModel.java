package com.example.common.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jorge on 09/03/2017.
 */
@Data
@MappedSuperclass
public class BaseModel implements Serializable
{
    @Transient
    @JsonIgnore
    final static long serialVersionUID = 1;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
