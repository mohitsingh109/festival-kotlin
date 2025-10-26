
-- changeset arun:004
CREATE TABLE IF NOT EXISTS festival_performer(
    festival_id BIGINT  NOT NULL,
    performer_id BIGINT  NOT NULL,
    CONSTRAINT pk_festival_performer PRIMARY KEY (festival_id, performer_id),
    CONSTRAINT fk_festival FOREIGN KEY (festival_id) REFERENCES festival (id),
    CONSTRAINT fk_performer FOREIGN KEY (performer_id) REFERENCES performer (id)
);