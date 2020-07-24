--1. Написать запрос получение всех продуктов с типом "СЫР"
--select * from products as p
-- join types as t on 
--p.type_id = t.id and t.name = 'СЫР';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
--select * from products as p where p.name LIKE '%МОРОЖЕНОЕ%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
--select * from products as p 
--	where 
--		case when EXTRACT(month from now()) > 12 THEN
--			EXTRACT(month from p.expired_date) = 1
--		else
--			EXTRACT(month from p.expired_date) = EXTRACT(month from now()) + 1
--		end;

--4. Написать запрос, который выводит самый дорогой продукт.
--select * from products as p order by price desc limit 1;

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
--select count(p.id) from products as p
-- join types as t on 
--p.type_id = t.id and t.name = 'СЫР';

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
--select * from products as p
--join types as t on 
--p.type_id = t.id 
--where t.name = 'СЫР' or t.name = 'МОЛОКО';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
--select t.name, SUM(p.balance) from products as p
-- left join types as t
-- on p.type_id = t.id
-- group by (t.name)
-- having sum(p.balance) < 10

--8. Вывести все продукты и их тип.
--select * from products as p
-- join types as t on 
--p.type_id = t.id;

