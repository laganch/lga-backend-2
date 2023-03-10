package com.government.government.dto;

import com.government.government.Enum.ApprovalStatus;
import com.government.government.Enum.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationDto {
    private String deceasedFirstName;
    private String deceasedLastName;
    private String deceasedMiddleName;
    private String deceasedOccupation;
    private String deceasedAddress;
    private String deceasedbusstop;
    private String deceasedLandmark;
    private String deathDate;
    private String buriedDate;
    private String hospital;
    private String applicantFirstName;
    private String applicantLastName;
    private String applicantOccupation;
    private String relationship;
    private String applicantPhonenumber;
    private String alternateNumber;
    private String applicationId;
    private PaymentStatus paymentStatus;
    private ApprovalStatus approvalStatus;
    private LocalDateTime timeCreated;
}
