--1. �������� ������ ��������� ���� ��������� � ����� "���"
--select * from products as p
-- join types as t on 
--p.type_id = t.id and t.name = '���';

--2. �������� ������ ��������� ���� ���������, � ���� � ����� ���� ����� "����������"
--select * from products as p where p.name LIKE '%���������%';

--3. �������� ������, ������� ������� ��� ��������, ���� �������� ������� ������������� � ��������� ������.
--select * from products as p where EXTRACT(month from p.expired_date) = EXTRACT(month from now()) + 1;

--4. �������� ������, ������� ������� ����� ������� �������.
--select * from products as p order by price desc limit 1;

--5. �������� ������, ������� ������� ���������� ���� ��������� ������������� ����.
--select count(p.id) from products as p
-- join types as t on 
--p.type_id = t.id and t.name = '���';

--6. �������� ������ ��������� ���� ��������� � ����� "���" � "������"
--select * from products as p
--join types as t on 
--p.type_id = t.id and (t.name = '���' or t.name = '������');

--7. �������� ������, ������� ������� ��� ���������, ������� �������� ������ 10 ����.  
--select * from products as p where p.balance < 10;

--8. ������� ��� �������� � �� ���.
--select * from products as p
-- join types as t on 
--p.type_id = t.id;

