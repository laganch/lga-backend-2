package com.government.government.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppModules is a Querydsl query type for AppModules
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAppModules extends EntityPathBase<AppModules> {

    private static final long serialVersionUID = 867091940L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAppModules appModules = new QAppModules("appModules");

    public final QStatusEntity _super;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final QUsers createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> dateDeactivated;

    // inherited
    public final QUsers deactivatedBy;

    public final StringPath icon = createString("icon");

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt;

    // inherited
    public final QUsers lastUpdatedBy;

    public final BooleanPath ModuleStatus = createBoolean("ModuleStatus");

    public final StringPath name = createString("name");

    //inherited
    public final EnumPath<com.government.government.Enum.GenericStatusConstant> status;

    public final StringPath uri = createString("uri");

    public QAppModules(String variable) {
        this(AppModules.class, forVariable(variable), INITS);
    }

    public QAppModules(Path<? extends AppModules> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAppModules(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAppModules(PathMetadata metadata, PathInits inits) {
        this(AppModules.class, metadata, inits);
    }

    public QAppModules(Class<? extends AppModules> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QStatusEntity(type, metadata, inits);
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

