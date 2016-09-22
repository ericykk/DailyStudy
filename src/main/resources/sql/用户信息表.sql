--用户信息表
CREATE table user(
id int not null auto_increment PRIMARY KEY ,
userName varchar(20) not null,
password VARCHAR (20) not null
);
--新增用户
insert into user(userName,password)  values('zhangsan','zhangsan');