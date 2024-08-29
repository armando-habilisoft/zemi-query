package org.habilisoft.zemi.query;

import graphql.schema.DataFetchingEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.query.AbstractSortStrategy;
import org.springframework.graphql.data.query.SortStrategy;
import org.springframework.lang.NonNull;

import java.util.List;

@Configuration
public class GraphqlConfig {
    @Bean
    SortStrategy sortStrategy() {
        return new AbstractSortStrategy() {
            @Override
            protected List<String> getProperties(@NonNull DataFetchingEnvironment environment) {
                return environment.getArgument("sort");
            }
            @Override
            protected Sort.Direction getDirection(@NonNull DataFetchingEnvironment environment) {
                return Sort.Direction.fromOptionalString(environment.getArgument("direction")).orElse(null);
            }
        };
    }
}
