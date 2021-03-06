CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	created_on TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	name VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	password VARCHAR(100) NOT NULL
);

CREATE TABLE lists (
	list_id SERIAL PRIMARY KEY,
	created_on TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	list_name VARCHAR(100) NOT NULL,
	owner_id INTEGER NOT NULL,

	CONSTRAINT fk_lists_users FOREIGN KEY (owner_id)
    REFERENCES users (user_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE list_items (
	item_id SERIAL PRIMARY KEY,
	created_on TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	list_id INTEGER NOT NULL,
	item_name VARCHAR(100) NOT NULL,
	quantity DECIMAL NOT NULL,
	done BOOLEAN DEFAULT FALSE NOT NULL,

	CONSTRAINT fk_items_lists FOREIGN KEY (list_id)
	REFERENCES lists (list_id)
	ON UPDATE CASCADE ON DELETE CASCADE
);

