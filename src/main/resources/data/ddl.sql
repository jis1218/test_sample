DROP TABLE IF EXISTS member;

CREATE TABLE member (
    id int auto_increment primary key,
    email varchar(30),
    password varchar(20)
);

INSERT INTO member(email, password) VALUES ('hello@world.com', '23456');


