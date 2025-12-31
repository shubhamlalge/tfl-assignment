CREATE DATABASE IF NOT EXISTS tfl_server_db;
USE tfl_server_db;

CREATE TABLE IF NOT EXISTS transaction_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    trx_id VARCHAR(50) NOT NULL UNIQUE,
    bank_id VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    processing_time_ms BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
