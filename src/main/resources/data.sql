INSERT INTO taxi (naam_chauffeur, type_auto, deleted) VALUES ("Henk" , "Bus", false);
INSERT INTO taxi (naam_chauffeur, type_auto, deleted) VALUES ("Herman" , "Auto", false);
INSERT INTO taxi (naam_chauffeur, type_auto, deleted) VALUES ("Harry" , "Bus", false);
INSERT INTO taxi (naam_chauffeur, type_auto, deleted) VALUES ("Hester" , "Auto", false);
INSERT INTO taxi (naam_chauffeur, type_auto, deleted) VALUES ("Halil" , "Bus", false);

INSERT INTO rit	(date, plaats) VALUES ("2018-01-13 12:00:00", "Utrecht");
INSERT INTO rit (date, plaats) VALUES ("2018-02-13 15:00:00", "Amsterdam");
INSERT INTO rit (date, plaats) VALUES ("2018-02-13 15:00:00", "Gorinchem");
INSERT INTO rit (date, plaats) VALUES ("2018-02-13 15:00:00", "Breda");
INSERT INTO rit (date, plaats) VALUES ("2018-02-13 15:00:00", "Eindhoven");


INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (1,1);
INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (1,2);
INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (1,4);
INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (1,5);

INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (2,2);
INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (2,4);
INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (2,5);

INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (3,1);
INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (3,5);

INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (4,5);
INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (4,1);
INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (4,2);
