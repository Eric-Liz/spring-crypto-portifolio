package com.ericliz.cryptoportifolio.model;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 15,nullable = false)
    private String name;

    @Column(nullable = false, precision=10, scale=2)
    private BigDecimal price;

    @Column(length = 15,nullable = false)
    private String category;


}
