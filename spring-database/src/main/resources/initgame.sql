CREATE TABLE capitals (
	id SERIAL,
	country VARCHAR(40) NOT NULL,
	capital VARCHAR(40) NOT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE users (
	id SERIAL,
	name VARCHAR(40) NOT NULL,
	role_id INT NOT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE roles (
	id SERIAL,
	role VARCHAR(40) NOT NULL,
	PRIMARY KEY (id)
);


INSERT INTO roles (role) VALUES ('player');
INSERT INTO roles (role) VALUES ('admin');

INSERT INTO users (name, role_id) VALUES ('dushan', 1);
INSERT INTO users (name, role_id) VALUES ('tanya', 1);
INSERT INTO users (name, role_id) VALUES ('oggy', 2);

INSERT INTO capitals (country, capital) VALUES ('bulgaria', 'sofia');
INSERT INTO capitals (country, capital) VALUES ('serbia', 'belgrade');
INSERT INTO capitals (country, capital) VALUES ('kosovo', 'pristina');
INSERT INTO capitals (country, capital) VALUES ('macedonia', 'skopje');
INSERT INTO capitals (country, capital) VALUES ('montenegro', 'podgorica');
INSERT INTO capitals (country, capital) VALUES ('greece', 'athens');
INSERT INTO capitals (country, capital) VALUES ('albania', 'tirana');
INSERT INTO capitals (country, capital) VALUES ('romania', 'bucharest');
INSERT INTO capitals (country, capital) VALUES ('slovakia', 'bratislava');
INSERT INTO capitals (country, capital) VALUES ('croatia', 'zagreb');
INSERT INTO capitals (country, capital) VALUES ('bosnia and herzegovina', 'sarajevo');

