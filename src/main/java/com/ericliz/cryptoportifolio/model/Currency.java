package com.ericliz.cryptoportifolio.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(length = 8,nullable = false)
    private String symbol;
    @Column(length = 15,nullable = false)
    private String currencyName;
}
