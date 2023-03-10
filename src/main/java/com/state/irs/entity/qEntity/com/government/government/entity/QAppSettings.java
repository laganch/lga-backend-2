package com.government.government.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppSettings is a Querydsl query type for AppSettings
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAppSettings extends EntityPathBase<AppSettings> {

    private static final long serialVersionUID = -1146033818L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAppSettings appSettings = new QAppSettings("appSettings");

    public final QStatusEntity _super;

    public final StringPath banner = createString("banner");

    public final StringPath color = createString("color");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final QUsers createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final QUsers deactivatedBy;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    // inherited
    public final QUsers lastUpdatedBy;

    public final QLga lga;

    public final StringPath logo = createString("logo");

    public final QState state;

    //inherited
    public final EnumPath<com.government.government.Enum.GenericStatusConstant> status;

    public QAppSettings(String variable) {
        this(AppSettings.class, forVariable(variable), INITS);
    }

    public QAppSettings(Path<? extends AppSettings> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAppSettings(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAppSettings(PathMetadata metadata, PathInits inits) {
        this(AppSettings.class, metadata, inits);
    }

    public QAppSettings(Class<? extends AppSettings> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QStatusEntity(type, metadata, inits);
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

