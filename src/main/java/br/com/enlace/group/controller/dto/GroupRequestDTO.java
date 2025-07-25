package br.com.enlace.group.controller.dto;

import br.com.enlace.group.domain.GroupStatus;
import br.com.enlace.group.domain.GroupType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.List;

public record GroupRequestDTO(
        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name must be at most 100 characters")
        String name,

        @NotBlank(message = "Group code is required")
        @Size(min = 6, max = 6, message = "Group code must be exactly 6 characters")
        String groupCode,

        String description,

        @NotNull(message = "Group type is required")
        GroupType groupType,

        @NotNull(message = "Leader ID is required")
        Long leaderId,

        List<Long> membersIdList,

        InteractionRulesDTO interactionRules,

        GroupLocationDTO location,

        @NotNull(message = "Status is required")
        GroupStatus status,

        MeetingScheduleDTO meetingSchedule
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
