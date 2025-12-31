package com.tfl.client_bank_b.entity;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TrxIdGenerator {

    private final AtomicInteger counter = new AtomicInteger(1);

    public String generate() {
        return "TRX-B-" + LocalDate.now() + "-" + counter.getAndIncrement();
    }
}
