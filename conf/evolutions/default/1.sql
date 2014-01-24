# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table app_user (
  id                        bigint not null,
  full_name                 varchar(255),
  company                   varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_app_user primary key (id))
;

create sequence app_user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists app_user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists app_user_seq;

