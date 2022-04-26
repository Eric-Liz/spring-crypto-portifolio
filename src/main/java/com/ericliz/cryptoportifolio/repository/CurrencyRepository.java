package com.ericliz.cryptoportifolio.repository;

import com.ericliz.cryptoportifolio.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
    @Query(value = "SELECT DISTINCT CURRENCY.ID , SYMBOL, CURRENCY_NAME  FROM CURRENCY INNER JOIN ITEM ON CURRENCY.CURRENCY_NAME ILIKE ITEM.NAME", nativeQuery = true)
    List<Currency> findAllUsedCurrenciesSymbols();

}
