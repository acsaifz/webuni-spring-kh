create sequence revinfo_seq start with 1 increment by 50;

create table revinfo (
    rev integer not null,
    revtstmp bigint,
    primary key (rev)
);

create table courses_aud (
    rev integer not null,
    revtype smallint,
    id bigint not null,
    name varchar(255),
    primary key (rev, id)
);

create table students_aud (
    birth_date date,
    free_semesters integer,
    rev integer not null,
    revtype smallint,
    semester integer,
    id bigint not null,
    name varchar(255),
    student_id varchar(255),
    primary key (rev, id)
);

create table teachers_aud (
    birth_date date,
    rev integer not null,
    revtype smallint,
    id bigint not null,
    name varchar(255),
    primary key (rev, id)
);

create table courses_students_aud (
    rev integer not null, revtype smallint,
    course_id bigint not null,
    student_id bigint not null,
    primary key (rev, course_id, student_id)
);

create table courses_teachers_aud (
    rev integer not null,
    revtype smallint,
    course_id bigint not null,
    teacher_id bigint not null,
    primary key (rev, course_id, teacher_id)
);

alter table if exists courses_aud add constraint FK_courses_aud_rev foreign key (rev) references revinfo;
alter table if exists students_aud add constraint FK_students_aud_rev foreign key (rev) references revinfo;
alter table if exists teachers_aud add constraint FK_teachers_aud_rev foreign key (rev) references revinfo;
alter table if exists courses_students_aud add constraint FK_courses_student_aud_rev foreign key (rev) references revinfo;
alter table if exists courses_teachers_aud add constraint FK_courses_teachers_aud_rev foreign key (rev) references revinfo;
