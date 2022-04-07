package com.ericliz.cryptoportifolio.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class BinanceAvgPrice {
   private int mins;
   private BigDecimal price;
}
