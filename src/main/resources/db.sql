DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS profile;

CREATE TABLE role
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    title VARCHAR(50) NOT NULL
);
CREATE TABLE profile(
                        id BIGSERIAL PRIMARY KEY NOT NULL,
                        username VARCHAR(50) NOT NULL,
                        password VARCHAR(100) NOT NULL,
                        email VARCHAR(50) NOT NULL,
                        first_name VARCHAR(50) NOT NULL,
                        last_name VARCHAR(50),
                        created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
                        role_id int not null,
                        CONSTRAINT fk_profile_role
                            FOREIGN KEY(role_id)
                                REFERENCES role(id)
);

CREATE TABLE blog_post(
                          id BIGSERIAL PRIMARY KEY NOT NULL,
                          title VARCHAR(20) NOT NULL,
                          text TEXT NOT NULL,
                          created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                          profile_id int not null,
                          CONSTRAINT fk_blog_post_profile
                              FOREIGN KEY(profile_id)
                                  REFERENCES profile(id)
);

CREATE TABLE comment(
                        id BIGSERIAL PRIMARY KEY NOT NULL,
                        text TEXT NOT NULL,
                        blog_post int not null,
                        profile_id int not null,
                        CONSTRAINT fk_comment_profile
                            FOREIGN KEY(profile_id)
                                REFERENCES profile(id),
                        CONSTRAINT fk_comment_blog_post
                            FOREIGN KEY(blog_post)
                                REFERENCES blog_post(id)
);

