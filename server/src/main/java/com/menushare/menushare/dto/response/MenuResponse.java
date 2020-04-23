package com.menushare.menushare.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuResponse {
    private String itemName;
    private String itemDescription;
    private Long itemPrice;
}
