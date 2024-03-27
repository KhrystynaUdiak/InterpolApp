INSERT INTO criminal_organization (kind_of_accomplices, name) VALUES ('EXECUTOR','Shadow Symphony');
INSERT INTO criminal_organization (kind_of_accomplices, name) VALUES ('ORGANIZER','Shadow Symphony');
INSERT INTO criminal_organization (kind_of_accomplices, name) VALUES ('ABETTOR','Shadow Symphony');
INSERT INTO criminal_organization (kind_of_accomplices, name) VALUES ('ACCESSORY','Shadow Symphony');

INSERT INTO description (distinctive_features, eye_color, hair_color, height) VALUES ('white spot on neck', 'black', 'black', 180);
INSERT INTO description (distinctive_features, eye_color, hair_color, height) VALUES ('-', 'black', 'grey', 175);
INSERT INTO description (distinctive_features, eye_color, hair_color, height) VALUES ('bold', 'blue', '-', 168);
INSERT INTO description (distinctive_features, eye_color, hair_color, height) VALUES ('-', 'grey', 'grey', 161);


INSERT INTO location(last_place_of_residence, place_of_birth) VALUES ('Poland', 'Poland');
INSERT INTO location(last_place_of_residence, place_of_birth) VALUES ('Armenia', 'Serbia');
INSERT INTO location(last_place_of_residence, place_of_birth) VALUES ('Bulgaria', 'Serbia');

INSERT INTO languages (language) VALUES ('Azerbaijani');
INSERT INTO languages (language) VALUES ('Albanian');
INSERT INTO languages (language) VALUES ('Armenian');
INSERT INTO languages (language) VALUES ('Arabic');
INSERT INTO languages (language) VALUES ('Bengali');
INSERT INTO languages (language) VALUES ('Belarusian');
INSERT INTO languages (language) VALUES ('Bulgarian');
INSERT INTO languages (language) VALUES ('Bosnian');
INSERT INTO languages (language) VALUES ('Cambodian');
INSERT INTO languages (language) VALUES ('Corsican');
INSERT INTO languages (language) VALUES ('Croatian');
INSERT INTO languages (language) VALUES ('Czech');
INSERT INTO languages (language) VALUES ('Chinese');
INSERT INTO languages (language) VALUES ('Danish');
INSERT INTO languages (language) VALUES ('Dutch');
INSERT INTO languages (language) VALUES ('English');
INSERT INTO languages (language) VALUES ('Estonian');
INSERT INTO languages (language) VALUES ('Finnish');
INSERT INTO languages (language) VALUES ('French');
INSERT INTO languages (language) VALUES ('German');
INSERT INTO languages (language) VALUES ('Georgian');
INSERT INTO languages (language) VALUES ('Greek');
INSERT INTO languages (language) VALUES ('Hawaiian');
INSERT INTO languages (language) VALUES ('Hindi');
INSERT INTO languages (language) VALUES ('Hebrew');
INSERT INTO languages (language) VALUES ('Hungarian');
INSERT INTO languages (language) VALUES ('Indonesian');
INSERT INTO languages (language) VALUES ('Irish');
INSERT INTO languages (language) VALUES ('Icelandic');
INSERT INTO languages (language) VALUES ('Italian');
INSERT INTO languages (language) VALUES ('Japanese');
INSERT INTO languages (language) VALUES ('Kazakh');
INSERT INTO languages (language) VALUES ('Korean');
INSERT INTO languages (language) VALUES ('Kurdish');
INSERT INTO languages (language) VALUES ('Kyrgyz');
INSERT INTO languages (language) VALUES ('Lao');
INSERT INTO languages (language) VALUES ('Latvian');
INSERT INTO languages (language) VALUES ('Lithuanian');
INSERT INTO languages (language) VALUES ('Macedonian');
INSERT INTO languages (language) VALUES ('Maori');
INSERT INTO languages (language) VALUES ('Mongolian');
INSERT INTO languages (language) VALUES ('Nepali');
INSERT INTO languages (language) VALUES ('Norwegian');
INSERT INTO languages (language) VALUES ('Persian');
INSERT INTO languages (language) VALUES ('Polish');
INSERT INTO languages (language) VALUES ('Portuguese');
INSERT INTO languages (language) VALUES ('Philippines');
INSERT INTO languages (language) VALUES ('russian');
INSERT INTO languages (language) VALUES ('Romanian');
INSERT INTO languages (language) VALUES ('Samoan');
INSERT INTO languages (language) VALUES ('Scottish');
INSERT INTO languages (language) VALUES ('Serbian');
INSERT INTO languages (language) VALUES ('Slovak');
INSERT INTO languages (language) VALUES ('Slovenian');
INSERT INTO languages (language) VALUES ('Somali');
INSERT INTO languages (language) VALUES ('Spanish');
INSERT INTO languages (language) VALUES ('Swedish');
INSERT INTO languages (language) VALUES ('Tajik');
INSERT INTO languages (language) VALUES ('Tatarian');
INSERT INTO languages (language) VALUES ('Thai');
INSERT INTO languages (language) VALUES ('Turkish');
INSERT INTO languages (language) VALUES ('Turcoman');
INSERT INTO languages (language) VALUES ('Ukrainian');
INSERT INTO languages (language) VALUES ('Uzbek');
INSERT INTO languages (language) VALUES ('Vietnamese');
INSERT INTO languages (language) VALUES ('Welsh');

INSERT INTO offenders (age, archived, criminal_organization_id, description_id, location_id, alias, birthdate, citizenship, criminal_case, first_name, last_name)
VALUES (33, false, 1, 1, 1, 'hid', '1991-02-03', 'POLAND', 'art. 185 of Criminal Code (theft)', 'Mike', 'Hidden');
INSERT INTO offenders (age, archived, criminal_organization_id, description_id, location_id, alias, birthdate, citizenship, criminal_case, first_name, last_name)
VALUES (32, false, 2, 2, 1, 'eduardo', '1991-06-28', 'ARGENTINA', 'art. 185 of Criminal Code (theft)', 'Hector', 'Castillo');
INSERT INTO offenders (age, archived, criminal_organization_id, description_id, location_id, alias, birthdate, citizenship, criminal_case, first_name, last_name)
VALUES (30, false, 3, 3, 2, '-', '1994-02-02', 'SERBIA', 'art. 185 of Criminal Code (theft)', 'Rumil', 'Akhsanov');
INSERT INTO offenders (age, archived, criminal_organization_id, description_id, location_id, alias, birthdate, citizenship, criminal_case, first_name, last_name)
VALUES (45, false, 4, 4, 3, '-', '1979-01-18', 'BULGARIA', 'art. 185 of Criminal Code (theft)', 'Veneta', 'Dimitrova');