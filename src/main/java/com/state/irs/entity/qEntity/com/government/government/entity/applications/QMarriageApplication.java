package com.government.government.entity.applications;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMarriageApplication is a Querydsl query type for MarriageApplication
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMarriageApplication extends EntityPathBase<MarriageApplication> {

    private static final long serialVersionUID = 1137896921L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMarriageApplication marriageApplication = new QMarriageApplication("marriageApplication");

    public final com.government.government.entity.QStatusEntity _super;

    public final StringPath applicationId = createString("applicationId");

    public final EnumPath<com.government.government.Enum.ApprovalStatus> approvalStatus = createEnum("approvalStatus", com.government.government.Enum.ApprovalStatus.class);

    public final StringPath brideAddress = createString("brideAddress");

    public final StringPath bridebusstop = createString("bridebusstop");

    public final StringPath brideDOB = createString("brideDOB");

    public final StringPath brideFatherAddress = createString("brideFatherAddress");

    public final StringPath brideFatherFirstName = createString("brideFatherFirstName");

    public final StringPath brideFatherLastName = createString("brideFatherLastName");

    public final StringPath brideFatherMiddleName = createString("brideFatherMiddleName");

    public final StringPath brideFatherOccupation = createString("brideFatherOccupation");

    public final StringPath brideFirstName = createString("brideFirstName");

    public final StringPath brideLandmark = createString("brideLandmark");

    public final StringPath brideLastName = createString("brideLastName");

    public final StringPath brideMiddleName = createString("brideMiddleName");

    public final StringPath brideOccupation = createString("brideOccupation");

    public final StringPath bridePhonenumber = createString("bridePhonenumber");

    public final StringPath brideSignature = createString("brideSignature");

    public final StringPath brideWitnessAddress = createString("brideWitnessAddress");

    public final StringPath brideWitnessFirstName = createString("brideWitnessFirstName");

    public final StringPath brideWitnessLastName = createString("brideWitnessLastName");

    public final StringPath brideWitnessMiddleName = createString("brideWitnessMiddleName");

    public final StringPath brideWitnessOccupation = createString("brideWitnessOccupation");

    public final StringPath brideWitnessSignature = createString("brideWitnessSignature");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final com.government.government.entity.QUsers createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final com.government.government.entity.QUsers deactivatedBy;

    public final StringPath groomAddress = createString("groomAddress");

    public final StringPath groombusstop = createString("groombusstop");

    public final StringPath groomDOB = createString("groomDOB");

    public final StringPath groomFatherAddress = createString("groomFatherAddress");

    public final StringPath groomFatherFirstName = createString("groomFatherFirstName");

    public final StringPath groomFatherLastName = createString("groomFatherLastName");

    public final StringPath groomFatherMiddleName = createString("groomFatherMiddleName");

    public final StringPath groomFatherOccupation = createString("groomFatherOccupation");

    public final StringPath groomFirstName = createString("groomFirstName");

    public final StringPath groomLandmark = createString("groomLandmark");

    public final StringPath groomLastName = createString("groomLastName");

    public final StringPath groomMiddleName = createString("groomMiddleName");

    public final StringPath groomOccupation = createString("groomOccupation");

    public final StringPath groomPhonenumber = createString("groomPhonenumber");

    public final StringPath groomSignature = createString("groomSignature");

    public final StringPath groomWitnessAddress = createString("groomWitnessAddress");

    public final StringPath groomWitnessFirstName = createString("groomWitnessFirstName");

    public final StringPath groomWitnessLastName = createString("groomWitnessLastName");

    public final StringPath groomWitnessMiddleName = createString("groomWitnessMiddleName");

    public final StringPath groomWitnessOccupation = createString("groomWitnessOccupation");

    public final StringPath groomWitnessSignature = createString("groomWitnessSignature");

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    // inherited
    public final com.government.government.entity.QUsers lastUpdatedBy;

    public final StringPath marriageDate = createString("marriageDate");

    public final EnumPath<com.government.government.Enum.PaymentStatus> paymentStatus = createEnum("paymentStatus", com.government.government.Enum.PaymentStatus.class);

    //inherited
    public final EnumPath<com.government.government.Enum.GenericStatusConstant> status;

    public QMarriageApplication(String variable) {
        this(MarriageApplication.class, forVariable(variable), INITS);
    }

    public QMarriageApplication(Path<? extends MarriageApplication> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMarriageApplication(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMarriageApplication(PathMetadata metadata, PathInits inits) {
        this(MarriageApplication.class, metadata, inits);
    }

    public QMarriageApplication(Class<? extends MarriageApplication> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.government.government.entity.QStatusEntity(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.dateDeactivated = _super.dateDeactivated;
        this.deactivatedBy = _super.deactivatedBy;
        this.id = _super.id;
        this.lastUpdatedAt = _super.lastUpdatedAt;
        this.lastUpdatedBy = _super.lastUpdatedBy;
        this.status = _super.status;
    }

}

