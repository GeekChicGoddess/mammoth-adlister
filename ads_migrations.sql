USE adlister_db;

--TRUNCATE ads;


CREATE TABLE users (
	id INT(11) NOT NULL AUTO_INCREMENT,
	username VARCHAR(10),
	password VARCHAR(15),
	email VARCHAR(100),
	PRIMARY KEY (id)
);

CREATE TABLE ads (
	id INT(11) NOT NULL AUTO_INCREMENT,
	user_id INT(11),
	title VARCHAR(255),
	description VARCHAR(500),
	PRIMARY KEY (id),
	Foreign key (user_id) references users (id)
);

