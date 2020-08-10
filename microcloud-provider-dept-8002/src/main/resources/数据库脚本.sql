drop database if exists mldn8002;
create database mldn8002 character set utf8;
use mldn8002;

create table dept(
 deptno int(20) auto_increment,
 dname varchar(50),
 loc varchar(50),
 constraint pk_deptno primary key(deptno)
);

insert into dept(dname,loc) values('开发部',database());
insert into dept(dname,loc) values('财务部',database());
insert into dept(dname,loc) values('市场部',database());
insert into dept(dname,loc) values('后勤部',database());
insert into dept(dname,loc) values('公关部',database());
