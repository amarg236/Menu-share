package com.menushare.menushare.service;

import com.menushare.menushare.model.Menu;

public interface QrCodeService {
    public Menu decode(String code);
}
