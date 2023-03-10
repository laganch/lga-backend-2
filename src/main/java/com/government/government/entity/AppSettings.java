package com.government.government.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "APP_SETTING")
public class AppSettings extends StatusEntity{

    private String logo;
    private String banner;
    private String color;

    @ManyToOne
    @JoinColumn(name = "LGA_ID", referencedColumnName = "id", nullable = false)
    private Lga lga;

    @ManyToOne
    @JoinColumn(name = "STATE_ID", referencedColumnName = "id", nullable = false)
    private State state;

}
