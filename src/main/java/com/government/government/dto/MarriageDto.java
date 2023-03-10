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

    private String groomDOB;
    private String brideDOB;
    private String marriageDate;
    private String groomPhonenumber;
    private String bridePhonenumber;


    private String brideFatherFirstName;
    private String brideFatherLastName;
    private String brideFatherMiddleName;
    private String brideFatherOccupation;
    private String brideFatherAddress;

    private String brideWitnessFirstName;
    private String brideWitnessLastName;
    private String brideWitnessMiddleName;
    private String brideWitnessOccupation;
    private String brideWitnessAddress;


    private String groomFatherFirstName;
    private String groomFatherLastName;
    private String groomFatherMiddleName;
    private String groomFatherOccupation;
    private String groomFatherAddress;

    private String groomWitnessFirstName;
    private String groomWitnessLastName;
    private String groomWitnessMiddleName;
    private String groomWitnessOccupation;
    private String groomWitnessAddress;

    private String groomSignature;
    private String brideSignature;
    private String brideWitnessSignature;
    private String groomWitnessSignature;

    private ApprovalStatus approvalStatus;
    private PaymentStatus paymentStatus;
    private String applicationId;
    private LocalDateTime timeCreated;
}
