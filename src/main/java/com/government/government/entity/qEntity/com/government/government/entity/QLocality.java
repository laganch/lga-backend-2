package com.government.government.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocality is a Querydsl query type for Locality
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocality extends EntityPathBase<Locality> {

    private static final long serialVersionUID = -670577503L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocality locality = new QLocality("locality");

    public final QArea area;

    public final StringPath code = createString("code");

    public final DateTimePath<java.util.Date> dateCreated = createDateTime("dateCreated", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateUpdated = createDateTime("dateUpdated", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QLocality(String variable) {
        this(Locality.class, forVariable(variable), INITS);
    }

    public QLocality(Path<? extends Locality> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocality(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocality(PathMetadata metadata, PathInits inits) {
        this(Locality.class, metadata, inits);
    }

    public QLocality(Class<? extends Locality> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.area = inits.isInitialized("area") ? new QArea(forProperty("area"), inits.get("area")) : null;
    }

}

