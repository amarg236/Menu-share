package com.menushare.menushare.controller;

import com.menushare.menushare.model.Menu;
import com.menushare.menushare.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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






}
