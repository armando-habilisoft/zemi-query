package org.habilisoft.zemi.query.repository;

import org.habilisoft.zemi.query.model.Category;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.Repository;

public interface CategoryRepository extends Repository<Category, Long>, QuerydslPredicateExecutor<Category> {
}
