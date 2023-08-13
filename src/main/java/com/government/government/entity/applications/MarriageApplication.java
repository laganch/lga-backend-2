package com.government.government.entity.applications;


import com.government.government.Enum.ApprovalStatus;
import com.government.government.Enum.PaymentStatus;
import com.government.government.entity.State;
import com.government.government.entity.StatusEntity;
import com.government.government.entity.Users;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "MARRIAGE_APPLICATION")
public class MarriageApplication extends StatusEntity {

    private String groomFirstName;
    private String groomLastName;
    private String groomMiddleName;
    private String groomOccupation;
    private String groomAddress;

    private String brideFirstName;
    private String brideLastName;
    private String brideMiddleName;
    private String brideOccupation;
    private String brideAddress;

    private String marriageDate;
    private String groomPhoneNumber;
    private String bridePhoneNumber;

    private String groomSignature;
    private String brideSignature;
    private String brideWitnessSignature;
    private String groomWitnessSignature;

    private String church;
    private String  weddingDate;
    private String brideGender;
    private String brideParentName;
    private String brideParentAddress;
    private String groomWitnessName;
    private String groomParentAddress;
    private String groomParentName;
    private String churchAddress;
    private String priest;


    @ManyToOne
    @JoinColumn(name = "GROOM_ID", referencedColumnName = "id")
    private Users groom;


    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.NOT_PAID;

    private String applicationId = "M-" + LocalDate.now().getYear()+ (int)(Math.random()* 1234607);
}
