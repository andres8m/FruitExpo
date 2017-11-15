package com.example.inventory.controllers.response;

import com.example.inventory.models.Product;
import com.example.inventory.models.ProductDischarge;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DischargeDetailsResponse {

    @JsonProperty
    private ProductDischarge productDischarge;

    @JsonProperty
    private Product product;
}
