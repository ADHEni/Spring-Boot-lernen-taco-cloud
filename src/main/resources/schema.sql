CREATE TABLE IF NOT EXISTS Taco_Order(

    id IDENTITY,
    delivery_name VARCHAR(255) NOT NULL,
    delivery_street VARCHAR(255) NOT NULL,
    delivery_city VARCHAR(255) NOT NULL,
    delivery_state VARCHAR(255) NOT NULL,
    delivery_zip VARCHAR(255) NOT NULL,
    order_placed_at TIMESTAMP NOT NULL,
    credit_card_number VARCHAR(16) NOT NULL,
    credit_card_expiration VARCHAR(5) NOT NULL,
    credit_card_cvv CHAR(3) NOT NULL

);

CREATE TABLE IF NOT EXISTS Taco(

    id IDENTITY,
    taco_name CHAR(255) NOT NULL,
    taco_order_id BIGINT NOT NULL,
    taco_order_key bigint not null,
    created_at TIMESTAMP NOT NULL,
    FOREIGN KEY (taco_order_id) REFERENCES Taco_Order(ID)

);

CREATE TABLE IF NOT EXISTS Ingredient(

    id VARCHAR(4) PRIMARY KEY NOT NULL,
    ingredient_name VARCHAR(255) NOT NULL,
    ingredient_type VARCHAR(255) NOT NULL

);


CREATE TABLE IF NOT EXISTS Ingredient_Ref(

    taco_id BIGINT NOT NULL,
    ingredient_id VARCHAR(255) NOT NULL,
    taco_key bigint not null,
    FOREIGN KEY (taco_id) REFERENCES Taco(id),
    FOREIGN KEY (ingredient_id) REFERENCES Ingredient(id),
    PRIMARY KEY (taco_id, ingredient_id)

);