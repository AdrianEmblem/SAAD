DROP TABLE IF EXISTS TBL_ANIMAL;

CREATE TABLE TBL_ANIMAL (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  tipo VARCHAR(250) NOT NULL,
  raza VARCHAR(250) NOT NULL,
  pelaje VARCHAR(250) NOT NULL,
  fecha_nacimiento VARCHAR (250) NOT NULL,
  vacunas VARCHAR (250) NOT NULL
);