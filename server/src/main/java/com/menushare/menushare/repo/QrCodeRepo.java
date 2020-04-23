package com.menushare.menushare.repo;

import com.menushare.menushare.model.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QrCodeRepo extends JpaRepository<QrCode, Long> {
    Optional<QrCode> findByQrUniqueCode(String code);
}
