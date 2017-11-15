package com.example.inventory.controllers.response;

import com.example.inventory.models.Discharge;
import com.example.inventory.models.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DischargeResponse {

    @JsonProperty
    private Discharge discharge;

    @JsonProperty
    private Employee employee;
}
