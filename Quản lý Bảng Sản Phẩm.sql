create table products (
    id serial primary key,
    name varchar(100),
    category varchar(50),
    price bigint,
    stock int,
    manufacturer varchar(50)
);
drop table products
insert into products ( name, category, price, stock, manufacturer)
values
('laptop dell xps 13', 'laptop', 25000000, 12, 'dell'),
('chuột logitech m90', 'phụ kiện', 150000, 50, 'logitech'),
('bàn phím cơ razer', 'phụ kiện', 2200000, 0, 'razer'),
('macbook air m2', 'laptop', 32000000, 7, 'apple'),
('iphone 14 pro max', 'điện thoại', 35000000, 15, 'apple'),
('laptop dell xps 13', 'laptop', 25000000, 12, 'dell'),
('tai nghe airpods 3', 'phụ kiện', 4500000, null, 'apple');

insert into products (name, category, price, stock, manufacturer)
values ('chuột không dây logitech m170', 'phụ kiện', 300000, 20, 'logitech');

update products
set price = price * 1.1
where manufacturer = 'apple';

delete from products
where stock = 0;

select *
from products
where price between 1000000 and 30000000;

select *
from products
where stock is null;

select distinct manufacturer
from products;

select *
from products
order by price desc, name asc;

select *
from products
where name ilike '%laptop%';

select *
from products
order by price desc, name asc
limit 2;
