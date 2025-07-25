package br.com.enlace.group.controller.dto;

import br.com.enlace.group.domain.GroupStatus;
import br.com.enlace.group.domain.GroupType;

import java.time.LocalDateTime;

public record GroupListDTO(
        Long id,
        String name,
        String groupCode,
        GroupType groupType,
        Long leaderId,
        int memberCount,
        GroupStatus status,
        LocalDateTime createdAt
) {}
