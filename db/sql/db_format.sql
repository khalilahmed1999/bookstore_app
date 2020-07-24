
CREATE TABLE kiado (
	nev TEXT PRIMARY KEY
);

CREATE TABLE iro (
	nev TEXT PRIMARY KEY
);

CREATE TABLE konyv (
	isbn INTEGER PRIMARY KEY,
	cim TEXT,
	kiado TEXT,
	kiadasi_ev INTEGER,
	kategoria TEXT,
	oldalak_szama INTEGER,
	ar INTEGER,
	felvetel_datuma INTEGER,
	FOREIGN KEY (kiado) REFERENCES kiado (nev)
	ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE szerzoje (
	isbn INTEGER,
	szerzo TEXT,
	PRIMARY KEY (isbn, szerzo),
	FOREIGN KEY (isbn) REFERENCES konyv (isbn)
	ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (szerzo) REFERENCES iro (nev)
	ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE kategoria (
	megnevezes TEXT PRIMARY KEY,
	fokategoria TEXT,
	FOREIGN KEY (fokategoria) REFERENCES kategoria (megnevezes)
	ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE rendeles (
	rendelesszam INTEGER PRIMARY KEY,
	megrendelo TEXT,
	telefonszam TEXT,
	email TEXT,
	szallitasi_cim TEXT,
	rendeles_datuma INTEGER,
	allapot TEXT
);

CREATE TABLE rendeles_tetel (
	rendelesszam INTEGER,
	isbn INTEGER,
	mennyiseg INTEGER,
	PRIMARY KEY (rendelesszam, isbn),
	FOREIGN KEY (rendelesszam) REFERENCES rendeles (rendlelesszam)
	ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (isbn) REFERENCES konyv (isbn)
	ON DELETE SET NULL ON UPDATE CASCADE
);
