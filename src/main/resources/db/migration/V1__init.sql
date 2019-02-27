create table cricketer (id bigint not null, country varchar(255), highest_score varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values (1);