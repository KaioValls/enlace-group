package br.com.enlace.group.domain;

import br.com.enlace.group.domain.util.AbstractAuditable;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "groups")
public class Group extends AbstractAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "group_type", nullable = false)
    private GroupType groupType;

    @Column(name = "leader_id", nullable = false)
    private Long leaderId;

    @ElementCollection
    @CollectionTable(name = "group_members", joinColumns = @JoinColumn(name = "group_id"))
    @Column(name = "member_id")
    private List<Long> membersIdList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "interaction_rules_id")
    private InteractionRules interactionRules;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private GroupLocation location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GroupStatus status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_schedule_id")
    private MeetingSchedule meetingSchedule;

    // TODO: NO SQL: private GroupStatistics statistics;
    //TODO: IMPLEMENT: referencia a um microservico private Treasury treasury;

}
