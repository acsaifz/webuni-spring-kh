
    create sequence courses_seq start with 1 increment by 50;

    create sequence students_seq start with 1 increment by 50;

    create sequence teachers_seq start with 1 increment by 50;

    create table courses (
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table courses_students (
        courses_id bigint not null,
        students_id bigint not null
    );

    create table courses_teachers (
        courses_id bigint not null,
        teachers_id bigint not null
    );

    create table students (
        birth_date date,
        semester integer not null,
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table teachers (
        birth_date date,
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table if exists courses_students 
       add constraint FK8a83yyyla7ilqklkvqlqdxefe 
       foreign key (students_id) 
       references students;

    alter table if exists courses_students 
       add constraint FK1iknipetudbrmvt05v3qhp7nm 
       foreign key (courses_id) 
       references courses;

    alter table if exists courses_teachers 
       add constraint FK8cdanw5v6wle9lhcrlp583yb4 
       foreign key (teachers_id) 
       references teachers;

    alter table if exists courses_teachers 
       add constraint FKjdto4ox5tm6amarpck3nxuhyf 
       foreign key (courses_id) 
       references courses;

    create sequence courses_seq start with 1 increment by 50;

    create sequence students_seq start with 1 increment by 50;

    create sequence teachers_seq start with 1 increment by 50;

    create table courses (
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table courses_students (
        courses_id bigint not null,
        students_id bigint not null
    );

    create table courses_teachers (
        courses_id bigint not null,
        teachers_id bigint not null
    );

    create table students (
        birth_date date,
        semester integer not null,
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table teachers (
        birth_date date,
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table if exists courses_students 
       add constraint FK8a83yyyla7ilqklkvqlqdxefe 
       foreign key (students_id) 
       references students;

    alter table if exists courses_students 
       add constraint FK1iknipetudbrmvt05v3qhp7nm 
       foreign key (courses_id) 
       references courses;

    alter table if exists courses_teachers 
       add constraint FK8cdanw5v6wle9lhcrlp583yb4 
       foreign key (teachers_id) 
       references teachers;

    alter table if exists courses_teachers 
       add constraint FKjdto4ox5tm6amarpck3nxuhyf 
       foreign key (courses_id) 
       references courses;

    create sequence courses_seq start with 1 increment by 50;

    create sequence students_seq start with 1 increment by 50;

    create sequence teachers_seq start with 1 increment by 50;

    create table courses (
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table courses_students (
        courses_id bigint not null,
        students_id bigint not null
    );

    create table courses_teachers (
        courses_id bigint not null,
        teachers_id bigint not null
    );

    create table students (
        birth_date date,
        semester integer not null,
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table teachers (
        birth_date date,
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table if exists courses_students 
       add constraint FK8a83yyyla7ilqklkvqlqdxefe 
       foreign key (students_id) 
       references students;

    alter table if exists courses_students 
       add constraint FK1iknipetudbrmvt05v3qhp7nm 
       foreign key (courses_id) 
       references courses;

    alter table if exists courses_teachers 
       add constraint FK8cdanw5v6wle9lhcrlp583yb4 
       foreign key (teachers_id) 
       references teachers;

    alter table if exists courses_teachers 
       add constraint FKjdto4ox5tm6amarpck3nxuhyf 
       foreign key (courses_id) 
       references courses;

    create sequence courses_seq start with 1 increment by 50;

    create sequence students_seq start with 1 increment by 50;

    create sequence teachers_seq start with 1 increment by 50;

    create table courses (
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table courses_students (
        courses_id bigint not null,
        students_id bigint not null
    );

    create table courses_teachers (
        courses_id bigint not null,
        teachers_id bigint not null
    );

    create table students (
        birth_date date,
        semester integer not null,
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table teachers (
        birth_date date,
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table if exists courses_students 
       add constraint FK8a83yyyla7ilqklkvqlqdxefe 
       foreign key (students_id) 
       references students;

    alter table if exists courses_students 
       add constraint FK1iknipetudbrmvt05v3qhp7nm 
       foreign key (courses_id) 
       references courses;

    alter table if exists courses_teachers 
       add constraint FK8cdanw5v6wle9lhcrlp583yb4 
       foreign key (teachers_id) 
       references teachers;

    alter table if exists courses_teachers 
       add constraint FKjdto4ox5tm6amarpck3nxuhyf 
       foreign key (courses_id) 
       references courses;
