BEGIN TRANSACTION;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS breweries;
DROP TABLE IF EXISTS beer;
DROP TABLE IF EXISTS reviews;
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE breweries (
    brewery_id SERIAL,
    brewer_id int NOT NULL,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) UNIQUE NOT NULL,
    website_url VARCHAR(255) UNIQUE NOT NULL,
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    hours_of_operation VARCHAR(255),
    CONSTRAINT pk_brewery PRIMARY KEY (brewery_id),
    CONSTRAINT fk_brewer FOREIGN KEY (brewer_id) REFERENCES users(user_id)
);
CREATE TABLE beer (
    beer_id SERIAL,
    brewery_id INT NOT NULL,
    beer_name VARCHAR(255) NOT NULL,
    beer_description VARCHAR(255),
    image VARCHAR(255),
    abv decimal,
    beer_type VARCHAR(255),
    CONSTRAINT pk_beer PRIMARY KEY (beer_id),
    CONSTRAINT fk_brewery FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id)
);
CREATE TABLE reviews (
    review_id SERIAL,
    user_id int NOT NULL,
    beer_id int NOT NULL,
    beer_name VARCHAR(100) NOT NULL,
    brewery_name VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    rating int NOT NULL,
    CONSTRAINT pk_review PRIMARY KEY (review_id),
    CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_review_beer FOREIGN KEY (beer_id) REFERENCES beer(beer_id)
);
COMMIT TRANSACTION;
-- ROLLBACK;