DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS profile;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS profile_role;


CREATE TABLE role
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    title VARCHAR(50) NOT NULL
);
CREATE TABLE profile(
                        id BIGSERIAL PRIMARY KEY NOT NULL,
                        username VARCHAR(50) NOT NULL,
                        password VARCHAR(68) NOT NULL,
                        email VARCHAR(50) NOT NULL,
                        first_name VARCHAR(50) NOT NULL,
                        last_name VARCHAR(50),
                        created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                        role_id int not null,
                        CONSTRAINT fk_profile_role
                            FOREIGN KEY(role_id)
                                REFERENCES role(id)
);

CREATE TABLE post(
                          id BIGSERIAL PRIMARY KEY NOT NULL,
                          title VARCHAR(20) NOT NULL,
                          text TEXT NOT NULL,
                          created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                          profile_id int not null,
                          CONSTRAINT fk_post_profile
                              FOREIGN KEY(profile_id)
                                  REFERENCES profile(id)
);

CREATE TABLE comment(
                        id BIGSERIAL PRIMARY KEY NOT NULL,
                        text TEXT NOT NULL,
                        post_id int not null,
                        profile_id int not null,
                        CONSTRAINT fk_comment_profile
                            FOREIGN KEY(profile_id)
                                REFERENCES profile(id),
                        CONSTRAINT fk_comment_post
                            FOREIGN KEY(post_id)
                                REFERENCES post(id)
);

CREATE TABLE profile_role (
                      profile_id BIGINT REFERENCES profile (id) NOT NULL,
                      role_id BIGINT REFERENCES role(id) NOT NULL,
                                CONSTRAINT profile_role_pkey PRIMARY KEY (profile_id, role_id)
);