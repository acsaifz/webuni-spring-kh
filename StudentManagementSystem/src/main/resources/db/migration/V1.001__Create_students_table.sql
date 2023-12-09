CREATE SEQUENCE students_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE students (
    id BIGINT NOT NULL,
    birth_date DATE,
    name VARCHAR(255),
    semester INTEGER NOT NULL,
    PRIMARY KEY (id)
);
