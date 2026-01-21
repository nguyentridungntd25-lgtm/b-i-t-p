create table customer (
    customer_id serial primary key,
    full_name varchar(100),
    region varchar(50)
);

create table orders (
    order_id serial primary key,
    customer_id int references customer(customer_id),
    total_amount decimal(10,2),
    order_date date,
    status varchar(20)
);

create table product (
    product_id serial primary key,
    name varchar(100),
    price decimal(10,2),
    category varchar(50)
);

create table order_detail (
    order_id int references orders(order_id),
    product_id int references product(product_id),
    quantity int
);

insert into customer (full_name, region) values
('nguyen van a', 'ha noi'),
('tran thi b', 'da nang'),
('le van c', 'ho chi minh');

insert into product (name, price, category) values
('laptop dell', 15000000, 'electronics'),
('iphone 14', 20000000, 'electronics'),
('ban phim co', 1200000, 'accessories'),
('chuot khong day', 800000, 'accessories');

insert into orders (customer_id, total_amount, order_date, status) values
(1, 16200000, '2024-01-10', 'completed'),
(1, 20000000, '2024-02-05', 'completed'),
(2, 1200000, '2024-02-15', 'pending'),
(3, 20800000, '2024-03-01', 'completed');

insert into order_detail (order_id, product_id, quantity) values
(1, 1, 1),
(1, 3, 1),
(2, 2, 1),
(3, 3, 1),
(4, 2, 1),
(4, 4, 1);

select * from customer;
select * from product;
select * from orders;
select * from order_detail;

create view v_revenue_by_region as
select c.region,
sum(o.total_amount) as total_revenue
from customer c
join orders o on c.customer_id = o.customer_id
group by c.region;

select *
from v_revenue_by_region
order by total_revenue desc
limit 3;

create view v_order_detail as
select order_id, customer_id, total_amount, order_date, status
from orders
with check option;

update v_order_detail
set status = 'completed'
where order_id = 3;

create view v_pending_orders as
select *
from orders
where status = 'pending'
with check option;

create view v_revenue_above_avg as
select *
from v_revenue_by_region
where total_revenue >
(select avg(total_revenue) from v_revenue_by_region);

select * from v_revenue_above_avg;




