package com.ericliz.cryptoportifolio.controller;

import com.ericliz.cryptoportifolio.model.BinanceAvgPrice;
import com.ericliz.cryptoportifolio.service.BinanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/currencies/")
@AllArgsConstructor
public class BinanceController {
    private final BinanceService binanceService;
    List<BinanceAvgPrice> avgPriceList;

    @GetMapping("/avg/actualPrice")
    public ResponseEntity<BinanceAvgPrice> getAvgPrice(@RequestParam String symbol){
        return ResponseEntity.status(HttpStatus.OK).body(binanceService.getAvgPrice(symbol));
    }
    @PostMapping("/avg")
    public ResponseEntity<List<BinanceAvgPrice>> getGroupAvgPrice(@RequestBody @Valid List<String> currencySymbols){
        return ResponseEntity.status(HttpStatus.OK).body(binanceService.getAvgPriceList(currencySymbols));
    }
    @GetMapping("/balance")
    public ResponseEntity<List<Object>> getBalance(){
        return ResponseEntity.status(HttpStatus.OK).body(binanceService.getBalance());
    }


}
