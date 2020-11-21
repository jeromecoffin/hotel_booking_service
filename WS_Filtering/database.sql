CREATE DATABASE reservation_hotel CHARACTER SET 'utf8';
USE reservation_hotel;

CREATE TABLE hotel (
	id INT NOT NULL AUTO_INCREMENT,
	nom VARCHAR(10) NOT NULL,
	nb_rooms_available INT NOT NULL,
	
	PRIMARY KEY(id)
)ENGINE=INNODB;

CREATE TABLE chambre (
	id INT NOT NULL AUTO_INCREMENT,
	hotel_id INT NOT NULL,
	room_number INT NOT NULL,
	
	PRIMARY KEY(id),
	FOREIGN KEY(hotel_id) REFERENCES hotel(id)
)ENGINE=INNODB;

CREATE TABLE reservations (
	id INT NOT NULL AUTO_INCREMENT,
	room_id INT NOT NULL,
	hotel_id INT NOT NULL,
	date_debut DATE NOT NULL,
	date_fin DATE NOT NULL,
	
	PRIMARY KEY(id),
	FOREIGN KEY(room_id) references chambre(id),
	FOREIGN KEY(hotel_id) references chambre(hotel_id)
	
)ENGINE=INNODB;

INSERT INTO hotel
values (1, 'IBIS', 5);
INSERT INTO hotel
values (2, 'Mercure', 5);
INSERT INTO hotel
values (3, 'Le Meurice', 5);

INSERT INTO chambre --chambres pour hotel IBIS
values (1, 1, 101);
INSERT INTO chambre
values (2, 1, 102);
INSERT INTO chambre
values (3, 1, 103);
INSERT INTO chambre
values (4, 1, 104);
INSERT INTO chambre
values (5, 1, 105);

INSERT INTO chambre --chambres pour hotel Mercure
values (6, 2, 201);
INSERT INTO chambre
values (7, 2, 202);
INSERT INTO chambre
values (8, 2, 203);
INSERT INTO chambre
values (9, 2, 204);
INSERT INTO chambre
values (10, 2, 205);

INSERT INTO chambre --chambres pour hotel Le Meurice
values (11, 3, 301);
INSERT INTO chambre
values (12, 3, 302);
INSERT INTO chambre
values (13, 3, 303);
INSERT INTO chambre
values (14, 3, 304);
INSERT INTO chambre
values (15, 3, 305);

INSERT INTO reservation --reservation IBIS
values (1, 1, 1, '2020/11/21', '2020/11/30');

INSERT INTO reservation --reservation Mercure
values (2, 2, 2, '2020/12/1', '2020/12/25');

INSERT INTO reservation --reservation Le Meurice
values (3, 3, 3, '2020/12/26', '2020/12/31');