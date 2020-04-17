package com.menushare.menushare.service.implement;

import com.menushare.menushare.model.Menu;
import com.menushare.menushare.repo.MenuRepo;
import com.menushare.menushare.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class MenuServiceImplement implements MenuService {

    @Autowired
    private MenuRepo menuRepo;


    @Override
    public List<Menu>  getMenu() {
        List<Menu> me = menuRepo.findAll();
        return me;
    }
}
