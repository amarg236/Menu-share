package com.menushare.menushare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuRequest {

    private String itemName;

    private String itemDescription;

    private Long itemPrice;

    private String qrUniqueCode;

    private String url;
}
