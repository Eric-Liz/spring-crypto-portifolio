package com.ericliz.cryptoportifolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Data
public class ResponseItem {
    String statusMessage;
    @Autowired
    public static ResponseItem getStatusMessage(String errorMessage){
        return new ResponseItem(errorMessage);
    }
}
