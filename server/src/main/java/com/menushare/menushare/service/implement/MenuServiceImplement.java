package com.menushare.menushare.service.implement;

import com.menushare.menushare.model.Menu;
import com.menushare.menushare.model.MenuRequest;
import com.menushare.menushare.model.QrCode;
import com.menushare.menushare.repo.MenuRepo;
import com.menushare.menushare.repo.QrCodeRepo;
import com.menushare.menushare.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MenuServiceImplement implements MenuService {

    private MenuRepo menuRepo;
    private QrCodeRepo qrCodeRepo;

    @Override
    public List<Menu>  getMenu() {
        List<Menu> me = menuRepo.findAll();
        return me;
    }

    @Override
    @Transactional
    public Menu createMenu(MenuRequest menu) {
        QrCode qrCode = new QrCode(menu.getQrUniqueCode(),menu.getUrl());
        if(qrCode != null) {
            qrCodeRepo.save(qrCode);
        }
        Menu menuObj = new Menu(menu.getItemName(), menu.getItemDescription(), menu.getItemPrice());
        menuObj.setQrCodes(qrCode);
        menuRepo.save(menuObj);
        return null;
    }

    @Override
    public Menu findMenu(Long menuId) {
        Optional<Menu> menu = menuRepo.findById(menuId);
        Menu foundMenu = null;
        if(menu.isPresent()) {
            foundMenu =  menu.get();
        }
        return foundMenu;
    }
}
