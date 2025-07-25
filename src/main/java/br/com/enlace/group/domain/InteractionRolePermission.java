package br.com.enlace.group.domain;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "interaction_role_permission")
public class InteractionRolePermission extends PanacheEntityBase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String role;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private InteractionType type; // "INVITE", "POST", "MODERATE"

    @ManyToOne
    @JoinColumn(name = "interaction_rules_id")
    private InteractionRules interactionRules;

    public InteractionRolePermission() {
    }

    public InteractionRolePermission(Long id, String role, InteractionType type, InteractionRules interactionRules) {
        this.id = id;
        this.role = role;
        this.type = type;
        this.interactionRules = interactionRules;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public InteractionType getType() {
        return type;
    }

    public InteractionRules getInteractionRules() {
        return interactionRules;
    }
}
