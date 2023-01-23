package com.nam.tabling.repository;

import com.nam.tabling.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends
        JpaRepository<Place, Long>
//        QuerydslPredicateExecutor<Place>,
//        QuerydslBinderCustomizer<QPlace>
{
//
//    @Override
//    default void customize(QuerydslBindings bindings, QPlace root) {
//        bindings.excludeUnlistedProperties(true);
//        bindings.including(root.placeName, root.address, root.phoneNumber);
//        bindings.bind(root.placeName).first(StringExpression::containsIgnoreCase);
//        bindings.bind(root.address).first(StringExpression::containsIgnoreCase);
//        bindings.bind(root.phoneNumber).first(StringExpression::containsIgnoreCase);
//    }

}
