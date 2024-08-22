package org.habilisoft.zemi.query.repository;

import com.querydsl.core.types.dsl.StringExpression;
import org.habilisoft.zemi.query.model.Category;
import org.habilisoft.zemi.query.model.QCategory;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.Repository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface CategoryRepository extends
        Repository<Category, Long>,
        QuerydslPredicateExecutor<Category>,
        QuerydslBinderCustomizer<QCategory>
{

    @Override
    default void customize(QuerydslBindings bindings, QCategory category) {
        bindings.bind(category.name)
                .first(StringExpression::containsIgnoreCase);
    }
}
