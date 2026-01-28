create table products (
    id serial primary key,
    name text not null,
    price numeric(12,2) not null,
    last_modified timestamp
);

create or replace function update_last_modified()
returns trigger
language plpgsql
as $$
begin
    new.last_modified := now();
    return new;
end;
$$;

create trigger trg_update_last_modified
before update
on products
for each row
execute function update_last_modified();

insert into products (name, price)
values
    ('laptop', 1500),
    ('mouse', 25),
    ('keyboard', 45);

update products
set price = 1600
where name = 'laptop';

select * from products;
