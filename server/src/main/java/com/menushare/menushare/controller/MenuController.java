package com.menushare.menushare.controller;

import com.menushare.menushare.model.Menu;
import com.menushare.menushare.model.MenuRequest;
import com.menushare.menushare.model.QrCode;
import com.menushare.menushare.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/getMenu")
    public List<Menu> getMenuItem(){

        return menuService.getMenu();
    }

    @PostMapping("/createMenu")
    public MenuRequest createMenu(@RequestBody MenuRequest menuRequest){



        menuService.createMenu(menuRequest);
        return menuRequest;
    }






}
