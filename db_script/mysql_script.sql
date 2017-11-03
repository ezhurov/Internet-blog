
DROP DATABASE IF EXISTS course;

CREATE DATABASE course CHARACTER SET utf8 COLLATE utf8_general_ci;

USE course;

CREATE TABLE users(
	id INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
	username VARCHAR(255) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	enabled BOOLEAN DEFAULT true,
	role VARCHAR(255) DEFAULT 'ROLE_USER'
);

CREATE TABLE personaldata(
	id INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
	userid INT NOT NULL UNIQUE,
	surname VARCHAR(255),
	name VARCHAR(255),
	patronymic VARCHAR(255),
	FOREIGN KEY (userid) REFERENCES users (id)
);

CREATE TABLE posts(
	id INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
	userid INT NOT NULL,
	theme VARCHAR(255) NOT NULL,
	post LONGTEXT NOT NULL,
	datatime VARCHAR(255) NOT NULL,
	FOREIGN KEY (userid) REFERENCES users (id)
);

CREATE TABLE likespost(
	id INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
	postid INT NOT NULL,
	userid INT NOT NULL,
	likes INT DEFAULT 1,
	FOREIGN KEY (postid) REFERENCES posts (id),
	FOREIGN KEY (userid) REFERENCES users (id)
);

CREATE TABLE images(
	id INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
	postid INT NOT NULL,
	image MEDIUMBLOB,
	FOREIGN KEY (postid) REFERENCES posts (id)
);

CREATE TABLE comments(
	id INT AUTO_INCREMENT UNIQUE PRIMARY KEY,
	postid INT NOT NULL,
	userid INT NOT NULL,
	comment TEXT NOT NULL,
	datatime VARCHAR(255) NOT NULL,
	FOREIGN KEY (postid) REFERENCES posts (id),
	FOREIGN KEY (userid) REFERENCES users (id)
);

INSERT INTO users (username, password, email, enabled, role) VALUES ('admin', 'admin', 'admin@example.com', true, 'ROLE_ADMIN');
INSERT INTO users (username, password, email, enabled, role) VALUES ('user', 'user', 'user@example.com', true, 'ROLE_USER');
INSERT INTO personaldata (userid, surname, name, patronymic) VALUES (1, 'Ivanov', 'Ivan', 'Ivanovich');
