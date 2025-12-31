package com.tfl.client_bank_a.controller;


import com.tfl.client_bank_a.model.TransactionRequest;
import com.tfl.client_bank_a.service.BankService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankService service;

    public BankController(BankService service) {
        this.service = service;
    }

    @PostMapping("/transaction")
    public Map<String, Object> createTransaction(
            @RequestBody TransactionRequest request) {

        // Forward request to server (async processing happens there)
        String trxId = service.forwardToServer(request);

        Map<String, Object> response = new HashMap<>();
        response.put("trxId", trxId);
        response.put("status", "RECEIVED");
        response.put("message", "Processing started");

        return response;
    }
}
