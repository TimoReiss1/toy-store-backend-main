
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
INSERT INTO toy (uuid, name, size, speed, distance, wheels, type) VALUES ('Car', '5b9dbead-7aee-453c-a96d-2cd708d9fd7c', 'Ford-GT40', 'XL', '1', '4');

INSERT INTO warehouse (numberOfRows, numberOfColumns, shelfSize) VALUES ('10', '10', '50');
/*        name: string
        size: string
        speed: number
        distance: number
        wheels? : number
        type: string*/