DROP TABLE IF EXISTS famousbuilding;
DROP TABLE IF EXISTS country;

CREATE TABLE country (
                         code VARCHAR(2) PRIMARY KEY,
                         countryname VARCHAR (30)
);

CREATE TABLE famousbuilding (
                                buildingname VARCHAR(30) primary key,
                                countrycode  VARCHAR(2),
                                height int
);

ALTER TABLE famousbuilding
    ADD FOREIGN KEY (countrycode) REFERENCES country(code);

ALTER TABLE country
    ADD COLUMN in_EU boolean DEFAULT FALSE;
