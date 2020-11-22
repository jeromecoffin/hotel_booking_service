CREATE DATABASE reservation_hotel CHARACTER SET 'utf8';
USE reservation_hotel;

CREATE TABLE hotel (
	id INT NOT NULL AUTO_INCREMENT,
	nom VARCHAR(10) NOT NULL,
	nb_rooms_total INT NOT NULL,
	nb_rooms_available INT,
	
	PRIMARY KEY(id)
)ENGINE=INNODB;


CREATE TABLE reservations (
	id INT NOT NULL AUTO_INCREMENT,
	hotel_id INT NOT NULL,
	date_debut DATE NOT NULL,
	nb_of_nights INT NOT NULL,
	nb_rooms_reserved INT NOT NULL,
	
	PRIMARY KEY(id),
	FOREIGN KEY(hotel_id) references hotel(id)
	
)ENGINE=INNODB;

INSERT INTO hotel
values (1, 'IBIS', 7, 3);
INSERT INTO hotel
values (2, 'Mercure', 8, 7);
INSERT INTO hotel
values (3, 'Le Meurice', 10, 7);


INSERT INTO reservations
values (1, 1, '2020-11-21', 1, 1);

INSERT INTO reservations
values (2, 2, '2020-12-1', 2, 3);

INSERT INTO reservations
values (3, 3, '2020-12-26', 3, 5);