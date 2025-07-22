package br.com.enlace.group.domain;

import java.time.LocalDateTime;
import java.util.Map;

public class GroupStatistics {

    private Long id;
    private int totalMembers;
    private int activeMembers;
    private Double averageAttendance;
    private int meetingThisMonth;
    private int totalMeetings;
    private double engagementScore;
    private double growthRate;
    private LocalDateTime lastMeeting;
    private LocalDateTime nextMeeting;
    private Map<String, Integer> attendanceByMonth;
    private Map<Long, MemberActivity> memberActivity;


}
