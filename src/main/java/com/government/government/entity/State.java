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
@Table(name = "STATE")
@Builder
public class State {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "LOGO", nullable = true)
    private String logo;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "STATE_SLOGAN")
    private String stateSlogan;

    @Column(name = "ZONE_FK")
    private String zoneFk;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "id")
    private Country country;
}
