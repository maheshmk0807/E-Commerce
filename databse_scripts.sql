create database ecommerce;

use ecommerce;

create table User(
emailID varchar(255) PRIMARY KEY,
userName varchar(255),
pass varchar(255),
userType varchar(255)
);

insert into user values("maheshmk0807@gmail.com","Mahesh Khedkar","1234","BUYER");
insert into user values("abc@gmail.com","abc","1234","SELLER");
insert into user values("def@gmail.com","def","1234","BUYER");
insert into user values("ghi@gmail.com","ghi","1234","SELLER");
insert into user values("jkl@gmail.com","jkl","1234","BUYER");
insert into user values("mno@gmail.com","mno","1234","BUYER");
insert into user values("pqr@gmail.com","pqr","1234","BUYER");
insert into user values("stu@gmail.com","stu","1234","BUYER");
insert into user values("vwx@gmail.com","vwx","1234","SELLER");
insert into user values("zzz@gmail.com","zzz","1234","BUYER");

insert into user values("b","Admin","b","BUYER");
insert into user values("s","Admin","s","SELLER");


create table product(
productID int PRIMARY KEY,
productName varchar(255),
price float,
sellerID varchar(255),
foreign key(sellerID) references user(emailID)
);

insert into product values(1,"Car",1000000,"abc@gmail.com");
insert into product values(2,"Bag",800,"abc@gmail.com");
insert into product values(3,"Phone",5000,"abc@gmail.com");
insert into product values(4,"Watch",500,"ghi@gmail.com");
insert into product values(5,"Pen",10,"vwx@gmail.com");
insert into product values(6,"Notebook",50,"vwx@gmail.com");
insert into product values(7,"Headphones",600,"abc@gmail.com");
insert into product values(8,"Laptop",30000,"vwx@gmail.com");
insert into product values(9,"Table",2500,"abc@gmail.com");

insert into product( sellerID, productName, productID, price) values("ghi@gmail.com","Mouse",10,350);

-- Select max(productid) from product;
select * from product;

Select * from product where sellerID='s';

create table orders(
orderID int primary key,
productID int,
userID varchar(255),
dateOfOrder datetime,
foreign key(productID) references product(productID),
foreign key(userID) references user(emailID));

select * from orders;
delete from orders where orderID=0;
