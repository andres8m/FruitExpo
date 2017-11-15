package com.example.inventory.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDischargeRequest {

    @JsonProperty
    private Long product;

    @JsonProperty
    private Long price;

    @JsonProperty
    private Long quantity;

}
