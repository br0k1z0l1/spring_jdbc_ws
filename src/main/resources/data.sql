INSERT INTO country (code, countryname)
VALUES
    ('US', 'United States'),
    ('GB', 'United Kingdom'),
    ('FR', 'France'),
    ('AE', 'United Arab Emirates'),
    ('HU', 'Hungary');


INSERT INTO famousbuilding (buildingname, countrycode, height)
VALUES
    ('Burj Khalifa', 'AE', 828),
    ('Eiffel Tower', 'FR', 300),
    ('Empire State Building', 'US', 443),
    ('MOL Campus', 'HU', 150)
;

UPDATE country
SET in_EU = TRUE
WHERE code in ('FR', 'HU');