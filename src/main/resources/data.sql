insert into client(id, first_name, last_name) VALUES (1, 'Józef', 'Abacki');
insert into client(id, first_name, last_name) VALUES (2, 'Adrian', 'Duda');
insert into client(id, first_name, last_name) VALUES (3, 'Beata', 'Szydło');

insert into product(id, name, price, DTYPE, MATERIAL) VALUES (1, 'stól', 300, 'FurnitureProduct', 'drewno');
insert into product(id, name, price, DTYPE, MATERIAL) VALUES (2, 'krzesło', 30, 'FurnitureProduct', 'drewno');
insert into product(id, name, price, DTYPE, EXPLOSION_RANGE) VALUES (3, 'granat', 100, 'MilitaryExplosiveProduct', 5);
insert into product(id, name, price, DTYPE, EXPLOSION_RANGE) VALUES (4, 'mina przeciwpiechotna', 500, 'MilitaryExplosiveProduct', 3.5);
insert into product(id, name, price, DTYPE, CALORIES) VALUES (5, 'kremówka', 21.37, 'FoodProduct', 312);
insert into product(id, name, price, DTYPE, CALORIES) VALUES (6, 'tort', 20, 'FoodProduct', 1337);

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