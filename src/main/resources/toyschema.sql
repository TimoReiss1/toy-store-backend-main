
CREATE TABLE warehouse(
                          id SERIAL NOT NULL,
                          numberOfRows INTEGER NOT NULL,
                          numberOfColumns INTEGER NOT NULL,
                          shelfSize INTEGER NOT NULL
);

CREATE TABLE producer (
                          id SERIAL NOT NULL,
                          name VARCHAR(50),
                          address VARCHAR(50)
);
/******************************************************************************/
/***                              Primary Keys                              ***/
/******************************************************************************/
ALTER TABLE toy ADD PRIMARY KEY (id);
ALTER TABLE warehouse ADD PRIMARY KEY (id);
ALTER TABLE producer ADD PRIMARY KEY (id);
/******************************************************************************/
/***                              Foreign Keys                              ***/
/******************************************************************************/
ALTER TABLE toy ADD FOREIGN KEY (producerId) REFERENCES producer (id);
/******************************************************************************/
/***                              Test Data                                 ***/
/******************************************************************************/
INSERT INTO producer (name) VALUES ('EosToys', 'Steindamm71');
INSERT INTO toy (classType, id, name, toySize, producerId, numberOfWheels) VALUES ('Car', '5b9dbead-7aee-453c-a96d-2cd708d9fd7c', 'Ford-GT40', 'XL', '1', '4');
INSERT INTO toy (classType, id, name, toySize, producerId, numberOfWheels) VALUES ('Car', '7b87d132-ac2d-44fc-bda8-a4037ac46a4e', 'Tesla X', 'L', '1', '4');
INSERT INTO toy (classType, id, name, toySize, producerId) VALUES ('Starship', 'e604cbc5-277f-4a36-aa14-ffd9cd09f56b', 'Y-Wing', 'S', '1');
INSERT INTO toy (classType, id, name, toySize, producerId, numberOfWheels) VALUES ('Car', 'ba7f4d94-4919-4427-bb7d-f4674224765e', 'VW Golf', 'S', '1', '4');
INSERT INTO toy (classType, id, name, toySize, producerId) VALUES ('Starship', 'b13044b2-2820-4737-b6f3-6f2646ef324a', 'X-Wing', 'S', '1');
INSERT INTO warehouse (numberOfRows, numberOfColumns, shelfSize) VALUES ('10', '10', '50');