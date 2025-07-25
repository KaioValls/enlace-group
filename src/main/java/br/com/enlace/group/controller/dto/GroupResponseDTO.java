package br.com.enlace.group.controller.dto;

import br.com.enlace.group.domain.GroupStatus;
import br.com.enlace.group.domain.GroupType;

import java.time.LocalDateTime;
import java.util.List;

public record GroupResponseDTO(
        Long id,
        String name,
        String groupCode,
        String description,
        GroupType groupType,
        Long leaderId,
        List<Long> membersIdList,
        InteractionRulesDTO interactionRules,
        GroupLocationDTO location,
        GroupStatus status,
        MeetingScheduleDTO meetingSchedule,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public record InteractionRulesDTO(
            String rulesDescription,
            Integer maxMembers,
            Integer minMembers,
            Boolean allowMemberInvites
    ) {}

    public record GroupLocationDTO(
            String address,
            String city,
            String state,
            String country,
            String postalCode,
            Double latitude,
            Double longitude
    ) {}

    public record MeetingScheduleDTO(
            String dayOfWeek,
            String startTime,
            String endTime,
            String frequency,
            String timeZone
    ) {}
}
