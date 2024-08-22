package org.habilisoft.zemi.query.repository;

import com.querydsl.core.types.dsl.StringExpression;
import org.habilisoft.zemi.query.model.QUser;
import org.habilisoft.zemi.query.model.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.Repository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface UserRepository extends
        Repository<User, String>,
        QuerydslPredicateExecutor<User>,
        QuerydslBinderCustomizer<QUser> {

    @Override
    default void customize(QuerydslBindings bindings, QUser user) {
        bindings.bind(user.name)
                .first(StringExpression::containsIgnoreCase);
    }
}
