
CREATE TABLE IF NOT EXISTS mst_user (
    id BIGSERIAL NOT NULL,
    email VARCHAR(256) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    deleted_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS trn_note (
    id BIGSERIAL NOT NULL,
    user_id BIGINT NOT NULL REFERENCES mst_user(id),
    title VARCHAR(256),
    content TEXT,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    deleted_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT note_pkey PRIMARY KEY (id)
);
