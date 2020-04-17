package com.menushare.menushare.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class QrCode {
    @Id
    private Long menuId;
    private String qrId;
    private String url;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Menu menuList;

}
