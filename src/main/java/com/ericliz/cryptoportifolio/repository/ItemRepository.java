package com.ericliz.cryptoportifolio.repository;

import com.ericliz.cryptoportifolio.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
