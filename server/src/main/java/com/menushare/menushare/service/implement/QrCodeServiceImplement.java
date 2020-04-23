package com.menushare.menushare.service.implement;

import com.menushare.menushare.model.Menu;
import com.menushare.menushare.model.QrCode;
import com.menushare.menushare.repo.MenuRepo;
import com.menushare.menushare.repo.QrCodeRepo;
import com.menushare.menushare.service.QrCodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class QrCodeServiceImplement implements QrCodeService {

    private final QrCodeRepo qrCodeRepo;
    private final MenuRepo menuRepo;

    @Override
    public Menu decode(String code) {
        Optional<QrCode> qrCode = qrCodeRepo.findByQrUniqueCode(code);
        Menu foundMenu = null;
        if(qrCode.isPresent()) {
            QrCode decoded = qrCode.get();
            foundMenu = menuRepo.findByQrCodes(decoded).get();
        }
        return foundMenu;
    }
}
