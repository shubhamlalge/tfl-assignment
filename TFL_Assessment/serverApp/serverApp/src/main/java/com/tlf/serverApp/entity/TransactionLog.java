package com.tlf.serverApp.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "transaction_log")
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    @Column(name = "trx_id")
    private String trxId;

    @Column(name = "bank_id")
    private String bankId;

    @Column(name = "processing_time_ms")
    private long processingTimeMs;

    public TransactionLog() {}

    public TransactionLog(String trxId, String bankId, String status, long processingTimeMs) {
        this.trxId = trxId;
        this.bankId = bankId;

        this.status = status;
        this.processingTimeMs = processingTimeMs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getProcessingTimeMs() {
        return processingTimeMs;
    }

    public void setProcessingTimeMs(long processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
    }
}
