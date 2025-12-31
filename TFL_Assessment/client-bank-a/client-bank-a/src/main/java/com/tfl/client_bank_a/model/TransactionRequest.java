package com.tfl.client_bank_a.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "TransactionRequest")
public class TransactionRequest {

    @JacksonXmlProperty(localName = "TrxId")
    private String trxId;

    @JacksonXmlProperty(localName = "BankId")
    private String bankId;

    @JacksonXmlProperty(localName = "CustomerId")
    private Long customerId;

    @JacksonXmlProperty(localName = "FromAccount")
    private String fromAccount;

    @JacksonXmlProperty(localName = "ToAccount")
    private String toAccount;

    @JacksonXmlProperty(localName = "Amount")
    private double amount;

    @JacksonXmlProperty(localName = "Currency")
    private String currency;

    @JacksonXmlProperty(localName = "Timestamp")
    private String timestamp;


    public TransactionRequest() {}

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
