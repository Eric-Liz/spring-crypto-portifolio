package com.ericliz.cryptoportifolio.service;

import com.ericliz.cryptoportifolio.dto.CurrencyDTO;
import com.ericliz.cryptoportifolio.model.Currency;
import com.ericliz.cryptoportifolio.repository.CurrencyRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    @NonNull
    private CurrencyRepository currencyRepository;
    @Transactional
    public Currency saveCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }
    public List<Currency> getAllCurrencies(){
        return currencyRepository.findAll();
    }
    public List<Currency> getAllUsedCurrencies(){
        return currencyRepository.findAllUsedCurrenciesSymbols();
    }
}
