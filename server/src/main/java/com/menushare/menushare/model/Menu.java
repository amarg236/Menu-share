package com.menushare.menushare.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private String itemDescription;

    private Long itemPrice;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private QrCode qrCodes;


}
