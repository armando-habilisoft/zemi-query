package org.habilisoft.zemi.tenant;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

@Getter
@Setter
@Entity
@Table(name = "tenants", schema = "public")
class Tenant extends AbstractAggregateRoot<Tenant> {
    @EmbeddedId
    private TenantId id;
}
