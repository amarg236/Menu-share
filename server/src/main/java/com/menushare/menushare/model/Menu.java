package com.menushare.menushare.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private String itemDescription;

    private Long itemPrice;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "qr_code_id")
    private QrCode qrCodes;

    public Menu(String itemName, String itemDescription, Long itemPrice) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }


}
