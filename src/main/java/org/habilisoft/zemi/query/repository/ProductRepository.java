package org.habilisoft.zemi.query.repository;

import org.habilisoft.zemi.query.model.Product;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.ScrollPosition;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Window;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product, Long>, QuerydslPredicateExecutor<Product> {

    Window<Product> findBy(ScrollPosition scrollPosition, Limit limit, Sort sort);
}
