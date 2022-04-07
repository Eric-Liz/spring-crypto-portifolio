package com.ericliz.cryptoportifolio.service;

import com.ericliz.cryptoportifolio.model.BinanceAvgPrice;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class BinanceService {
    public BinanceAvgPrice getAvgPrice(String symbol){
        RestTemplate restTemplate = new RestTemplate();
        BinanceAvgPrice avgPrice = restTemplate.getForObject("https://api.binance.com/api/v3/avgPrice?symbol="+symbol.toUpperCase()+"USDT", BinanceAvgPrice.class);
        return avgPrice;
    }
}
