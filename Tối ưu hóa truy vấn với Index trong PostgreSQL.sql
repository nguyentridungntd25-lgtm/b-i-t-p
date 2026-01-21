create table book (
    book_id serial primary key,
    title varchar(255),
    author varchar(100),
    genre varchar(50),
    price decimal(10,2),
    description text,
    created_at timestamp default current_timestamp
);

insert into book (title, author, genre, price, description) values
('harry potter and the philosopher stone', 'j.k. rowling', 'fantasy', 19.99, 'a magic story about a young wizard'),
('harry potter and the chamber of secrets', 'j.k. rowling', 'fantasy', 21.99, 'magic school and dark secrets'),
('the hobbit', 'j.r.r. tolkien', 'fantasy', 18.50, 'adventure in middle earth'),
('clean code', 'robert c. martin', 'programming', 30.00, 'book about writing clean code'),
('database systems', 'thomas connolly', 'education', 40.00, 'concepts of database systems');

explain analyze
select * from book where author ilike '%rowling%';

explain analyze
select * from book where genre = 'fantasy';


create extension if not exists pg_trgm;


create index idx_book_author_trgm
on book using gin (author gin_trgm_ops);


create index idx_book_genre
on book(genre);

create index idx_book_desc_fts
on book using gin (to_tsvector('english', description));


explain analyze
select * from book where author ilike '%rowling%';

explain analyze
select * from book where genre = 'fantasy';

explain analyze
select *
from book
where to_tsvector('english', description)
@@ to_tsquery('magic');


cluster book using idx_book_genre;


explain analyze
select * from book where genre = 'fantasy';

--b-tree index hieu qua nhat cho cac truy van so sanh bang nhu genre = 'fantasy' va order by.
--gin index ket hop pg_trgm la lua chon tot nhat cho cac truy van ilike voi ky tu % o dau chuoi.
--gin index cho full-text search giup tim kiem noi dung trong title hoac description nhanh hon rat nhieu so voi seq scan.
--cluster giup cai thien hieu nang truy van theo genre do du lieu duoc sap xep vat ly, nhung chi co tac dung tam thoi.
--hash index khong duoc khuyen khich trong postgresql vi chi ho tro phep so sanh bang, khong ho tro order by va truy van pham vi.