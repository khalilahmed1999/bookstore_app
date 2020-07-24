INSERT INTO iro (nev) VALUES ('Adrian Tchaikovsky');
INSERT INTO iro (nev) VALUES ('Alan Moore');
INSERT INTO iro (nev) VALUES ('Andy Weir');
INSERT INTO iro (nev) VALUES ('Anthony Burgess');
INSERT INTO iro (nev) VALUES ('Art Spiegelman');
INSERT INTO iro (nev) VALUES ('Bartis Attila');
INSERT INTO iro (nev) VALUES ('Dan Simmons');
INSERT INTO iro (nev) VALUES ('Eddie Campbell');
INSERT INTO iro (nev) VALUES ('Friedrich Nietzsche');
INSERT INTO iro (nev) VALUES ('George R. R. Martin');
INSERT INTO iro (nev) VALUES ('Immanuel Kant');
INSERT INTO iro (nev) VALUES ('Jeff Vandermeer');
INSERT INTO iro (nev) VALUES ('Joe Hill');
INSERT INTO iro (nev) VALUES ('Manfred Flügge');
INSERT INTO iro (nev) VALUES ('Marcus Aurelius');
INSERT INTO iro (nev) VALUES ('Michael Crichton');
INSERT INTO iro (nev) VALUES ('Richard J. Evans');
INSERT INTO iro (nev) VALUES ('Stanislaw Lem');
INSERT INTO iro (nev) VALUES ('Stephen W. Hawking');

INSERT INTO kiado (nev) VALUES ('Agave Könyvek Kiadó Kft.');
INSERT INTO kiado (nev) VALUES ('Akkord Kiadó Kft.');
INSERT INTO kiado (nev) VALUES ('Alexandra Kiadó');
INSERT INTO kiado (nev) VALUES ('Alexandra Könyvesház Kft.');
INSERT INTO kiado (nev) VALUES ('Corvinia Kiadó Kft.');
INSERT INTO kiado (nev) VALUES ('Fumax Kft.');
INSERT INTO kiado (nev) VALUES ('Gabo Könyvkiado Kft.');
INSERT INTO kiado (nev) VALUES ('Göncöl Kiadó Kft.');
INSERT INTO kiado (nev) VALUES ('Helikon Kiadó Kft.');
INSERT INTO kiado (nev) VALUES ('Kossuth Kiadó Zrt.');
INSERT INTO kiado (nev) VALUES ('Libri Könyvkiadó Kft.');
INSERT INTO kiado (nev) VALUES ('Magvető Kft.');
INSERT INTO kiado (nev) VALUES ('Park Könyvkiadó Kft.');
INSERT INTO kiado (nev) VALUES ('Vad Virágok Kiadó Kft.');

INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Szórakoztató irodalom','Irodalom');
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Szépirodalom','Irodalom');
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Irodalom',null);
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Társadalom tudományok',null);
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Filozófia','Társadalom tudományok');
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Regény','Szépirodalom');
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Történelem',null);
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Sci-fi','Szórakoztató irodalom');
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Thriller','Szórakoztató irodalom');
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Krimi','Szórakoztató irodalom');
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Fantasy','Szórakoztató irodalom');
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Képregény',null);
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Tudomány és Természet',null);
INSERT INTO kategoria (megnevezes, fokategoria) VALUES ('Csillagászat','Tudomány és Természet');

INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634472384','Dermesztő Nyár','Alexandra Könyvesház Kft.','2018','Krimi','672','4499',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634194347','Terror','Agave Könyvek Kiadó Kft.','2018','Thriller','714','5980',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789631365801','Nagyváros lélek nélkül. Bécs 1938','Corvinia Kiadó Kft.','2019','Történelem','431','4990',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789639183377','Ecce Homo','Göncöl Kiadó Kft.','2003','Filozófia','146','1895',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634793335','Elmélkedések','Helikon Kiadó Kft.','2019','Filozófia','165','1299',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634792987','Az örök béke','Helikon Kiadó Kft.','2019','Filozófia','84','1499',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789632276359','Gépnarancs','Helikon Kiadó Kft.','2016','Regény','220','2999',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634790853','Az úr hangja','Helikon Kiadó Kft.','2018','Regény','288','2999',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634194040','Expedíció','Agave Könyvek Kiadó Kft.','2018','Sci-fi','172','2980',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634700074','Az idő gyermekei','Fumax Kft.','2017','Sci-fi','612','4995',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789630984751','A gömb','Kossuth Kiadó Zrt.','2016','Sci-fi','413','3600',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634470878','Trónok harca','Alexandra Kiadó','2018','Fantasy','925','4999',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9786155514333','A marsi','Fumax Kft.','2015','Sci-fi','357','4495',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789633552605','A Harmadik Birodalom születése','Park Könyvkiadó Kft.','2015','Történelem','600','7500',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634192541','Borne','Agave Könyvek Kiadó Kft.','2017','Sci-fi','315','3580',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634700456','Hadállat','Fumax Kft.','2018','Sci-fi','340','3995',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634067962','NOS4A2','Gabo Könyvkiado Kft.','2019','Thriller','756','4990',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634333678','A teljes Maus','Libri Könyvkiadó Kft.','2019','Képregény','296','3799',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789632521213','Az idő rövid története','Akkord Kiadó Kft.','2019','Csillagászat','256','5690',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789634194071','Kontroll','Agave Könyvek Kiadó Kft.','2018','Sci-fi','321','3280',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789631422511','A nyugalom','Magvető Kft.','2018','Regény','326','3499',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789631425796','A séta','Magvető Kft.','2017','Regény','154','2490',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789630982771','Jurassic Park','Kossuth Kiadó Zrt.','2015','Thriller','496','3600',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789639998629','A pokolból','Vad Virágok Kiadó Kft.','2019','Képregény','574','7590',strftime('%s', 'now'));
INSERT INTO konyv (isbn, cim, kiado, kiadasi_ev, kategoria, oldalak_szama, ar, felvetel_datuma) 
VALUES ('9789632274690','Bálványok alkonya','Helikon Kiadó Kft.','2019','Filozófia','128','999',strftime('%s', 'now'));

INSERT INTO szerzoje (isbn, szerzo) VALUES ('9786155514333','Andy Weir');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789630982771','Michael Crichton');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789630984751','Michael Crichton');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789631365801','Manfred Flügge');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789631422511','Bartis Attila');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789631425796','Bartis Attila');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789632274690','Friedrich Nietzsche');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789632276359','Anthony Burgess');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789632521213','Stephen W. Hawking');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789633552605','Richard J. Evans');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634067962','Joe Hill');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634192541','Jeff Vandermeer');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634194040','Jeff Vandermeer');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634194071','Jeff Vandermeer');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634194347','Dan Simmons');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634333678','Art Spiegelman');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634470878','George R. R. Martin');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634472384','Dan Simmons');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634700074','Adrian Tchaikovsky');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634700456','Adrian Tchaikovsky');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634790853','Stanislaw Lem');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634792987','Immanuel Kant');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789634793335','Marcus Aurelius');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789639183377','Friedrich Nietzsche');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789639998629','Alan Moore');
INSERT INTO szerzoje (isbn, szerzo) VALUES ('9789639998629','Eddie Campbell');

INSERT INTO rendeles (rendelesszam, megrendelo, telefonszam, email, szallitasi_cim, rendeles_datuma, allapot) 
VALUES ('4','Futár Zoltán','+36304514487','zolifutar@gmail.com','Győr, Szivárvány utca 33',strftime('%s', 'now'),'New');
INSERT INTO rendeles (rendelesszam, megrendelo, telefonszam, email, szallitasi_cim, rendeles_datuma, allapot) 
VALUES ('3','Hűvös Kornél','06704859748','huvos@citromal.com','Budapest, Sáros utca 13',strftime('%s', 'now'),'New');
INSERT INTO rendeles (rendelesszam, megrendelo, telefonszam, email, szallitasi_cim, rendeles_datuma, allapot) 
VALUES ('2','Pocsai Zsolt','06306075064','pocsaizsolt@freemail.hu','Szeged, Damjanich utca 22',strftime('%s', 'now'),'Processed');
INSERT INTO rendeles (rendelesszam, megrendelo, telefonszam, email, szallitasi_cim, rendeles_datuma, allapot) 
VALUES ('5','Peter Griffin','+36704571121','iamcrazy@gmail.com','Quaghao',strftime('%s', 'now'),'New');
INSERT INTO rendeles (rendelesszam, megrendelo, telefonszam, email, szallitasi_cim, rendeles_datuma, allapot) 
VALUES ('6','Peter Falk','+36309695532','colombo@gmail.com','California',strftime('%s', 'now'),'New');
INSERT INTO rendeles (rendelesszam, megrendelo, telefonszam, email, szallitasi_cim, rendeles_datuma, allapot) 
VALUES ('7','Simple Joe','+36304018845','simple@gmail.com','Budapest, Magyaros utca 3',strftime('%s', 'now'),'New');
INSERT INTO rendeles (rendelesszam, megrendelo, telefonszam, email, szallitasi_cim, rendeles_datuma, allapot) 
VALUES ('8','Dombi Ferenc','+36307084595','dombos@citromail.com','Pécs, Árkos körút 32',strftime('%s', 'now'),'New');
INSERT INTO rendeles (rendelesszam, megrendelo, telefonszam, email, szallitasi_cim, rendeles_datuma, allapot) 
VALUES ('9','Kardos Ágnes','+36305023069','gameofthrones@gmail.com','Szeged, Szivárvány utca 12',strftime('%s', 'now'),'New');

INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('2','9789631425796','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('3','9789633552605','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('2','9789631422511','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('3','9789634792987','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('4','9789634700074','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('5','9789634333678','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('5','9789631425796','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('6','9789634194040','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('6','9786155514333','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('7','9789630984751','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('7','9789634194040','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('7','9789634700456','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('8','9789634194347','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('8','9789634067962','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('8','9789634472384','1');
INSERT INTO rendeles_tetel (rendelesszam, isbn, mennyiseg) VALUES ('9','9789634470878','3');