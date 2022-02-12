package com.ericliz.cryptoportifolio.controller;

import com.ericliz.cryptoportifolio.model.Item;
import com.ericliz.cryptoportifolio.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@AllArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public List<Item> hello(){
        return itemRepository.findAll();

    }
}
