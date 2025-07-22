package br.com.enlace.group.domain;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "interaction_rules")
public class InteractionRules extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "interactionRules", fetch = FetchType.LAZY)
    private Group group;

    @Enumerated(EnumType.STRING)
    @Column(name = "visibility_level", nullable = false)
    private VisibilityLevel visibilityLevel;

    @OneToMany(mappedBy = "interactionRules", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InteractionRolePermission> permissions = new ArrayList<>();

    @Column(name = "max_members", nullable = false)
    private int maxMembers;

    @Column(name = "require_approval_to_join", nullable = false)
    private Boolean requireApprovalToJoin;

    @Column(name = "allow_member_invite", nullable = false)
    private Boolean allowMemberInvite;

}
