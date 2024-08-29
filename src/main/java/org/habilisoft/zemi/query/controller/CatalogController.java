package org.habilisoft.zemi.query.controller;

import graphql.relay.Connection;
import graphql.relay.DefaultConnection;
import graphql.relay.DefaultPageInfo;
import lombok.RequiredArgsConstructor;
import org.habilisoft.zemi.query.model.Product;
import org.habilisoft.zemi.query.repository.ProductRepository;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.ScrollPosition;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Window;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.query.ScrollSubrange;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CatalogController {
    private final ProductRepository productRepository;

    @QueryMapping
    public Window<Product> products(ScrollSubrange scrollSubrange, Optional<Sort> optionalSort) {
        ScrollPosition scrollPosition = scrollSubrange.position().orElse(ScrollPosition.offset());
        Limit limit = Limit.of(scrollSubrange.count().orElse(10));
        Sort sort = optionalSort.orElseGet(() -> Sort.by("id").ascending());
        return productRepository.findBy(scrollPosition, limit, sort);
    }
}
