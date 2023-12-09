CREATE SEQUENCE courses_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE courses (
    id BIGINT NOT NULL ,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE courses_students (
    course_id BIGINT NOT NULL ,
    student_id BIGINT NOT NULL
);

CREATE TABLE courses_teachers (
    course_id bigint not null,
    teacher_id bigint not null
);

ALTER TABLE IF EXISTS courses_students
    ADD CONSTRAINT FK_cs_student_id
        FOREIGN KEY (student_id)
            references students;

ALTER TABLE IF EXISTS courses_students
    ADD CONSTRAINT FK_cs_course_id
    FOREIGN KEY (course_id)
    REFERENCES courses;

ALTER TABLE IF EXISTS courses_teachers
    ADD CONSTRAINT FK_ct_teacher_id
    FOREIGN KEY (teacher_id)
    REFERENCES teachers;

ALTER TABLE IF EXISTS courses_teachers
    ADD CONSTRAINT FK_ct_course_id
    FOREIGN KEY (course_id)
     REFERENCES courses;
