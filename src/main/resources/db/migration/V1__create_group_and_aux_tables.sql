-- Database: PostgreSQL

-- Tabela de localizações de grupos
CREATE TABLE group_locations (
    id BIGSERIAL PRIMARY KEY,
    address VARCHAR(200),
    city VARCHAR(100),
    state VARCHAR(2),
    zip_code VARCHAR(10),
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    meeting_place VARCHAR(150),
    is_online BOOLEAN NOT NULL DEFAULT FALSE,
    online_meeting_url TEXT,
    -- Campos de auditoria (AbstractAuditable)
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);

-- Tabela de cronograma de reuniões
CREATE TABLE meeting_schedule (
    id BIGSERIAL PRIMARY KEY,
    frequency VARCHAR(20),
    is_recurring BOOLEAN DEFAULT TRUE,
    timezone VARCHAR(50) DEFAULT 'America/Sao_Paulo'
);

-- Tabela de dias de reunião (relacionada ao meeting_schedule)
CREATE TABLE meeting_days (
    id BIGSERIAL PRIMARY KEY,
    meeting_schedule_id BIGINT NOT NULL REFERENCES meeting_schedule(id) ON DELETE CASCADE,
    day_of_week VARCHAR(10) NOT NULL CHECK (day_of_week IN ('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY')),
    start_time TIME,
    end_time TIME
);

-- Tabela de regras de interação
CREATE TABLE interaction_rules (
    id BIGSERIAL PRIMARY KEY,
    visibility_level VARCHAR(20) NOT NULL,
    max_members INTEGER NOT NULL DEFAULT 50,
    require_approval_to_join BOOLEAN NOT NULL DEFAULT FALSE,
    allow_member_invite BOOLEAN NOT NULL DEFAULT TRUE
);

-- Tabela de permissões por papel nas regras de interação
CREATE TABLE interaction_role_permission (
    id BIGSERIAL PRIMARY KEY,
    role VARCHAR(20) NOT NULL,
    type VARCHAR(20) NOT NULL,
    interaction_rules_id BIGINT NOT NULL REFERENCES interaction_rules(id) ON DELETE CASCADE,
    UNIQUE(interaction_rules_id, role, type)
);

-- Tabela principal de grupos
CREATE TABLE groups (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    group_code VARCHAR(6) NOT NULL UNIQUE,
    description TEXT,
    group_type VARCHAR(20) NOT NULL,
    leader_id BIGINT NOT NULL,
    interaction_rules_id BIGINT REFERENCES interaction_rules(id) ON DELETE SET NULL,
    location_id BIGINT REFERENCES group_locations(id) ON DELETE SET NULL,
    status VARCHAR(20) NOT NULL,
    meeting_schedule_id BIGINT REFERENCES meeting_schedule(id) ON DELETE SET NULL,
    -- Campos de auditoria (AbstractAuditable)
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);

-- Tabela de membros do grupo (ElementCollection)
CREATE TABLE group_members (
    group_id BIGINT NOT NULL REFERENCES groups(id) ON DELETE CASCADE,
    member_id BIGINT NOT NULL,
    PRIMARY KEY (group_id, member_id)
);

