package com.example.inventory.controllers.response;

import com.example.inventory.models.Employee;
import com.example.inventory.models.Load;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoadResponse {

    @JsonProperty
    private Load load;

    @JsonProperty
    private Employee employee;

}
