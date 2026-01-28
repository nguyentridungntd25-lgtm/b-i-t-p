create table customers (
    id serial primary key,
    name text not null,
    credit_limit numeric(12,2) not null
);

create table orders (
    id serial primary key,
    customer_id int not null references customers(id),
    order_amount numeric(12,2) not null
);

create or replace function check_credit_limit()
returns trigger
language plpgsql
as $$
declare
    total_order numeric(12,2);
    limit_credit numeric(12,2);
begin
    select credit_limit
    into limit_credit
    from customers
    where id = new.customer_id;
    select coalesce(sum(order_amount), 0)
    into total_order
    from orders
    where customer_id = new.customer_id;
    if total_order + new.order_amount > limit_credit then
        raise exception 'vuot han muc tin dung cua khach hang';
    end if;

    return new;
end;
$$;

create trigger trg_check_credit
before insert
on orders
for each row
execute function check_credit_limit();

insert into customers (name, credit_limit)
values
    ('alice', 1000),
    ('bob', 500);

insert into orders (customer_id, order_amount)
values
    (1, 300),
    (1, 400);

insert into orders (customer_id, order_amount)
values
    (1, 200);

insert into orders (customer_id, order_amount)
values
    (1, 400);

insert into orders (customer_id, order_amount)
values
    (2, 500);

insert into orders (customer_id, order_amount)
values
    (2, 100);

select * from customers;
select * from orders;
