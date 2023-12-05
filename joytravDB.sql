DROP DATABASE IF EXISTS joytrav_management;
CREATE DATABASE IF NOT EXISTS joytrav_management;
USE joytrav_management;

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
	id 			INT UNSIGNED PRIMARY KEY,
	firstname	VARCHAR(80) NOT NULL, -- register
	lastname	VARCHAR(80) NOT NULL, -- register
	email		VARCHAR(255) NOT NULL UNIQUE, -- register
	`password`	TEXT NOT NULL, -- register
	gender		BOOLEAN DEFAULT TRUE, -- register
	phone		VARCHAR(15), -- registerusers
	address		VARCHAR(255),
    dob			DATE,
    avatar		TEXT,
    `status`	BOOLEAN DEFAULT 1 ,
   `role`		ENUM('ADMIN', 'USER') NOT NULL
);

ALTER TABLE `account`
ADD is_login BOOLEAN DEFAULT false;

CREATE TABLE LoginInfo(
	account_id 		INT UNSIGNED PRIMARY KEY,
	is_login 		BOOLEAN,
    FOREIGN KEY (account_id) REFERENCES `account` (id)
); 


CREATE TABLE `type` (
	id  	VARCHAR(5) NOT NULL PRIMARY KEY,
	title	VARCHAR(100) NOT NULL
);

INSERT INTO `type`(id, title)
VALUES			  ('DOMES', 'Domestic'),
				  ('INTER', 'International');
 
 -- Table Hotel 
CREATE TABLE hotel(
	id 			VARCHAR(255) NOT NULL PRIMARY KEY,
    `name`		VARCHAR(255) NOT NULL,
    address	 	TEXT NOT NULL,
    phone		VARCHAR(15),
    intro 		TEXT(5000) NOT NULL, 
    price		INT NOT NULL,
    discount	INT DEFAULT 0,
    type_id		VARCHAR(5) NOT NULL,
    CONSTRAINT  FK_hotel_type FOREIGN KEY(type_id) REFERENCES `type`(id)
);

INSERT INTO	hotel(id, `name`, address, phone, intro, price, discount, type_id)
VALUES('HOTELRGX2287-BC9I7C', 'The Almin Hotel', 'Đường 25/04 Khu Đô Thị Việt Hàn, Phường Hồng Gai, Ha Long 200000 Việt Nam', '0388 238 238',
	   'Tái hiện không gian sống với đặc quyền có tầm nhìn ngoạn mục ra những tòa nhà cao tầng nổi tiếng nhất thế giới như Burj Al Arab (Dubai), Trump Tower (Manhattan)… Sunshine Golden River - thiết kế đầu tiên bộ sưu tập căn hộ cao cấp có sân vườn riêng tại Hà Nội.',
       '400', 10, 'DOMES'),
       ('HOTELLBX5000-6SRB46','Paos Sapa', 'Muong Hoa Street, Sapa 661300 Việt Nam', '0214 6253 999',  
		'Located in Sa Pa, 6.1 km from Fansipan Legend Cable Car Station, Pao Sapa Leisure Hotel provides accommodation with a fitness centre, free private parking, a garden and a shared lounge.', 
		'300', 0, 'DOMES'),
		('HOTELLEK6033-OHB6RJ', 'Châu Long II', '24 Phố đồng Lợi, Sapa 333101 Việt Nam', '0914 602 529', 
		'Chau Long Sapa Hotel II, designed to resemble a red-stone castle, is situated on a tranquil side street in the heart of Sapa town.',
		'300', 0, 'DOMES'),
		('HOTELBYP0732-9KOGQK', 'Muong Thanh Luxury', 'Đường Hạ Long Block 1, Area 2, Bai Chay, Vịnh Hạ Long 200000 Việt Nam',  '0203 3812 468',
		 'Dựng đứng trên bờ biển, Muong Thanh cung cấp chỗ ở sang trọng với tầm nhìn đẹp tuyệt ra Di sản thế giới UNESCO - Vịnh Hạ Long.', 
		 500, 0, 'DOMES');

-- -- International                 
INSERT INTO	hotel(id, `name`, address, phone, intro, price, discount, type_id)
VALUES			('HOTELPTI2367-91MVPI', 'Navy Lodge Rota Spain', '09645 Rota Tây Ban Nha', '34956822643',
				 'Navy Lodge has great rooms, very clean, free parking and free breakfast. Front desk staff are the very best',
				 1000, 0, 'INTER'),
                 ('HOTELGXW3780-CZ1RS6', 'Malte - Astotel', '63 rue de Richelieu, 75002 Paris Pháp', '+3144589494', 
				 'Located in the historic district in central Paris, the 4-star Hotel Malte - Astotel is only 650 metres from the Louvre Museum.',
				 800, 0, 'INTER'),
                 ('HOTELXXW8711-ZPX44T', 'Casati', 'Germany - Greece - Hungary.',  '+334970225',
			 	  'Located in Nice and with Plage Lido reachable within 1.1 km, Boutique Hotel Nice Côte dazur provides concierge services, non-smoking rooms, a shared lounge.',
				 800, 0, 'INTER'),
                 ('HOTELXNY6642-TNMHIM', 'Boutique Hotel Nice Côte dazu', 'Arsenalsgatan 6, Stockholm 111 47 Thụy Điển',  null, 
				 'Boutique Hotel Nice Cote DAzur is a cosy 4-star property set within 2 km to the historic Castle Hill of Nice Hilltop Park and 17 minutes walk of St Nicholas Cathedral. This Nice',
				 700, 0, 'INTER');
 
-- Table Tour 
CREATE TABLE tour (
	id 					VARCHAR(255) NOT NULL PRIMARY KEY,
    title				VARCHAR(255) NOT NULL,
    intro 				TEXT(5000) NOT NULL,
    price				DOUBLE,
    slots				TINYINT UNSIGNED NOT NULL,
	category			ENUM("Heath", "Cultural", "Religious", "Sport"),
    sale 				ENUM('none', '10', '20', '30'),
    type_id				VARCHAR(5) NOT NULL,
	departure			VARCHAR(255) NOT NULL,
    destination 		VARCHAR(255) NOT NULL,
    duration			TINYINT NOT NULL,
    vehicle				ENUM('TRAVEL BUS', 'AIRPLANE', 'TRAIN', 'CRUISE'),
    departure_date		DATE NOT NULL, 
    hotel_id			VARCHAR(255),
    CONSTRAINT FK_tour_hotel FOREIGN KEY(hotel_id) REFERENCES hotel(id),
    CONSTRAINT FK_tour_type FOREIGN KEY(type_id) REFERENCES `type`(id)
);

CREATE TABLE  `schedule`(
	id			INT AUTO_INCREMENT PRIMARY KEY, 
	title		TEXT,
    content		TEXT,
    tour_id 	VARCHAR(255),
	CONSTRAINT fk_schedule_tour FOREIGN KEY (tour_id) REFERENCES tour(id)
);

CREATE TABLE picture(
	id 			INT	AUTO_INCREMENT PRIMARY KEY,
    link 		VARCHAR (5000),
    catalog 	ENUM ('TOUR', 'HOTEL') NOT NULL,
    tour_id		VARCHAR(255),
    CONSTRAINT fk_tour_picture FOREIGN KEY (tour_id) REFERENCES tour(id)
);


 CREATE TABLE customer(
	id			INT NOT NULL PRIMARY KEY,
    full_name	VARCHAR(255) NOT NULL,
    email		VARCHAR(255) NOT NULL,
    phone		VARCHAR(15) NOT NULL,
    address		VARCHAR(255)
 );	

 CREATE TABLE booking(
	id 				VARCHAR(255) NOT NULL PRIMARY KEY,
    booking_date	DATE,
    payment			ENUM('CASH', 'CARD', 'BANK'),
	`status`		ENUM('pending', 'completion'),
    total			INT,
	customer_id 	INT,
	CONSTRAINT fk_customer_booking FOREIGN KEY(customer_id) REFERENCES customer(id)
);

 INSERT INTO booking (id, bookingDate, payment, `status`, total, tour_id, customer_id)
 VALUES ('BOOKINGLMR8341-GBVZ0N', '2023-11-30', 'CASH', 'pending', 2000, 'TOURBEG7043-FKBR78', 289724266);


 INSERT INTO customer (id, full_name, email, phone, address)
 VALUES (289724266, 'Vu Van Duc', 'duc@gmail.com', '0968888888', 'Tan Binh');

  CREATE TABLE 	passengers(
	id			INT NOT NULL PRIMARY KEY,
    full_name	VARCHAR(255) NOT NULL,
	gender		BOOLEAN DEFAULT 1,
	dob			DATE ,
	group_age	ENUM('ADULTS', 'CHILDREN', 'TODDLERS', 'INFANTS'),
    booking_id	VARCHAR(255),
    CONSTRAINT fk_passengers_booking FOREIGN KEY(booking_id) REFERENCES booking(id)
 );	
 
INSERT INTO passengers (id, full_name, gender, dob, `group`, booking_id)
 VALUES (957866315, 'Nguyen Van A', true, '1990-12-17 ', 'ADULTS', 'BOOKINGLMR8341-GBVZ0N');
 
CREATE TABLE booking_details(
	customer_id		INT NOT NULL,
    tour_id			VARCHAR(255) NOT NULL,
    PRIMARY KEY(customer_id, tour_id),
	CONSTRAINT fk_booking_detail_customer FOREIGN KEY(customer_id) REFERENCES customer(id),
    CONSTRAINT fk_booking_detail_tour FOREIGN KEY(tour_id) REFERENCES tour(id)
);



