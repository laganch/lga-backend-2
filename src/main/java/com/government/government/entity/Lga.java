package com.government.government.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LGA")
@Builder
public class Lga {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "LOGO", nullable = true)
    private String logo;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "STATE_SLOGAN")
    private String lgaSlogan;

    @Column(name = "ZONE_FK")
    private String zoneFk;

    @ManyToOne
    @JoinColumn(name = "STATE_ID", referencedColumnName = "id")
    private State state;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "BANNER")
    private String banner;

    @Column(name = "APP_NAME")
    private String appName;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "ALTERNATE_CONTACT")
    private String alternate;

    @Column(name = "DESCRIPTION")
    private String description;
}