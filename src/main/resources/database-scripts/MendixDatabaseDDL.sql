-- mendix.ingredient definition

-- Drop table

-- DROP TABLE mendix.ingredient;

CREATE TABLE mendix.ingredient (
	id bigserial NOT NULL,
	ingredient_name varchar NOT NULL,
	CONSTRAINT ingredient_pk PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE mendix.ingredient OWNER TO postgres;
GRANT ALL ON TABLE mendix.ingredient TO postgres;


-- mendix.recipe definition

-- Drop table

-- DROP TABLE mendix.recipe;

CREATE TABLE mendix.recipe (
	id bigserial NOT NULL,
	recipe_name varchar NOT NULL,
	directions varchar NULL,
	yield numeric NULL,
	CONSTRAINT recipe_name_un UNIQUE (recipe_name),
	CONSTRAINT recipe_pk PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE mendix.recipe OWNER TO postgres;
GRANT ALL ON TABLE mendix.recipe TO postgres;


-- mendix.category definition

-- Drop table

-- DROP TABLE mendix.category;

CREATE TABLE mendix.category (
	id bigserial NOT NULL,
	recipe_id int8 NOT NULL,
	category_name varchar NOT NULL,
	CONSTRAINT category_fk FOREIGN KEY (recipe_id) REFERENCES mendix.recipe(id)
);
COMMENT ON TABLE mendix.category IS 'Different category labels for recipes...';

-- Permissions

ALTER TABLE mendix.category OWNER TO postgres;
GRANT ALL ON TABLE mendix.category TO postgres;


-- mendix.recipe_ingredient definition

-- Drop table

-- DROP TABLE mendix.recipe_ingredient;

CREATE TABLE mendix.recipe_ingredient (
	id bigserial NOT NULL,
	recipe_id int8 NOT NULL,
	ingredient_id int8 NOT NULL,
	unit varchar NULL,
	quantity varchar NULL,
	decription varchar NULL,
	CONSTRAINT recipe_ingredient_pk PRIMARY KEY (id),
	CONSTRAINT recipe_ingredient_fk FOREIGN KEY (recipe_id) REFERENCES mendix.recipe(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT recipe_ingredient_fk_1 FOREIGN KEY (ingredient_id) REFERENCES mendix.ingredient(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Permissions

ALTER TABLE mendix.recipe_ingredient OWNER TO postgres;
GRANT ALL ON TABLE mendix.recipe_ingredient TO postgres;