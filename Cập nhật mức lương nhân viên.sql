Create table employees (
   emp_id serial primary key,
   emp_name varchar (100),
   job_level int,
   salary numeric
);

insert into employees (emp_name, job_level, salary )
values ('An', 1 ,10000000),
       ('Bình', 2 , 12000000),
	   ('Chi', 3, 15000000);

CREATE OR REPLACE PROCEDURE adjust_salary(
     p_emp_id int,
	 OUT p_new_salary numeric
)	   
LANGUAGE plpgsql
AS $$
DECLARE
     v_job_level int;
	 v_salary numeric;
BEGIN
     SELECT job_level, salary 
	 INTO v_job_level, v_salary
	 FROM employees
	 WHERE emp_id = p_emp_id;

     IF v_salary IS NULL THEN
	    RAISE EXCEPTION 'Nhân viên không tồn tại';
	END IF;

	IF v_job_level = 1 THEN
        v_salary := v_salary * 1.05;
    ELSIF v_job_level = 2 THEN
        v_salary := v_salary * 1.10;
    ELSIF v_job_level = 3 THEN
        v_salary := v_salary * 1.15;
    ELSE
        RAISE EXCEPTION 'Job level không hợp lệ';
    END IF;

	 UPDATE employees
    SET salary = v_salary
    WHERE emp_id = p_emp_id;

    p_new_salary := v_salary;
END;
$$;

CALL adjust_salary(1, NULL);
CALL adjust_salary(2, NULL);
CALL adjust_salary(3, p_new_salary);
Select p_new_salary