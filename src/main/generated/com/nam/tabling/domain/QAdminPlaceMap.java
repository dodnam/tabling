package com.nam.tabling.domain;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;

import javax.annotation.Generated;
import java.time.LocalDateTime;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdminPlaceMap extends EntityPathBase<AdminPlaceMap> {

    private static final long serialVersionUID = 1010157086L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAdminPlaceMap adminPlaceMap = new QAdminPlaceMap("adminPlaceMap");

    public final QAdmin admin;

    public final DateTimePath<LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final QPlace place;

    public QAdminPlaceMap(String variable) {
        this(AdminPlaceMap.class, forVariable(variable), INITS);
    }

    public QAdminPlaceMap(Path<? extends AdminPlaceMap> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAdminPlaceMap(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAdminPlaceMap(PathMetadata metadata, PathInits inits) {
        this(AdminPlaceMap.class, metadata, inits);
    }

    public QAdminPlaceMap(Class<? extends AdminPlaceMap> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.admin = inits.isInitialized("admin") ? new QAdmin(forProperty("admin")) : null;
        this.place = inits.isInitialized("place") ? new QPlace(forProperty("place")) : null;
    }

}
