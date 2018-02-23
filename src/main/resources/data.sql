INSERT INTO taxi (naam_chauffeur, type_auto, deleted, email_chauffeur) VALUES ("Henk" , "Bus", false, "TaxiApp1234@gmail.com");
INSERT INTO taxi (naam_chauffeur, type_auto, deleted, email_chauffeur) VALUES ("Herman" , "Auto", false, "TaxiApp1234@gmail.com");
INSERT INTO taxi (naam_chauffeur, type_auto, deleted, email_chauffeur) VALUES ("Harry" , "Bus", false, "TaxiApp1234@gmail.com");
INSERT INTO taxi (naam_chauffeur, type_auto, deleted, email_chauffeur) VALUES ("Hester" , "Auto", false, "TaxiApp1234@gmail.com");
INSERT INTO taxi (naam_chauffeur, type_auto, deleted, email_chauffeur) VALUES ("Halil" , "Bus", false, "TaxiApp1234@gmail.com");

INSERT INTO rit	(date, plaats, deleted) VALUES ("2018-01-13 12:00:00", "Utrecht", false);
INSERT INTO rit (date, plaats, deleted) VALUES ("2018-02-13 15:00:00", "Amsterdam", false);
INSERT INTO rit (date, plaats, deleted) VALUES ("2018-02-13 15:00:00", "Gorinchem", false);
INSERT INTO rit (date, plaats, deleted) VALUES ("2018-02-16 15:00:00", "Breda", false);
INSERT INTO rit (date, plaats, deleted) VALUES ("2018-02-13 15:00:00", "Eindhoven", false);
INSERT INTO rit (date, plaats, deleted) VALUES ("2018-02-18 11:00:00", "Rotterdam", false);

INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (1,1);

INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (2,2);

INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (3,3);

INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (4,4);
INSERT INTO taxi_x_rit (taxi_id, rit_id) VALUES (4,5);