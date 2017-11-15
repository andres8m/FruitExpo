package com.example.inventory.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EmployeeRequest {

    @JsonProperty
    @NotNull
    private String name;

}
