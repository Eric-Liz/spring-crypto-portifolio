package com.ericliz.cryptoportifolio.service;

import com.ericliz.cryptoportifolio.model.BinanceAvgPrice;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BinanceService {

    public BinanceAvgPrice getAvgPrice(String symbol){
        RestTemplate restTemplate = new RestTemplate();
        BinanceAvgPrice avgPrice = restTemplate.getForObject("https://api.binance.com/api/v3/avgPrice?symbol="+symbol.toUpperCase()+"USDT", BinanceAvgPrice.class);
        return avgPrice;
    }
    public List<BinanceAvgPrice> getAvgPriceList(List<String> symbolList){
        List<BinanceAvgPrice> avgPriceList = new ArrayList<>();
        for (String symbol : symbolList ) {
            avgPriceList.add(getAvgPrice(symbol));
        }
        return avgPriceList;
    }
}
