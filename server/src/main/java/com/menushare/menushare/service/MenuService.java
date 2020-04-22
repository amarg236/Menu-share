package com.menushare.menushare.service;

import com.menushare.menushare.model.Menu;
import com.menushare.menushare.model.MenuRequest;

import java.util.List;

public interface MenuService {
    List<Menu> getMenu();
    Menu createMenu(MenuRequest menu);
}
