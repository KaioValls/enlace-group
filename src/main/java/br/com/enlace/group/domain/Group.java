package br.com.enlace.group.domain;

import br.com.enlace.group.domain.util.AbstractAuditable;
import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(name = "groups")
public class Group extends AbstractAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "group_code", nullable = false, length = 6)
    private String groupCode;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "group_type", nullable = false, length = 20)
    private GroupType groupType;

    @Column(name = "leader_id", nullable = false)
    private Long leaderId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "group_members", joinColumns = @JoinColumn(name = "group_id"))
    @Column(name = "member_id")
    @BatchSize(size = 100)
    private List<Long> membersIdList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "interaction_rules_id")
    private InteractionRules interactionRules;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private GroupLocation location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private GroupStatus status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_schedule_id")
    private MeetingSchedule meetingSchedule;

    // TODO: NO SQL: private GroupStatistics statistics;
    //TODO: IMPLEMENT: referencia a um microservico private Treasury treasury;


    public Group() {
    }

    public Group(Long id, String name, String groupCode, String description, GroupType groupType, Long leaderId, List<Long> membersIdList, InteractionRules interactionRules, GroupLocation location, GroupStatus status, MeetingSchedule meetingSchedule) {
        this.id = id;
        this.name = name;
        this.groupCode = groupCode;
        this.description = description;
        this.groupType = groupType;
        this.leaderId = leaderId;
        this.membersIdList = membersIdList;
        this.interactionRules = interactionRules;
        this.location = location;
        this.status = status;
        this.meetingSchedule = meetingSchedule;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public String getDescription() {
        return description;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public InteractionRules getInteractionRules() {
        return interactionRules;
    }

    public GroupStatus getStatus() {
        return status;
    }

    public List<Long> getMembersIdList() {
        return membersIdList;
    }

    public GroupLocation getLocation() {
        return location;
    }

    public MeetingSchedule getMeetingSchedule() {
        return meetingSchedule;
    }
}
