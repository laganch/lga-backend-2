package com.government.government.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "APP_SETTING")
public class AppModules extends StatusEntity{
    private String name;
    private Boolean ModuleStatus;
    private String uri;
    private String icon;
}
