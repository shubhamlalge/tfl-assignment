package com.tfl.client_bank_a.entity;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TrxIdGenerator {

    private final AtomicInteger counter = new AtomicInteger(1);

    public String generate() {
        return "TRX-A-" + LocalDate.now() + "-" + counter.getAndIncrement();
    }
}
