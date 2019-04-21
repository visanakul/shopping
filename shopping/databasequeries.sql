create table category
(
	id number(2) primary key,
	name varchar2(30),
	description varchar2(50),
	img_url varchar(100),
	is_active char(1)
);
insert into category values(1,'Television','Television Description','CAT_1.png','Y');
insert into category values(2,'Mobile','Mobile Description','CAT_2.png','Y');
insert into category values(3,'Laptop','Laptop Description','CAT_3.png','Y');
create table user_detail(
	id number(3) primary key,
	first_name varchar2(10),
	last_name varchar2(10),
	role varchar2(10),
	enables char(1),
	password varchar2(10),
	email varchar2(30),
	contact_number varchar2(13)
);
insert into user_detail values(1,'Vishal','Kulkarni','ADMIN','Y','Vishal123','vishal123@gmail.com','9812345678');
insert into user_detail values(2,'Vikram','Kulkarni','SUPPLIER','Y','Vikram123','vishal123@gmail.com','9632345678');
insert into user_detail values(3,'Vipin','Kulkarni','SUPPLIER','Y','Vipin123','vipin123@gmail.com','9752345678');


create table product(
	id number(3) primary key,
	code varchar2(10),
	name varchar2(10),
	brand varchar2(10),
	description varchar2(20),
	unit_price number(10,2),
	quantity number(3),
	is_active char(1),
	category_id number(2)  references category(id),
	supplier_id number(3)  references user_detail(id),
	purchases number(3) default 0,
	views number(3) default 0
);
insert into product values(1,'PRD100','MI Pro5','MI','MI Description',12000,20,'Y',2,1,0,0);
insert into product values(2,'PRD101','Dell vos','Dell','Dell Description',50000,30,'Y',3,2,0,0);
insert into product values(3,'PRD102','Sony new','Samsung','Samsung Description',40000,10,'Y',1,3,0,0);



