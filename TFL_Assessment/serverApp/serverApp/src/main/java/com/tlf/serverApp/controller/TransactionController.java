package com.tlf.serverApp.controller;


import com.tlf.serverApp.model.TransactionRequest;
import com.tlf.serverApp.service.TransactionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/server/transaction")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping(
            value = "/process",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Map<String, Object> process(@RequestBody TransactionRequest request) {

        service.process(request);

        Map<String, Object> response = new HashMap<>();
        response.put("trxId", request.getTrxId());
        response.put("status", "RECEIVED");
        response.put("reason", "Processing started");

        return response;
    }
}
