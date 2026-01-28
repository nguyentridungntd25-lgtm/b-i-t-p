create table products (
    id serial primary key,
    name text not null,
    stock int not null
);

create table orders (
    id serial primary key,
	product_id int not null references products(id),
  quantity int not null
);

create or replace function update_product_stock()
returns trigger
language plpgsql
as $$
begin
    if tg_op = 'INSERT' then
      update products
      set stock = stock - new.quantity
      where id = new.product_id;
      return new;
    elsif tg_op = 'UPDATE' then
      update products
      set stock = stock + old.quantity - new.quantity
      where id = new.product_id;
      return new;
    elsif tg_op = 'DELETE' then
      update products
      set stock = stock + old.quantity
      where id = old.product_id;
      return old;
    end if;
end;
$$;

create trigger trg_update_stock
after insert or update or delete
on orders
for each row
execute function update_product_stock();

insert into products (name, stock)
values ('laptop', 50),
       ('mouse', 100);

select * from products;

insert into orders (product_id, quantity)
values (1, 5),
       (2, 20);

select * from products;

update orders
set quantity = 8
where product_id = 1;

select * from products;

delete from orders
where product_id = 2;

select * from products;
