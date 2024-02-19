-- SQL CREATE TABLE for Motorvogn
CREATE TABLE Motorvogn
(
    id INTEGER AUTO_INCREMENT NOT NULL,          -- Unik identifikator med AUTO_INCREMENT for automatisk økning
    personnr VARCHAR(255) NOT NULL,              -- Personnummer, ikke-null og med maksimal lengde på 255 tegn
    navn VARCHAR(255) NOT NULL,                  -- Navn, ikke-null og med maksimal lengde på 255 tegn
    adresse VARCHAR(255) NOT NULL,               -- Adresse, ikke-null og med maksimal lengde på 255 tegn
    kjennetegn VARCHAR(255) NOT NULL,            -- Kjennetegn, ikke-null og med maksimal lengde på 255 tegn
    merke VARCHAR(255) NOT NULL,                 -- Merke, ikke-null og med maksimal lengde på 255 tegn
    type VARCHAR(255) NOT NULL,                  -- Type, ikke-null og med maksimal lengde på 255 tegn

    PRIMARY KEY (id)                             -- Primærnøkkel satt til 'id'
);
