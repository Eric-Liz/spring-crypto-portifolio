package com.ericliz.cryptoportifolio.controller;

import com.ericliz.cryptoportifolio.dto.ItemDTO;
import com.ericliz.cryptoportifolio.model.Item;
import com.ericliz.cryptoportifolio.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable (value ="id") long id){
        Optional<Item> itemModelOptional = itemService.findById(id);
        if(!itemModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(itemModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable(value="id")long id,
                                             @RequestBody @Valid ItemDTO itemDTO){
        Optional<Item> itemModelOptional = itemService.findById(id);
        if(!itemModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found.");
        }
        Item itemModel = new Item();
        BeanUtils.copyProperties(itemDTO, itemModel);
        itemModel.setId(itemModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(itemService.save(itemModel));
    }

    @PostMapping
    public ResponseEntity<Object> saveItem(@RequestBody @Valid ItemDTO itemDTO){
        Item itemModel = new Item();
        BeanUtils.copyProperties(itemDTO, itemModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(itemModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable(value="id")long id){
        Optional<Item> itemModelOptional = itemService.findById(id);
        if(!itemModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found.");
        }
        itemService.delete(itemModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Item deleted successfully.");
    }
}
