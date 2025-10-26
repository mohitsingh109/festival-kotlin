
-- changeset karan:002
CREATE TABLE IF NOT EXISTS festival(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    theme VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    venue_id BIGINT NOT NULL,

    CONSTRAINT fk_venue_id FOREIGN KEY (venue_id) REFERENCES venue (id)
);