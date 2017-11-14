create table user_emp(
name varchar(20),
password varchar(20)
);

insert into user_emp values('kangkang','123');
insert into user_emp values('keke','123');
insert into user_emp values('caocao','123');

create table emp(
empno integer,
ename varchar(20),
age integer,
deptno integer,
hiredate date,
salary integer
);

insert into emp values(101,'zhao',22,1001,'2012-12-12',3000.00);
insert into emp values(102,'qian',23,1002,'2014-03-12',4000.00);
insert into emp values(103,'shun',22,1001,'2013-05-22',3500.00);

alter table emp add  primary key(empno);