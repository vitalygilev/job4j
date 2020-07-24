--1. �������� ������ ��������� ���� ��������� � ����� "���"
--select * from products as p
-- join types as t on 
--p.type_id = t.id and t.name = '���';

--2. �������� ������ ��������� ���� ���������, � ���� � ����� ���� ����� "����������"
--select * from products as p where p.name LIKE '%���������%';

--3. �������� ������, ������� ������� ��� ��������, ���� �������� ������� ������������� � ��������� ������.
--select * from products as p 
--	where 
--		case when EXTRACT(month from now()) > 12 THEN
--			EXTRACT(month from p.expired_date) = 1
--		else
--			EXTRACT(month from p.expired_date) = EXTRACT(month from now()) + 1
--		end;

--4. �������� ������, ������� ������� ����� ������� �������.
--select * from products as p order by price desc limit 1;

--5. �������� ������, ������� ������� ���������� ���� ��������� ������������� ����.
--select count(p.id) from products as p
-- join types as t on 
--p.type_id = t.id and t.name = '���';

--6. �������� ������ ��������� ���� ��������� � ����� "���" � "������"
--select * from products as p
--join types as t on 
--p.type_id = t.id 
--where t.name = '���' or t.name = '������';

--7. �������� ������, ������� ������� ��� ���������, ������� �������� ������ 10 ����.  
--select t.name, SUM(p.balance) from products as p
-- left join types as t
-- on p.type_id = t.id
-- group by (t.name)
-- having sum(p.balance) < 10

--8. ������� ��� �������� � �� ���.
--select * from products as p
-- join types as t on 
--p.type_id = t.id;

