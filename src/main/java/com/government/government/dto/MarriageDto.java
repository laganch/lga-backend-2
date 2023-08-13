package com.government.government.dto;

import com.government.government.Enum.ApprovalStatus;
import com.government.government.Enum.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MarriageDto {
    private String groomFirstName;
    private String groomLastName;
    private String groomMiddleName;
    private String groomOccupation;
    private String groomAddress;
    private String groombusstop;
    private String groomLandmark;

    private String brideFirstName;
    private String brideLastName;
    private String brideMiddleName;
    private String brideOccupation;
    private String brideAddress;
    private String bridebusstop;
    private String brideLandmark;

    private String marriageDate;
    private String groomPhonenumber;
    private String bridePhonenumber;

    private String groomSignature;
    private String brideSignature;
    private String brideWitnessSignature;
    private String groomWitnessSignature;

    private ApprovalStatus approvalStatus;
    private PaymentStatus paymentStatus;
    private String applicationId;
    private LocalDateTime timeCreated;

    private String church;
    private String  weddingDate;
    private String brideGender;
    private String brideName;
    private String brideParentAddress;
    private String groomWitnessName;
    private String groomParentAddress;
    private String groomParentName;
    private String churchAddress;
    private String priest;
}
