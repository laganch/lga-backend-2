package com.government.government.entity;

import com.government.government.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class Users extends StatusEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "other_names")
    private String otherNames;

    @Column(name = "email",
            nullable = false,
            unique = true,
            length = 1024)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "generated_password")
    private String generatedPassword;

    @Column(
            name = "username",
            nullable = false,
            unique = true,
            length = 1024
    )
    private String username;


    @Column(name = "date_of_birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @Column(
            name = "display_name",
            nullable = false,
            length = 1024
    )
    private String displayName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "setup_complete")
    private Boolean setupComplete;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "preferred_name")
    private String preferredName;

    private Boolean userVerified;

    @Column(name = "ROLES")
    private String roles;

    @Column(name = "PRIVILIAGES")
    private String priviliages;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToOne
    @JoinColumn(name = "AREA_ID", referencedColumnName = "id", nullable = true)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "STATE_ID", referencedColumnName = "id", nullable = true)
    private State state;

    @ManyToOne
    @JoinColumn(name = "LGA_ID", referencedColumnName = "id", nullable = true)
    private Lga lga;
}
