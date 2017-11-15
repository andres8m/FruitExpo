package com.example.inventory.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DischargeRequest {

    @JsonProperty
    private Long total;

    @JsonProperty
    private Long employee;

    @JsonProperty
    List<ProductDischargeRequest> productDischarges;

}
