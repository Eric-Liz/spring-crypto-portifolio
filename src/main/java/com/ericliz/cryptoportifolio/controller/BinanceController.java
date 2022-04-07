package com.ericliz.cryptoportifolio.controller;

import com.ericliz.cryptoportifolio.model.BinanceAvgPrice;
import com.ericliz.cryptoportifolio.service.BinanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currencies")
@AllArgsConstructor
public class BinanceController {
    private final BinanceService binanceService;
    @GetMapping("/actualPrice")
    public ResponseEntity<BinanceAvgPrice> getAvgPrice(@RequestParam String symbol){
        return ResponseEntity.status(HttpStatus.OK).body(binanceService.getAvgPrice(symbol));
    }

}
