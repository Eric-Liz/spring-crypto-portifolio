package com.ericliz.cryptoportifolio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {
    @Id
    @JsonProperty("_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 15,nullable = false)
    private String name;
    @Column(length = 15,nullable = false)
    private String category;


}
