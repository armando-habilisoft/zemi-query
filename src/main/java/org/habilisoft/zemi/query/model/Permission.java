package org.habilisoft.zemi.query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Created on 21/8/24.
 */
@Getter
@Setter
@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    private String name;
    private String description;
    private String module;
}
