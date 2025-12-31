package com.tfl.client_bank_b.service;


import com.tfl.client_bank_b.entity.TrxIdGenerator;
import com.tfl.client_bank_b.model.TransactionRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;

@Service
public class BankService {

    private final TrxIdGenerator generator;
    private final RestTemplate restTemplate;

    public BankService(TrxIdGenerator generator) {
        this.generator = generator;
        this.restTemplate = new RestTemplate();
    }

    public String forwardToServer(TransactionRequest request) {

        String trxId = generator.generate();

        request.setTrxId(trxId);
        request.setBankId("BANK_B");
        request.setTimestamp(OffsetDateTime.now().toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        HttpEntity<TransactionRequest> entity =
                new HttpEntity<>(request, headers);

        restTemplate.postForObject(
                "http://localhost:8081/server/transaction/process",
                entity,
                String.class
        );

        return trxId;
    }

}
