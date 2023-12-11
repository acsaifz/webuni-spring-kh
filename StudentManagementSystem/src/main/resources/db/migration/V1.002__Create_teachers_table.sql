CREATE SEQUENCE teachers_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE teachers (
    id BIGINT NOT NULL ,
    birth_date DATE,
    name VARCHAR(255),
    PRIMARY KEY (id)
);
