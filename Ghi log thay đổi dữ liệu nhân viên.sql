create table employees (
    id serial primary key,
    name text not null,
    position text,
    salary numeric(12,2)
);

create table employees_log (
    id serial primary key,
    employee_id int,
    operation text,
    old_data jsonb,
    new_data jsonb,
    change_time timestamp
);

create or replace function log_employees_changes()
returns trigger
language plpgsql
as $$
begin
    if tg_op = 'INSERT' then
        insert into employees_log (
         employee_id,
         operation,
         old_data,
         new_data,
         change_time
        )
        values (
          new.id,
         'insert',
          null,
          to_jsonb(new),
          now()
        );
        return new;

    elsif tg_op = 'UPDATE' then
        insert into employees_log (
          employee_id,
          operation,
          old_data,
          new_data,
          change_time
        )
        values (
          new.id,
          'update',
           to_jsonb(old),
           to_jsonb(new),
          now()
        );
        return new;

    elsif tg_op = 'DELETE' then
        insert into employees_log (
            employee_id,
            operation,
            old_data,
            new_data,
            change_time
        )
        values (
          old.id,
          'delete',
          to_jsonb(old),
          null,
          now()
      );
        return old;
  end if;
end;
$$;

create trigger trg_log_employees
after insert or update or delete
on employees
for each row
execute function log_employees_changes();

insert into employees (name, position, salary)
values
    ('nguyen van a', 'developer', 1500),
    ('tran thi b', 'tester', 1200);

update employees
set salary = 1800, position = 'senior developer'
where name = 'nguyen van a';

delete from employees
where name = 'tran thi b';

select * from employees;
select * from employees_log;
