alter table authors_courses drop foreign key course_id_fk;
alter table authors_courses drop foreign key author_id_fk;
drop table if exists authors cascade;
drop table if exists authors_courses cascade;
drop table if exists courses cascade;

create table authors (id bigint not null auto_increment, bio varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table authors_courses (author_id bigint not null, course_id bigint not null, primary key (author_id, course_id)) engine=InnoDB;
create table courses (id bigint not null auto_increment, category varchar(255), description varchar(255), name varchar(255), rating integer not null, primary key (id)) engine=InnoDB;
alter table authors_courses add constraint course_id_fk foreign key (course_id) references courses (id);
alter table authors_courses add constraint author_id_fk foreign key (author_id) references authors (id);
