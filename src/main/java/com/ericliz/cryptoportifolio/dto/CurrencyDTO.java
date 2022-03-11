package com.ericliz.cryptoportifolio.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
public class CurrencyDTO {
    @NotBlank
    @Size(max = 8)
    private String symbol;
    @NotBlank
    @Size(max = 15)
    private String currencyName;
}
