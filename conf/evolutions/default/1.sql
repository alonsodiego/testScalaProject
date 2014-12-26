# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "COMPANY" ("id" BIGSERIAL NOT NULL PRIMARY KEY,"name" VARCHAR(254) NOT NULL);
create table "COMPUTER" ("id" BIGSERIAL NOT NULL PRIMARY KEY,"name" VARCHAR(254) NOT NULL,"introduced" BIGINT,"discontinued" BIGINT,"companyId" BIGINT);

# --- !Downs

drop table "COMPUTER";
drop table "COMPANY";

