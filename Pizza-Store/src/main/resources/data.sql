INSERT INTO PIZZA VALUES (1001,'XYZVegS',200);
INSERT INTO PIZZA VALUES (1002,'XYZVegM',400);
INSERT INTO PIZZA VALUES (1003,'XYZVegL',600);
INSERT INTO PIZZA VALUES (1004,'XYZNonVegS',400);
INSERT INTO PIZZA VALUES (1005,'XYZNonVegM',600);
INSERT INTO PIZZA VALUES (1006,'XYZNonVegL',800);
INSERT INTO PIZZA VALUES (1007,'XYZVegSpecialM',800);
INSERT INTO PIZZA VALUES (1008,'XYZNonVegSpecialL',900);

commit;

INSERT INTO PIZZA_ORDER VALUES (5001,  200, '1234567890', 'Peter' ,1 ,   '1001');
INSERT INTO PIZZA_ORDER VALUES (5002,  400, '6574893012', 'Thomas',2  , '1001'   );
INSERT INTO PIZZA_ORDER VALUES (5003,  600, '1243568790', 'Decken',1, '1003'   );
INSERT INTO PIZZA_ORDER VALUES (5004,  800, '1029384756', 'Jenifer',2,'1004'   );
INSERT INTO PIZZA_ORDER VALUES (5005, 2400, '3214325432', 'Lisa'  ,3,   '1006' );
INSERT INTO PIZZA_ORDER VALUES (5006, 4500, '6789067854','Jill'   ,5 ,   '1008');

commit;