package com.government.government.dto;

import com.government.government.Enum.ApprovalStatus;
import com.government.government.Enum.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BirthDto {

    private ApprovalStatus approvalStatus;
    private PaymentStatus paymentStatus;
    private String applicationId;
    private LocalDateTime timeCreated;

    private String hospital;
    private String  father;
    private String mother;
    private LocalDateTime dob;
    private String weight;
    private String time;
    private String phoneNumber;
    private String gender;
    private String state;
    private String lga;
    private String city;
    private String address;
}
