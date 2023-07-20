package com.government.government.entity.applications;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDeathApplications is a Querydsl query type for DeathApplications
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDeathApplications extends EntityPathBase<DeathApplications> {

    private static final long serialVersionUID = -1299234262L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDeathApplications deathApplications = new QDeathApplications("deathApplications");

    public final com.government.government.entity.QStatusEntity _super;

    public final StringPath alternateNumber = createString("alternateNumber");

    public final StringPath applicantFirstName = createString("applicantFirstName");

    public final StringPath applicantLastName = createString("applicantLastName");

    public final StringPath applicantOccupation = createString("applicantOccupation");

    public final StringPath applicantPhonenumber = createString("applicantPhonenumber");

    public final StringPath applicationId = createString("applicationId");

    public final EnumPath<com.government.government.Enum.ApprovalStatus> approvalStatus = createEnum("approvalStatus", com.government.government.Enum.ApprovalStatus.class);

    public final StringPath buriedDate = createString("buriedDate");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final com.government.government.entity.QUsers createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final com.government.government.entity.QUsers deactivatedBy;

    public final StringPath deathDate = createString("deathDate");

    public final StringPath deceasedAddress = createString("deceasedAddress");

    public final StringPath deceasedbusstop = createString("deceasedbusstop");

    public final StringPath deceasedFirstName = createString("deceasedFirstName");

    public final StringPath deceasedLandmark = createString("deceasedLandmark");

    public final StringPath deceasedLastName = createString("deceasedLastName");

    public final StringPath deceasedMiddleName = createString("deceasedMiddleName");

    public final StringPath deceasedOccupation = createString("deceasedOccupation");

    public final StringPath hospital = createString("hospital");

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    // inherited
    public final com.government.government.entity.QUsers lastUpdatedBy;

    public final EnumPath<com.government.government.Enum.PaymentStatus> paymentStatus = createEnum("paymentStatus", com.government.government.Enum.PaymentStatus.class);

    public final StringPath reason = createString("reason");

    public final StringPath relationship = createString("relationship");

    //inherited
    public final EnumPath<com.government.government.Enum.GenericStatusConstant> status;

    public QDeathApplications(String variable) {
        this(DeathApplications.class, forVariable(variable), INITS);
    }

    public QDeathApplications(Path<? extends DeathApplications> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDeathApplications(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDeathApplications(PathMetadata metadata, PathInits inits) {
        this(DeathApplications.class, metadata, inits);
    }

    public QDeathApplications(Class<? extends DeathApplications> type, PathMetadata metadata, PathInits inits) {
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

