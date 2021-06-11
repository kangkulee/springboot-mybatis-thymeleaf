CREATE TABLE IF NOT EXISTS user
(
    user_no INT AUTO_INCREMENT NOT NULL,
    user_id VARCHAR(30) NOT NULL,
	user_name VARCHAR(30) NOT NULL,
	user_password VARCHAR(100) NOT NULL,
	user_addr VARCHAR(200),
	user_phone VARCHAR(20),
	user_email VARCHAR(30),
	user_role VARCHAR(10),
	create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT user_pkey PRIMARY KEY (user_no),
	CONSTRAINT user_ukey UNIQUE KEY (user_id)
);

CREATE TABLE IF NOT EXISTS product
(
	product_no INT AUTO_INCREMENT NOT NULL,
	product_name VARCHAR(20) NOT NULL,
	product_content VARCHAR(200) NOT NULL,
	product_price VARCHAR(20) NOT NULL,
	CONSTRAINT product_pkey PRIMARY KEY (product_no)
);

CREATE TABLE IF NOT EXISTS orders
(
	order_no INT UNSIGNED AUTO_INCREMENT NOT NULL,
	user_no INT NOT NULL,
	product_no INT NOT NULL,
	order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	order_quantity INT,
	order_totalPrice VARCHAR(20),
	CONSTRAINT orders_order_no_pkey PRIMARY KEY (order_no),
	CONSTRAINT orders_user_no_fkey FOREIGN KEY (user_no) REFERENCES user(user_no) ON DELETE CASCADE,
	CONSTRAINT orders_product_no_fkey FOREIGN KEY (product_no) REFERENCES product(product_no)
);

CREATE TABLE IF NOT EXISTS role
(
	role_no INT NOT NULL PRIMARY KEY,
	role_name varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_role
(
	user_no INT NOT NULL,
  	role_no INT NOT NULL,
  	FOREIGN KEY (user_no) REFERENCES user (user_no),
  	FOREIGN KEY (role_no) REFERENCES role (role_no)
);

INSERT INTO role VALUE(1, "ADMIN");
INSERT INTO role VALUE(2, "USER");