DROP TABLE IF EXISTS officers;
CREATE TABLE officers (
  id         SERIAL NOT NULL,
  rank       VARCHAR(20) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE toy (
                     id        uuid NOT NULL,
                     name VARCHAR(50) NOT NULL,
                     size      VARCHAR(50) NOT NULL,
                     speed   VARCHAR(5) NOT NULL,
                     distance INTEGER NOT NULL,
                     numberOfWheels INTEGER,
                     type VARCHAR(10) NOT NULL
);
/*
         name: string
        size: string
        speed: number
        distance: number
        wheels? : number
        type: string
 */