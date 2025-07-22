package br.com.enlace.group.domain;

import java.time.LocalDateTime;

public class MemberActivity {

    private Long userId;
    private Integer meetingsAttended;
    private Integer meetingsTotal;
    private Double attendanceRate;
    private LocalDateTime lastActivity;
    private Integer contributions;
    private EngagementLevel engagementLevel;

}
