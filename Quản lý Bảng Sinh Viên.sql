create table student (
    id serial primary key,
    name varchar(50),
    gender varchar(10),
    birth_year int,
    major varchar(50),
    gpa decimal(3,2)
);

insert into student (name, gender, birth_year, major, gpa)
values
('nguyễn thị mai', 'nữ', 2002, 'kinh tế', 3.1),
('trần văn hùng', 'nam', 2001, 'cntt', 3.5),
('lê thị thanh', 'nữ', 2003, 'luật', 3.3),
('phạm quốc bảo', 'nam', 2000, 'cơ khí', 2.9),
('vũ minh tú', 'nam', 2004, 'cntt', 3.0),
('đặng thị lan', 'nữ', 2001, 'kinh tế', null),
('hoàng anh tuấn', 'nam', 2002, 'cntt', 3.7);

insert into student (full_name, gender, birth_year, major, gpa)
values ('phan hoàng nam', 'nam', 2003, 'cntt', 3.8);

update student
set gpa = 3.4
where full_name = 'lê quốc cường';

delete from student
where gpa is null;

select *
from student
where major = 'cntt' and gpa >= 3.0 limit 3;

select distinct major
from student;

select *
from student
where major = 'cntt'
order by gpa desc, full_name asc;

select *
from student
where full_name like 'nguyễn%';

select *
from student
where birth_year between 2001 and 2003;
