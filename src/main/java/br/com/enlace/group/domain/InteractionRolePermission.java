package br.com.enlace.group.domain;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "interaction_role_permission")
public class InteractionRolePermission extends PanacheEntity {

    private String role;

    @Enumerated(EnumType.STRING)
    private InteractionType type; // "INVITE", "POST", "MODERATE"

    @ManyToOne
    @JoinColumn(name = "interaction_rules_id")
    private InteractionRules interactionRules;
}
