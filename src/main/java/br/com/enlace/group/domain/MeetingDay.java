package br.com.enlace.group.domain;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "meeting_days")
public class MeetingDay extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", length = 10)
    public DayOfWeek dayOfWeek;

    @Column(name = "start_time")
    public LocalTime startTime;

    @Column(name = "end_time")
    public LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "meeting_schedule_id")
    public MeetingSchedule meetingSchedule;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}