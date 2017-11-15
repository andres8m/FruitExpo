package com.example.inventory.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoadRequest {

    @JsonProperty
    private Long quantity;

    @JsonProperty
    private Long employee;
}
