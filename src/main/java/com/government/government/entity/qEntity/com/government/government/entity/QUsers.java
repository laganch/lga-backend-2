package com.government.government.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = -71747702L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsers users = new QUsers("users");

    public final QStatusEntity _super;

    public final StringPath address = createString("address");

    public final QArea area;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final QUsers createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    public final DateTimePath<java.util.Date> dateOfBirth = createDateTime("dateOfBirth", java.util.Date.class);

    // inherited
    public final QUsers deactivatedBy;

    public final StringPath displayName = createString("displayName");

    public final StringPath email = createString("email");

    public final BooleanPath emailVerified = createBoolean("emailVerified");

    public final StringPath firstName = createString("firstName");

    public final EnumPath<com.government.government.Enum.Gender> gender = createEnum("gender", com.government.government.Enum.Gender.class);

    public final StringPath generatedPassword = createString("generatedPassword");

    //inherited
    public final NumberPath<Long> id;

    public final BooleanPath isActive = createBoolean("isActive");

    public final StringPath lastName = createString("lastName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    // inherited
    public final QUsers lastUpdatedBy;

    public final QLga lga;

    public final StringPath otherNames = createString("otherNames");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath preferredName = createString("preferredName");

    public final StringPath priviliages = createString("priviliages");

    public final StringPath roles = createString("roles");

    public final BooleanPath setupComplete = createBoolean("setupComplete");

    public final QState state;

    //inherited
    public final EnumPath<com.government.government.Enum.GenericStatusConstant> status;

    public final StringPath username = createString("username");

    public final BooleanPath userVerified = createBoolean("userVerified");

    public QUsers(String variable) {
        this(Users.class, forVariable(variable), INITS);
    }

    public QUsers(Path<? extends Users> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsers(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsers(PathMetadata metadata, PathInits inits) {
        this(Users.class, metadata, inits);
    }

    public QUsers(Class<? extends Users> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QStatusEntity(type, metadata, inits);
        this.area = inits.isInitialized("area") ? new QArea(forProperty("area"), inits.get("area")) : null;
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.dateDeactivated = _super.dateDeactivated;
        this.deactivatedBy = _super.deactivatedBy;
        this.id = _super.id;
        this.lastUpdatedAt = _super.lastUpdatedAt;
        this.lastUpdatedBy = _super.lastUpdatedBy;
        this.lga = inits.isInitialized("lga") ? new QLga(forProperty("lga"), inits.get("lga")) : null;
        this.state = inits.isInitialized("state") ? new QState(forProperty("state"), inits.get("state")) : null;
        this.status = _super.status;
    }

}

