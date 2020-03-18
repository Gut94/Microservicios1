CREATE TABLE parking_vehiculos
(
    id serial PRIMARY KEY,
    parking_name varchar(25) NOT NULL,
    plazas_coche int NOT NULL ,
    plazas_moto int NOT NULL,
    plazas_bici int NOT NULL
);