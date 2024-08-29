package org.habilisoft.zemi.query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "categories")
@EqualsAndHashCode(of = "id")
public class Category {
    @Id
    private Long id;
    private String name;
}
