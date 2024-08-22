package org.habilisoft.zemi.query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Created on 21/8/24.
 */
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Category category;
}
