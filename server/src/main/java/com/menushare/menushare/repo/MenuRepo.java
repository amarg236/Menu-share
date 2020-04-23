package com.menushare.menushare.repo;

import com.menushare.menushare.model.Menu;
import com.menushare.menushare.model.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MenuRepo extends JpaRepository<Menu, Long> {
    Optional<Menu> findByQrCodes(QrCode code);
}
