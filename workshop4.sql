drop database if exists paf_workshop4;

create database paf_workshop4;

use paf_workshop4;

create table orders (
	order_id auto_increment,
	order_date date not null,
    customer_name varchar(128) not null, 
    ship_address varchar(128) not null,
	notes text,
    tax decimal(2,2) default 0.05,
    
    primary key(order_id)
);

create table order_details {
    id auto_increment,
    product varchar(64) not null,
    unit_price decimal(3,2) not null,
    discount decimal(2,2) default 1.0,
    quantity integer not null,
    order_id integer not null,

    primary key(id),
    constraint fk_order_id
        foreign key(order_id) references purchase_order(order_id)
}