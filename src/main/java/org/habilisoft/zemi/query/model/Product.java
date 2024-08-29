package org.habilisoft.zemi.query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "products")
public class Product {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Category category;
}
