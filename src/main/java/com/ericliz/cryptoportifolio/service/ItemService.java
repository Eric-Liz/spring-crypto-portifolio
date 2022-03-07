package com.ericliz.cryptoportifolio.service;

import com.ericliz.cryptoportifolio.model.Item;
import com.ericliz.cryptoportifolio.repository.ItemRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    @NonNull
    final ItemRepository itemRepository;

    @Transactional
    public Item save(Item item){
        return itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(long id){
        return itemRepository.findById(id);
    }

    public void delete(Item item){
        itemRepository.delete(item);
    }
}
