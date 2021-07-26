DROP TABLE IF EXISTS role CASCADE;
DROP TABLE IF EXISTS profile CASCADE;
DROP TABLE IF EXISTS post CASCADE;
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
                        created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE post(
                     id BIGSERIAL PRIMARY KEY NOT NULL,
                     title VARCHAR(50) NOT NULL,
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

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO blog_admin;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO blog_admin;

INSERT INTO profile(username, password, email, first_name)
VALUES ('admin', 'admin', 'asdf@afs.asd', 'Pranys');