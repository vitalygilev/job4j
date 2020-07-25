/*select * from cars
	left join bodies on cars.body_id = bodies.id
	left join engines on cars.engine_id = engines.id
	left join transmissions on cars.transmission_id = transmissions.id;*/

--select bodies.* from bodies left join cars on cars.body_id = bodies.id where cars.id is null;
--select engines.* from engines left join cars on cars.body_id = engines.id where cars.id is null;
--select transmissions.* from transmissions left join cars on cars.body_id = transmissions.id where cars.id is null;

--Вариант общего запроса.

/*select 'body' as source,  bodies.number as number,  bodies.description as description 
	from bodies left join cars on cars.body_id = bodies.id where cars.id is null
union all
select 'engine',  engines.number,  engines.description
	from engines left join cars on cars.body_id = engines.id where cars.id is null
union all
select 'transmission', transmissions.tr_type, ''
	from transmissions left join cars on cars.body_id = transmissions.id where cars.id is null;*/
