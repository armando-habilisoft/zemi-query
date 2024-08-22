package org.habilisoft.zemi.query.repository;

import com.querydsl.core.types.dsl.StringExpression;
import org.habilisoft.zemi.query.model.Product;
import org.habilisoft.zemi.query.model.QProduct;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.Repository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface ProductRepository extends
        Repository<Product, Long>,
        QuerydslPredicateExecutor<Product>,
        QuerydslBinderCustomizer<QProduct> {

    @Override
    default void customize(QuerydslBindings bindings, QProduct product) {
        bindings.bind(product.name)
                .first(StringExpression::containsIgnoreCase);
    }
}
