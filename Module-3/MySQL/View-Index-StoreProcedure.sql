create database date160623Btap_ViewIndexStoreProcedure;
use date160623Btap_ViewIndexStoreProcedure;

create table products(
id int auto_increment primary key,
code varchar(50),
name varchar(255),
price decimal(10,2),
amount int,
description varchar(255),
status varchar(50)
);

insert into products (code, name, price, amount, description, status)
values ('P01','car', 29999, 99, 'move4', 'active'),
('P02','moto', 15000, 55, 'move2', 'active'),
('P03','cycle', 4000, 200, 'move2', 'active'),
('P04','rocket', 999999, 20, 'fly', 'inactive');

-- Step 3
create unique index idx_code on products(code);
create index idx_name_price on products(name, price);
explain select * from products where code = 'P04';
explain select * from products where code = 'P01';

select * from products where code = 'P01'; -- trc khi tao.

-- Step 4
create view view_code_name_price_status as
select code, name, price, status from products;
-- display
select * from view_code_name_price_status;
-- edit view
alter view view_code_name_price_status as
select code, name, price, status, amount from products;
-- delete view
drop view if exists view_code_name_price_status;

-- Step 5
delimiter //
create procedure get_all_products()
begin
select * from products;
end//
delimiter ;
call get_all_products;

-- tao store procedure them san pham moi
delimiter //
create procedure add_products(in p_code varchar(50), in p_name varchar(255),
in p_price decimal(10,2), in p_amount int, in p_description varchar(255),
in p_status varchar(50))
begin
insert into products (code, name, price, amount, description, status)
values (p_code, p_name, p_price, p_amount, p_description, p_status);
end//
delimiter ;

call add_products('P05','robot', 888888, 30, 'speaker', 'inactive');
call add_products('P06','man', 99999999, 100, 'worker', 'active');
select * from products;


-- tao store procedure sua thong tin theo id
delimiter //
create procedure update_products(in p_id int, in p_code varchar(50),
in p_name varchar(255), in p_price decimal(10,2), in p_amount int,
in p_description varchar(255), in p_status varchar(50))
begin
update products
set code = p_code, name = p_name, price = p_price, amount = p_amount,
description = p_description, status = p_status
where id = p_id;
end//
delimiter ;

call update_products(13, 'P05', 'Robot update', 88888, 88,'peeker', 'active');
select * from products;

-- xoa theo id
delimiter //
create procedure delete_products(in p_id int)
begin
delete from products where id = p_id;
end//
delimiter ;
call delete_products(16);
