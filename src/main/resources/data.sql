INSERT INTO taxi (naam_chauffeur, type_auto, deleted, email_chauffeur) VALUES ("Henk" , "Bus", false, "TaxiApp1234@gmail.com");
INSERT INTO taxi (naam_chauffeur, type_auto, deleted, email_chauffeur) VALUES ("Herman" , "Auto", false, "TaxiApp1234@gmail.com");
INSERT INTO taxi (naam_chauffeur, type_auto, deleted, email_chauffeur) VALUES ("Harry" , "Bus", false, "TaxiApp1234@gmail.com");
INSERT INTO taxi (naam_chauffeur, type_auto, deleted, email_chauffeur) VALUES ("Hester" , "Auto", false, "TaxiApp1234@gmail.com");
INSERT INTO taxi (naam_chauffeur, type_auto, deleted, email_chauffeur) VALUES ("Halil" , "Bus", false, "TaxiApp1234@gmail.com");

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
