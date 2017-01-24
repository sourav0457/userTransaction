# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table transaction (
  transactionid             bigint auto_increment not null,
  date                      date,
  amount                    double,
  user_userid               bigint,
  constraint pk_transaction primary key (transactionid))
;

create table user (
  userid                    bigint auto_increment not null,
  name                      varchar(255),
  phone_number              varchar(255),
  address                   varchar(255),
  constraint pk_user primary key (userid))
;

alter table transaction add constraint fk_transaction_user_1 foreign key (user_userid) references user (userid) on delete restrict on update restrict;
create index ix_transaction_user_1 on transaction (user_userid);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table transaction;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

