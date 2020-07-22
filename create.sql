create table roles (
   id serial primary key,
	name varchar(2000) unique not null
);

create table rules (
   id serial primary key,
	name varchar(2000) unique not null
);

create table role_to_rule (
   id serial primary key,
	role_id integer references roles(id), 
	rule_id integer references rules(id) 
);

create unique index "UI_role_to_rule_ids" 
	ON "role_to_rule"
	using btree
	("role_id", "rule_id");

create table users (
   id serial primary key,
	name varchar(2000) not null,
	password varchar(2000) not null,
        role_id integer references roles(id) 
);

create table categories (
   id serial primary key,
	name varchar(2000) unique not null
);

create table states (
   id serial primary key,
	name varchar(2000) unique not null
);

create table items (
   id serial primary key,
	name varchar(2000) not null,
	description text,
        user_id integer references users(id),
	category_id integer references categories(id),
	state_id integer references states(id)
);

create table comments (
   id serial primary key,
	name varchar(2000) not null,
	content text,
	item_id integer references items(id)
);

create table attachs (
   id serial primary key,
	name varchar(2000) not null,
	content text,
	item_id integer references items(id)
);


insert into roles (id, name) values (0, 'admin');
insert into roles (id, name) values (1, 'user');

insert into rules (id, name) values (0, 'add');
insert into rules (id, name) values (1, 'delete');
insert into rules (id, name) values (2, 'edit');
insert into rules (id, name) values (3, 'view');

--admin
insert into role_to_rule (role_id, rule_id) values (0, 0);
insert into role_to_rule (role_id, rule_id) values (0, 1);
insert into role_to_rule (role_id, rule_id) values (0, 2);
insert into role_to_rule (role_id, rule_id) values (0, 3);
--user
insert into role_to_rule (role_id, rule_id) values (1, 3);

insert into users (id, name, password, role_id) values (0, 'Ivanov', 'admin', 0);
insert into users (id, name, password, role_id) values (1, 'Petrov', 'user', 1);

insert into categories (id, name) values (0, 'support');
insert into categories (id, name) values (1, 'development');
insert into categories (id, name) values (2, 'education');

insert into states (id, name) values (0, 'new');
insert into states (id, name) values (1, 'in progress');
insert into states (id, name) values (2, 'finished');
insert into states (id, name) values (3, 'canceled');

insert into items (id, name, description, user_id, category_id, state_id) 
	values (0, 'task 1', 'learn docs', 0, 2, 0);
insert into items (id, name, description, user_id, category_id, state_id) 
	values (1, 'task 1', 'learn docs', 1, 2, 0);

insert into comments (name, content, item_id) values ('comment 1', 'some text', 0);
insert into comments (name, content, item_id) values ('comment 2', 'some text', 1);

insert into attachs (name, content, item_id) values ('attach 1', 'some files', 0);
insert into attachs (name, content, item_id) values ('attach 2', 'some files', 1);

