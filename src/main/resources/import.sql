INSERT INTO VisitReason(id, domainId) VALUES (1,'first visit');
INSERT INTO VisitReason(id, domainId) VALUES (2,'recurring visit');
INSERT INTO VisitReason(id, domainId) VALUES (3,'urgent');

INSERT INTO Patient(id, name, surname, dateOfBirth, socialSecurityNumber, imageurl) VALUES (nextval('hibernate_sequence'),'Franke','Maximilian',PARSEDATETIME('27.10.1986','dd.MM.yyyy','de'),'1234684567', 'https://avataaars.io/?avatarStyle=Circle&topType=ShortHairShortCurly&accessoriesType=Sunglasses&hairColor=BlondeGolden&facialHairType=BeardMajestic&facialHairColor=Blonde&clotheType=BlazerShirt&eyeType=Surprised&eyebrowType=UpDownNatural&mouthType=Serious&skinColor=Light');
INSERT INTO Patient(id, name, surname, dateOfBirth, socialSecurityNumber, imageurl) VALUES (nextval('hibernate_sequence'),'Franke','Fredo',PARSEDATETIME('27.10.1982','dd.MM.yyyy','de'),'12346845673', 'https://avataaars.io/?avatarStyle=Circle&topType=LongHairFrida&accessoriesType=Kurt&hairColor=Red&facialHairType=BeardLight&facialHairColor=BrownDark&clotheType=GraphicShirt&clotheColor=Gray01&graphicType=Skull&eyeType=Wink&eyebrowType=RaisedExcitedNatural&mouthType=Disbelief&skinColor=Brown');
INSERT INTO Patient(id, name, surname, dateOfBirth, socialSecurityNumber, imageurl) VALUES (nextval('hibernate_sequence'),'Franke','Sabine',PARSEDATETIME('27.10.1966','dd.MM.yyyy','de'),'12346845XX', 'https://avataaars.io/?avatarStyle=Circle');
INSERT INTO Patient(id, name, surname, dateOfBirth, socialSecurityNumber, imageurl) VALUES (nextval('hibernate_sequence'),'Franke','Katharina',PARSEDATETIME('27.10.1970','dd.MM.yyyy','de'),'12346845673YY', 'https://avataaars.io/?avatarStyle=Circle&topType=LongHairMiaWallace&accessoriesType=Sunglasses&hairColor=BlondeGolden&facialHairType=Blank&clotheType=BlazerSweater&eyeType=Surprised&eyebrowType=RaisedExcited&mouthType=Smile&skinColor=Pale');

INSERT INTO Visit(id, patient_id, date, reason_id, type) VALUES (nextval('hibernate_sequence'), 1, PARSEDATETIME('19.02.2022','dd.MM.yyyy','de'), 1, 'DOMICILIARY');
INSERT INTO Visit(id, patient_id, date, reason_id, type) VALUES (nextval('hibernate_sequence'), 1, PARSEDATETIME('18.02.2022','dd.MM.yyyy','de'), 2, 'OUTPATIENT');

