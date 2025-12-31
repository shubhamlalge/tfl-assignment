USE tfl_server_db;

INSERT INTO transaction_log (trx_id, bank_id, status, processing_time_ms)
VALUES
('TRX-SEED-001', 'BANK_A', 'SUCCESS', 12),
('TRX-SEED-002', 'BANK_B', 'SUCCESS', 15);
