package com.menushare.menushare.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName roleName;

    public Role(){

    }

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }
}
