package com.ericliz.cryptoportifolio.controller;

import com.ericliz.cryptoportifolio.dto.CurrencyDTO;
import com.ericliz.cryptoportifolio.model.Currency;
import com.ericliz.cryptoportifolio.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/currencies")
@AllArgsConstructor

public class CurrencyController {
    private final CurrencyService currencyService;
    @PostMapping
    public ResponseEntity<Object> saveCurrency(@RequestBody @Valid CurrencyDTO currencyDTO) {
        Currency currencyModel = new Currency();
        BeanUtils.copyProperties(currencyDTO, currencyModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(currencyService.saveCurrency(currencyModel));
    }
    @GetMapping
    public ResponseEntity<Object> getCurrencies(){
        return ResponseEntity.status(HttpStatus.OK).body(currencyService.getAllCurrencies());
    }
}
