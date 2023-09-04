package com.government.government.entity.applications;

import com.government.government.Enum.ApprovalStatus;
import com.government.government.Enum.PaymentStatus;
import com.government.government.entity.StatusEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "BIRTH_APPLICATION")
public class BirthApplication extends StatusEntity {

    private String  babyFirstName;
    private String  babyLastName;
    private String babyMiddleName;
    private String gender;
    private String hospital;
    private String  fatherFirstName;
    private String  fatherLastName;
    private String motherFirstName;
    private String motherLastName;
    private LocalDateTime dob;
    private String weight;
    private String time;
    private String phoneNumber;
    private String state;
    private String lga;
    private String city;
    private String address;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.NOT_PAID;

    private String reason;
    private String applicationId = "B-" + LocalDate.now().getYear()+ (int)(Math.random()* 1234607);
}
