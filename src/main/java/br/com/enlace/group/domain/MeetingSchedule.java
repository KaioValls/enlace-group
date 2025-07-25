package br.com.enlace.group.domain;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "meeting_schedule")
public class MeetingSchedule extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    public MeetingFrequency frequency;

    @Column(name = "is_recurring")
    public Boolean isRecurring;

    @Column(length = 50)
    public String timezone;

    @OneToMany(mappedBy = "meetingSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<MeetingDay> meetingDays;

    public MeetingFrequency getFrequency() {
        return frequency;
    }

    public Boolean getRecurring() {
        return isRecurring;
    }

    public String getTimezone() {
        return timezone;
    }

    public List<MeetingDay> getMeetingDays() {
        return meetingDays;
    }
}

