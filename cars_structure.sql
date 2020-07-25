create table bodies (
   id serial primary key,
	number varchar(20) not null,
	description text
);

create table engines (
   id serial primary key,
	number varchar(20) not null,
	description text
);

create table transmissions (
   id serial primary key,
	tr_type varchar(50) not null
);

create table cars (
   id serial primary key,
	vin varchar(17) not null,
	description text,
	body_id integer references types(id) not null,
	engine_id integer references types(id) not null,
	transmission_id integer references types(id) not null
);

insert into bodies (id, number, description) values (0, '11111111', 'Grey, 4 doors');
insert into bodies (id, number, description) values (1, '22222222', 'Grey, 5 doors');
insert into bodies (id, number, description) values (2, '33333333', 'Black, 3 doors');
insert into bodies (id, number, description) values (3, '44444444', 'Black, 4 doors');
insert into bodies (id, number, description) values (4, '55555555', 'White, 2 doors');

insert into engines (id, number, description) values (0, '11111111', 'Petrol 1,4 12 valves');
insert into engines (id, number, description) values (1, '22222222', 'Petrol 1,6 16 valves');
insert into engines (id, number, description) values (2, '33333333', 'Petrol 3.0 V8');
insert into engines (id, number, description) values (3, '44444444', 'Diesel 1,4 12 valves');
insert into engines (id, number, description) values (4, '55555555', 'Diesel 1,6 16 valves');

insert into transmissions (id, tr_type) values (0, 'MT');
insert into transmissions (id, tr_type) values (1, 'AT');
insert into transmissions (id, tr_type) values (2, 'Robot');
insert into transmissions (id, tr_type) values (3, 'Variator');

insert into cars (vin, description, body_id, engine_id, transmission_id) values ('1234567890123456', 'Hunday Solaris', 0, 0, 0);
insert into cars (vin, description, body_id, engine_id, transmission_id) values ('1234567890123457', 'Toyota Camry', 1, 1, 1);
insert into cars (vin, description, body_id, engine_id, transmission_id) values ('1234567890123458', 'Skoda Fabia', 2, 2, 2);
