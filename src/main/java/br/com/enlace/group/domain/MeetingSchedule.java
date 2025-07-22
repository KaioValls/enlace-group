package br.com.enlace.group.domain;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "meeting_schedule")
public class MeetingSchedule extends PanacheEntity {

    public MeetingFrequency frequency;

    public Boolean isRecurring;

    public String timezone;

    @OneToMany(mappedBy = "meetingSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<MeetingDay> meetingDays;
}

