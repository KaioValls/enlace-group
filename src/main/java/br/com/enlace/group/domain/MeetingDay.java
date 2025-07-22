package br.com.enlace.group.domain;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
public class MeetingDay extends PanacheEntity {

    @Enumerated(EnumType.STRING)
    public DayOfWeek day;

    public LocalTime startTime;
    public LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "meeting_schedule_id")
    public MeetingSchedule meetingSchedule;
}