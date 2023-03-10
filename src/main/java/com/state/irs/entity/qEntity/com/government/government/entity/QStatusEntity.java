package com.government.government.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStatusEntity is a Querydsl query type for StatusEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QStatusEntity extends EntityPathBase<StatusEntity> {

    private static final long serialVersionUID = 1581474483L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStatusEntity statusEntity = new QStatusEntity("statusEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final QUsers createdBy;

    public final DateTimePath<java.time.LocalDateTime> dateDeactivated = createDateTime("dateDeactivated", java.time.LocalDateTime.class);

    public final QUsers deactivatedBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt = createDateTime("lastUpdatedAt", java.time.LocalDateTime.class);

    public final QUsers lastUpdatedBy;

    public final EnumPath<com.government.government.Enum.GenericStatusConstant> status = createEnum("status", com.government.government.Enum.GenericStatusConstant.class);

    public QStatusEntity(String variable) {
        this(StatusEntity.class, forVariable(variable), INITS);
    }

    public QStatusEntity(Path<? extends StatusEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStatusEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStatusEntity(PathMetadata metadata, PathInits inits) {
        this(StatusEntity.class, metadata, inits);
    }

    public QStatusEntity(Class<? extends StatusEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new QUsers(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.deactivatedBy = inits.isInitialized("deactivatedBy") ? new QUsers(forProperty("deactivatedBy"), inits.get("deactivatedBy")) : null;
        this.lastUpdatedBy = inits.isInitialized("lastUpdatedBy") ? new QUsers(forProperty("lastUpdatedBy"), inits.get("lastUpdatedBy")) : null;
    }

}

