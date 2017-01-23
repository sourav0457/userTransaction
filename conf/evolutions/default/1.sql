# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table transaction (
  id                        bigint auto_increment not null,
  date                      datetime(6),
  amount                    double,
  constraint pk_transaction primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  phone_number              varchar(255),
  address                   varchar(255),
  constraint pk_user primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table transaction;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

