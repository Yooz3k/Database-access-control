INSERT INTO Magazyny (Wielkosc)
VALUES (12000), (8500), (6800), (5500), (10000);
GO

INSERT INTO Magazynierzy (PESEL, Narodowosc, ImieNazwisko, DataZatrudnienia)
VALUES
(87060434347, 'Polska', 'Krzysztof Kwiatkowski', '2013-07-22'),
(77112142849, 'Polska', 'Tomasz Woźniak', '2013-10-13'),
(74012273365, 'Polska', 'Adam Riedel', '2013-11-30'),
(NULL, 'Ukraina', 'Artem Woloznyak', '2014-02-06'),
(92072376333, 'Polska', 'Piotr Tryk', '2014-04-28'),
(90051388022, 'Polska', 'Eryk Kwurend', '2014-08-02'),
(NULL, 'Rosja', 'Wladimir Putout', '2015-01-11'),
(93111684003, 'Polska', 'Kazimierz Truk', '2015-03-14'),
(66033067015, 'Polska', 'Karol Piotrowicz', '2015-07-01');
GO

INSERT INTO Dostawcy (Nazwa, Miasto, Telefon, DataRozpoczeciaWspolpracy)
VALUES
('JanuszPol', 'Kraków', 667445012, '2014-09-18'),
('JanuszEx', 'Płock', 789536213, '2014-11-12'),
('Polnos', 'Szczecin', 548882990, '2015-01-02'),
('CarTruckPart', 'Ostrołęka', 550998110, '2015-03-04'),
('Raben', 'Poznań', 773822992, '2015-06-17'),
('Intertreck', 'Chorzów', 555225432, '2015-08-22'),
('Protruck', 'Legnica', 723001992, '2016-02-13'),
('AltTrans', 'Elbląg', 554402238, '2017-01-13');
GO

INSERT INTO Dostawy (NumerPrzewozowy, DataOdbioru, GodzinaOdbioru, ID_Dostawcy, ID_Magazyniera, ID_Magazynu)
VALUES
('6648278787854', '2018-03-23', '11:34:00', 3, 5, 5),
('002733AER', '2018-03-23', '15:22:00', 4, 2, 2),
('RB232888500038', '2018-03-23', '18:10:00', 5, 7, 2),
('88995772011', '2018-03-24', '09:18:00', 8, 1, 1),
('772579720975', '2018-03-24', '11:55:00', 3, 5, 5),
('2313984767', '2018-03-24', '16:17:00', 7, 6, 1),
('436576847', '2018-03-27', '10:40:00', 2, 4, 4),
('TT83479804B', '2018-03-27', '12:25:00', 7, 6, 1),
('991001192', '2018-03-27', '16:27:00', 1, 8, 3),
('43342615152', '2018-03-27', '17:55:00', 6, 3, 3);
GO

INSERT INTO Producenci (Nazwa, Kraj)
VALUES
('Aion', 'Japonia'),
('AEZ', 'Niemcy'),
('Alpine', 'Francja'),
('Autotech', 'Polska'),
('Brembo', 'Niemcy'),
('Barum', 'Polska'),
('Bosch', 'Niemcy'),
('Bridgestone', 'Japonia'),
('Dezent', 'Austria'),
('Dees', 'Francja'),
('F1rst', 'Anglia'),
('Geord', 'Holandia'),
('Jeer', 'Hiszpania'),
('Kaeno', 'Japonia'),
('Leosteer', 'Irlandia'),
('Pronex', 'Czechy'),
('Reet', 'USA'),
('Saeno', 'USA'),
('Toeno', 'Hiszpania');
GO

INSERT INTO Czesci (NumerKatalogowy, Nazwa, StanMagazynowy, CenaDetaliczna, Kategoria, ID_Magazynu, ID_Producenta)
VALUES
('6444', 'Tarcze wentylowane 18c', 11, 440.00, 'Układ hamulcowy', 4, 5),
('257191', 'Reflektor przedni Audi A4 B6', 2, 228.00, 'Nadwozie', 1, 13),
('17771', 'Reflektor tylny BMW E36', 2, 205.00, 'Nadwozie', 1, 13),
('001181', 'Stabilizator przedni Toyota', 4, 117.00, 'Zawieszenie', 2, 9),
('ST9292', 'Piasta przednia Chevrolet Aveo', 3, 235.00, 'Układ napędowy', 5, 15),
('73899', 'Tłumik środkowy Peugeot', 4, 330.00, 'Układ wydechowy', 5, 4),
('001EE33', 'Filtr oleju Toyota', 15, 34.00, 'Filtry i eksploatacja', 3, 7),
('99211', 'Olej silnikowy W5-30 4l', 9, 146.00, 'Filtry i eksploatacja', 3, 11),
('245672', 'Olej silnikowy W5-35 4l', 11, 142.00, 'Filtry i eksploatacja', 3, 11),
('8222299', 'Zderzak przedni Toyota Corolla E11', 1, 301.00, 'Nadwozie', 1, 10),
('267800', 'Kolektor wydechowy VVT-i', 3, 560.00, 'Silnik', 5, 4),
('11567', 'Pompowtryskiwacz piezoelektryczny D-4D', 3, 880.00, 'Silnik', 5, 17),
('345671', 'Zacisk hamulcowy 16c', 16, 98.00, 'Układ hamulcowy', 4, 1);
GO