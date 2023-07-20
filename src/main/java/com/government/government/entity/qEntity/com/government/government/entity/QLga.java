package com.government.government.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLga is a Querydsl query type for Lga
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLga extends EntityPathBase<Lga> {

    private static final long serialVersionUID = -44776376L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLga lga = new QLga("lga");

    public final StringPath alternate = createString("alternate");

    public final StringPath appName = createString("appName");

    public final StringPath banner = createString("banner");

    public final StringPath code = createString("code");

    public final StringPath color = createString("color");

    public final StringPath contact = createString("contact");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lgaSlogan = createString("lgaSlogan");

    public final StringPath logo = createString("logo");

    public final StringPath name = createString("name");

    public final QState state;

    public final StringPath website = createString("website");

    public final StringPath zoneFk = createString("zoneFk");

    public QLga(String variable) {
        this(Lga.class, forVariable(variable), INITS);
    }

    public QLga(Path<? extends Lga> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLga(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLga(PathMetadata metadata, PathInits inits) {
        this(Lga.class, metadata, inits);
    }

    public QLga(Class<? extends Lga> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.state = inits.isInitialized("state") ? new QState(forProperty("state"), inits.get("state")) : null;
    }

}

