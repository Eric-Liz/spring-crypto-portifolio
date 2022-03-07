package com.ericliz.cryptoportifolio.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
@Data
public class ItemDTO {
    @NotBlank
    @Size(max = 10)
    private String name;
    @NotBlank
    private BigDecimal price;
    @NotBlank
    private String category;
}
