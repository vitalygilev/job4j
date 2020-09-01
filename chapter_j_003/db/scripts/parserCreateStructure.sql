create table post (
   id serial primary key,
   name varchar(2000),
   text text,
   link varchar(2000) unique not null,
   created date not null
);