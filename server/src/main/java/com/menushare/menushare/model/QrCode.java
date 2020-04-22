package com.menushare.menushare.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class QrCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String qrUniqueCode;
    private String url;

    public QrCode(String qrUniqueCode, String url) {
        this.qrUniqueCode = qrUniqueCode;
        this.url = url;
    }


}
