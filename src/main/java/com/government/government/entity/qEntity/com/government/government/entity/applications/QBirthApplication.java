package com.government.government.entity.applications;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBirthApplication is a Querydsl query type for BirthApplication
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBirthApplication extends EntityPathBase<BirthApplication> {

    private static final long serialVersionUID = 2017098814L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBirthApplication birthApplication = new QBirthApplication("birthApplication");

    public final com.government.government.entity.QStatusEntity _super;

    public final StringPath applicationId = createString("applicationId");

    public final EnumPath<com.government.government.Enum.ApprovalStatus> approvalStatus = createEnum("approvalStatus", com.government.government.Enum.ApprovalStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final com.government.government.entity.QUsers createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final com.government.government.entity.QUsers deactivatedBy;

    public final com.government.government.entity.QUsers groom;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    // inherited
    public final com.government.government.entity.QUsers lastUpdatedBy;

    public final EnumPath<com.government.government.Enum.PaymentStatus> paymentStatus = createEnum("paymentStatus", com.government.government.Enum.PaymentStatus.class);

    public final StringPath reason = createString("reason");

    //inherited
    public final EnumPath<com.government.government.Enum.GenericStatusConstant> status;

    public QBirthApplication(String variable) {
        this(BirthApplication.class, forVariable(variable), INITS);
    }

    public QBirthApplication(Path<? extends BirthApplication> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBirthApplication(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBirthApplication(PathMetadata metadata, PathInits inits) {
        this(BirthApplication.class, metadata, inits);
    }

    public QBirthApplication(Class<? extends BirthApplication> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.government.government.entity.QStatusEntity(type, metadata, inits);
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.dateDeactivated = _super.dateDeactivated;
        this.deactivatedBy = _super.deactivatedBy;
        this.groom = inits.isInitialized("groom") ? new com.government.government.entity.QUsers(forProperty("groom"), inits.get("groom")) : null;
        this.id = _super.id;
        this.lastUpdatedAt = _super.lastUpdatedAt;
        this.lastUpdatedBy = _super.lastUpdatedBy;
        this.status = _super.status;
    }

}

