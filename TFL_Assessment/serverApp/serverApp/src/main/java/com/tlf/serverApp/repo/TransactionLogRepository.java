package com.tlf.serverApp.repo;


import com.tlf.serverApp.entity.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionLogRepository extends JpaRepository<TransactionLog,Long> {
    boolean existsByTrxId(String trxId);

    @Modifying
    @Query("""
    update TransactionLog t
    set t.status = :status,
        t.processingTimeMs = :time
    where t.trxId = :trxId
""")
void updateStatusAndTime(String trxId, String status, long time);

}
