insert into client(id, first_name, last_name) VALUES (1, 'Józef', 'Abacki');
insert into client(id, first_name, last_name) VALUES (2, 'Adrian', 'Duda');
insert into client(id, first_name, last_name) VALUES (3, 'Beata', 'Szydło');

insert into product(id, name, price) VALUES (1, 'stól', 300);
insert into product(id, name, price) VALUES (2, 'krzesło', 30);
insert into product(id, name, price) VALUES (3, 'granat', 100);
insert into product(id, name, price) VALUES (4, 'mina przeciwpiechotna', 500);
insert into product(id, name, price) VALUES (5, 'kremówka', 21.37);
insert into product(id, name, price) VALUES (6, 'zebra', 2000);

insert into app_order(id, date, client_id) values (1, '13.10.2017', 3);
insert into app_order(id, date, client_id) values (2, '3.1.2017', 2);
insert into app_order(id, date, client_id) values (3, '20.3.2017', 3);
insert into app_order(id, date, client_id) values (4, '4.1.2017', 2);

insert into order_detail(id, quantity, product_id, order_id) VALUES (1, 5, 5, 2);
insert into order_detail(id, quantity, product_id, order_id) VALUES (2, 1, 4, 2);
insert into order_detail(id, quantity, product_id, order_id) VALUES (3, 1, 1, 2);

insert into order_detail(id, quantity, product_id, order_id) VALUES (4, 4, 2, 3);
insert into order_detail(id, quantity, product_id, order_id) VALUES (5, 5, 2, 3);

insert into order_detail(id, quantity, product_id, order_id) VALUES (6, 10, 3, 4);