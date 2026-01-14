Trong schema library, tạo bảng Books với các cột sau:
book_id (số nguyên, khóa chính, tự tăng)
title (chuỗi, tối đa 100 ký tự, không được null)
author (chuỗi, tối đa 50 ký tự, không được null)
published_year (số nguyên)
price (số thực)
Thực hành các câu lệnh:
Xem tất cả các database
Xem tất cả các schema trong database
Xem cấu trúc bảng Books
create schema library;

create table library.Books (
book_id serial primary key ,
title varchar(100) not null,
author varchar (50) not null,
published_year int,
price numeric(10,2)
)

SELECT datname FROM pg_database;
SELECT schema_name FROM information_schema.schemata;

select * from library.Books;
