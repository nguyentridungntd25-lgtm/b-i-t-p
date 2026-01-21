create table post (
    post_id serial primary key,
    user_id int not null,
    content text,
    tags text[],
    created_at timestamp default current_timestamp,
    is_public boolean default true
);

create table post_like (
    user_id int not null,
    post_id int not null,
    liked_at timestamp default current_timestamp,
    primary key (user_id, post_id)
);
insert into post (user_id, content, tags, created_at, is_public) values
(1, 'du lich da nang rat dep', array['travel','beach'], now() - interval '2 days', true),
(2, 'hom nay di an lau voi ban be', array['food','friends'], now() - interval '5 days', true),
(3, 'chia se kinh nghiem hoc lap trinh', array['study','coding'], now() - interval '10 days', true),
(1, 'chuyen di phuot da lat tuyet voi', array['travel','mountain'], now() - interval '1 day', true),
(4, 'bai viet rieng tu', array['personal'], now() - interval '3 days', false);

insert into post_like (user_id, post_id, liked_at) values
(2, 1, now() - interval '1 day'),
(3, 1, now() - interval '1 day'),
(1, 2, now() - interval '2 days'),
(4, 2, now() - interval '2 days'),
(2, 4, now() - interval '3 hours');

select * from post;
select * from post_like;

create index idx_post_lower_content
on post (lower(content))
where is_public = true;

select *
from post
where is_public = true
and lower(content) like '%du lich%';

create index idx_post_tags
on post
using gin (tags);

explain analyze
select *
from post
where tags @> array['travel'];

create index idx_post_recent_public
on post (created_at desc)
where is_public = true;

explain analyze
select *
from post
where is_public = true
and created_at >= now() - interval '7 days';

create index idx_post_user_created_at
on post (user_id, created_at desc);

explain analyze
select *
from post
where user_id in (2, 5, 8)
and is_public = true
order by created_at desc
limit 20;




