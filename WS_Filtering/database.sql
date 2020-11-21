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
	date_min_av DATETIME NOT NULL,
	date_max_av DATETIME NOT NULL,
	
	PRIMARY KEY(id),
	FOREIGN KEY(hotel_id) REFERENCES hotel(id)
)ENGINE=INNODB;

CREATE TABLE reservations (
	id INT NOT NULL AUTO_INCREMENT,
	room_id INT NOT NULL,
	hotel_id INT NOT NULL,
	date_debut DATETIME NOT NULL,
	date_fin DATETIME NOT NULL,
	nb_nights INT NOT NULL,
	
	PRIMARY KEY(id),
	FOREIGN KEY(room_id) references chambre(id),
	FOREIGN KEY(hotel_id) references chambre(hotel_id)
	
)ENGINE=INNODB;