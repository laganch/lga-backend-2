package com.government.government.entity.applications;

import com.government.government.Enum.ApprovalStatus;
import com.government.government.Enum.PaymentStatus;
import com.government.government.entity.StatusEntity;
import com.government.government.entity.Users;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "DEATH_APPLICATION")
public class DeathApplications extends StatusEntity {
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
    private String reason;

    private String alternateNumber;
    private String applicationId  = "D-" + LocalDate.now().getYear()+ (int)(Math.random()* 1234607);
    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING;
    private PaymentStatus paymentStatus = PaymentStatus.NOT_PAID;
}
