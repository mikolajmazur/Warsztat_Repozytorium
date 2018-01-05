insert into client(first_name, last_name) VALUES ('Józef', 'Abacki');
insert into client(first_name, last_name) VALUES ('Adrian', 'Duda');
insert into client(first_name, last_name) VALUES ('Beata', 'Szydło');

insert into product(name, price) VALUES ('stól', 300);
insert into product(name, price) VALUES ('krzesło', 30);
insert into product(name, price) VALUES ('granat', 100);
insert into product(name, price) VALUES ('mina przeciwpiechotna', 500);
insert into product(name, price) VALUES ('kremówka', 21.37);

insert into app_order(date, client_id) values ('13.10.2017', 3);
insert into app_order(date, client_id) values ('3.1.2017', 2);
insert into app_order(date, client_id) values ('20.3.2017', 3);
insert into app_order(date, client_id) values ('4.1.2017', 2);

insert into order_detail(quantity, product_id, order_id) VALUES (5, 5, 2);
insert into order_detail(quantity, product_id, order_id) VALUES (1, 4, 2);
insert into order_detail(quantity, product_id, order_id) VALUES (1, 1, 2);

insert into order_detail(quantity, product_id, order_id) VALUES (4, 2, 3);
insert into order_detail(quantity, product_id, order_id) VALUES (5, 2, 3);

insert into order_detail(quantity, product_id, order_id) VALUES (10, 3, 4);