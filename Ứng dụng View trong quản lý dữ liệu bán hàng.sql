
create table customer (
    customer_id serial primary key,
    full_name varchar(100),
    email varchar(100),
    phone varchar(15)
);


create table orders (
    order_id serial primary key,
    customer_id int references customer(customer_id),
    total_amount decimal(10,2),
    order_date date
);


insert into customer (full_name, email, phone) values
('nguyen van a', 'a@gmail.com', '0901111111'),
('tran thi b', 'b@gmail.com', '0902222222'),
('le van c', 'c@gmail.com', '0903333333');

insert into orders (customer_id, total_amount, order_date) values
(1, 1500000, '2024-01-10'),
(1, 2500000, '2024-02-15'),
(2, 3200000, '2024-02-20'),
(3, 1800000, '2024-03-05');

create or replace view v_order_summary as
select  c.full_name, o.total_amount, o.order_date
from customer c
join orders o on c.customer_id = o.customer_id;


select * from v_order_summary;

update v_order_summary
set total_amount = 2000000
where order_id = 1;

select * from v_order_summary;

create or replace view v_monthly_sales as
select date_trunc('month', order_date) as sales_month,
sum(total_amount) as total_revenue
from orders
group by date_trunc('month', order_date)
order by sales_month;

select * from v_monthly_sales;

drop view v_order_summary;
drop view v_monthly_sales;
-- drop view chỉ xóa view không ảnh hường đến dữ liệu
-- drop materialized view xóa cả dữ liệu đã được lưu vật lí và view