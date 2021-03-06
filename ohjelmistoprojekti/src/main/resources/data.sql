INSERT INTO survey (survey_name)
VALUES
('Les Pasila'),
('Kari Grandit');

INSERT INTO question_type (question_type)
VALUES
('radio'),
('text');

INSERT INTO question (question_type_id, question, survey_id)
VALUES
(1, 'Sukupuoli?', 1),
(1, 'Ikä?', 1),
(1, 'Millä kampuksella opiskelet?', 1),
(1, 'Monennen vuoden opiskelija olet?', 1),
(2, 'Miten arvioisit opiskelijajärjestöjen ja opiskelijoiden välisen vuorovaikutuksen? (face-to-face, sposti, puhelinnumerot)', 1),
(1, 'Koetko oppilaiden ja ainejärjestöjen välisen kommunikoinnin olevan riittävää (tarpeelliseksi)?', 1),
(2, 'Mitä kautta yleensä otat yhteyttä Helgaan tai opiskelijajärjestöihin?', 1),
(1, 'Millä tavalla haluaisit ottaa ainejärjestöihin mieluiten yhteyttä?', 1),
(1, 'Käyttäisitkö mahdollista chatbox-sovellusta ainejärjestöiden tavoittamiseksi, jos sellainen olisi olemassa?', 1),
(1, 'Pitäisikö chatbox-sovelluksen käyttö olla mahdollista anonyymisti?', 1),
(1, 'Onko mielestäsi ainejärjestöihin hankalaa ottaa yhteyttä?', 1),
(2, 'Miten yhteydenottamista voitaisiin helpottaa?', 1);

INSERT INTO question (question_type_id, question, survey_id)
VALUES
(2, 'Monettako vuotta opiskelet haaga-heliassa?', 2),
(1, 'Ostatko koulussa virvokkeita?', 2),
(1, 'Miksi valitset limukoneet?', 2),
(1, 'Onko koneita riittävästi ja onko ne sijoitettu hyvin?', 2),
(1, 'Käyttäisitkö juoma-automaatteja jos niistä saisi muutakin kuin limsaa ja energiajuomia?', 2),
(1, 'Miksi käytät kahviota?', 2),
(1, 'Toivoisitko laajempaa valikoimaa kahvioon?', 2),
(2, 'Mitä haluaisit lisätä kahvilan valikoimaan?', 2),
(1, 'Onko kahviossa asioiminen nopeaa?', 2);

-- Les Pasila

INSERT INTO answer_option (question_id, answer_option)
VALUES
(1, 'Mies'),
(1, 'Nainen'),
(1, 'Muu'),
(2, '17-20'),
(2, '21-25'),
(2, '26-30'),
(2, '30+'),
(3, 'Pasila'),
(3, 'Porvoo'),
(3, 'Malmi'),
(3, 'Haaga'),
(3, 'Vierumäki'),
(4, 'Ensimmäisen'),
(4, 'Toisen'),
(4, 'Kolmannen'),
(4, 'Neljännen'),
(4, 'Muu'),
(6, 'Kyllä'),
(6, 'Ei'),
(8, 'Kasvokkain'),
(8, 'Puhelimitse (puhelut, viestit)'),
(8, 'Sähköposti'),
(8, 'Somessa'),
(9, 'Kyllä'),
(9, 'Ei'),
(10, 'Kyllä'),
(10, 'Ei');

-- Kari Grandit

INSERT INTO answer_option (question_id, answer_option)
VALUES
(13, 'Limukoneista?'),
(13, 'Kahviosta?'),
(13, 'Käytän molempia'),
(13, 'En osta'),
(14, 'Saan kaiken tarvitsemani koneesta'),
(14, 'Ei tarvitse mennä kahvioon asti'),
(15, 'Koneita on riittävästsi ja ne on sijoitettu hyvin'),
(15, 'Ei, koneita voisi olla enemmän ja niiden sijoittamista voisi suunnitella uudelleen'),
(15, 'Koneita on riittävästi, mutta ne voisi sijoittaa hyödyllisemmin'),
(15, 'Koneita ei ole riittävästi, mutta tämän hetkiset sijainnit ocat käytännölliset'),
(16, 'Kyllä'),
(16, 'En'),
(17, 'Parempi valikoima'),
(17, 'Saan asiakaspalvelua'),
(18, 'Kyllä'),
(18, 'En'),
(20, 'Kyllä'),
(20, 'Ei');
