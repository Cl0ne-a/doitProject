CREATE TABLE IF NOT EXISTS DBUSER
(id INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL,
 user_name VARCHAR,
 user_password VARCHAR NOT NULL UNIQUE,
 age INTEGER,
 PRIMARY KEY (id));

CREATE TABLE if not exists DBARTICLE
(id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
 text VARCHAR,
 colour VARCHAR,
 reference int,
 CONSTRAINT refference_user FOREIGN KEY (reference) REFERENCES DBUSER(id)

);