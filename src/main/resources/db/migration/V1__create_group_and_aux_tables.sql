CREATE TABLE group_locations(
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
    created_by_id VARCHAR(150),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(150),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

