package com.tlf.serverApp.service;

import com.tlf.serverApp.entity.TransactionLog;
import com.tlf.serverApp.model.TransactionRequest;
import com.tlf.serverApp.repo.TransactionLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutorService;

@Service
public class TransactionService {

    private final TransactionLogRepository repository;
    private final ExecutorService executorService;

    public TransactionService(TransactionLogRepository repository,
                              ExecutorService executorService) {
        this.repository = repository;
        this.executorService = executorService;
    }

    public void process(TransactionRequest request) {

        if (request.getTrxId() == null) {
            return;
        }

        executorService.submit(() -> saveTransaction(request));
    }

    @Transactional
    public void saveTransaction(TransactionRequest request) {

        long start = System.currentTimeMillis();
        String status = "SUCCESS";

        try {
            TransactionLog log = new TransactionLog(
                    request.getTrxId(),
                    request.getBankId(),
                    status,
                    0
            );

            repository.save(log);

        } catch (Exception ex) {
            status = "FAILED";
        }

        long time = System.currentTimeMillis() - start;

        repository.updateStatusAndTime(
                request.getTrxId(),
                status,
                time
        );
    }
}
