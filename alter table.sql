alter table employees modify column DATE_OF_BIRTH date not null default 0;
alter table region add column city varchar(45) not null;
alter table region drop column city;