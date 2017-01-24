# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table transaction (
  id                        bigint auto_increment not null,
  ddate                     datetime(6),
  amount                    double,
  user_id                   bigint,
  constraint pk_transaction primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  phone_number              varchar(255),
  address                   varchar(255),
  constraint pk_user primary key (id))
;

alter table transaction add constraint fk_transaction_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_transaction_user_1 on transaction (user_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table transaction;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

