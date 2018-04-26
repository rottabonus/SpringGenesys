INSERT INTO survey (survey)
VALUES
('Les Pasila'),
('Kari Grandit');

INSERT INTO question_type (question_type)
VALUES
('radio'),
('text');

INSERT INTO question (question_type_id, question, survey_id)
VALUES
(2, 'Sukupuoli?', 1),
(1, 'Ikä?', 1),
(1, 'Millä kampuksella opiskelet?', 1),
(1, 'Monennen vuoden opiskelija olet?', 1),
(2, 'Miten arvioisit opiskelijajärjestöjen ja opiskelijoiden välisen vuorovaikutuksen? (face-to-face, sposti, puhelinnumerot)', 1),
(1, 'Koetko oppilaiden ja ainejärjestöjen välisen kommunikoinnin olevan riittävää (tarpeelliseksi)?', 1),
(2, 'Mitä kautta yleensä otat yhteyttä Helgaan tai opiskelijajärjestöihin?', 1),
(1,'Millä tavalla haluaisit ottaa ainejärjestöihin mieluiten yhteyttä?', 1),
(1, 'Käyttäisitkö mahdollista chatbox-sovellusta ainejärjestöiden tavoittamiseksi, jos sellainen olisi olemassa?', 1),
(2, 'Pitäisikö chatbox-sovelluksen käyttö olla mahdollista anonyymisti?', 1),
(2, 'Onko mielestäsi ainejärjestöihin hankalaa ottaa yhteyttä/mitä voisi parantaa?', 1);

INSERT INTO question (question_type_id, question, survey_id)
VALUES
(2, 'Monettako vuotta opiskelet haaga-heliassa?', 2),
(1, 'Ostatko koulussa virvokkeita?', 2),
(1, 'Miksi valitset limukoneet?', 2),
(1, 'Onko koneita riittävästi ja onko ne sijoitettu hyvin?', 2),
(1, 'Käyttäisitkö juoma-automaatteja jos niistä saisi muutakin kuin limsaa ja energiajuomia?', 2),
(1, 'Miksi käytät kahviota?', 2),
(1, 'Toivoisitko laajempaa valikoimaa kahvioon?', 2),
(1, 'Onko kahviossa asioiminen nopeaa?', 2);

