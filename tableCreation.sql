create table people (
    id BIGINT NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    order_id BIGINT,
    dish_id BIGINT NOT NULL,
    dish_rating BIGINT NOT NULL
);

create table orders (
    id BIGINT NOT NULL PRIMARY KEY,
    dish_id BIGINT NOT NULL
);

create table dishes (
    id BIGINT NOT NULL PRIMARY KEY,
    dish_name BIGINT NOT NULL,
    dish_overall_rating BIGINT
);