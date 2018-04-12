INSERT INTO team (team_name)
VALUES
('Les Pasila'),
('Kari Grandit');

INSERT INTO question (question, question_type, team_id)
VALUES
("Sukupuoli?", "avoin", 1),
("Ikä?", "monivalinta", 1),
("Millä kampuksella opiskelet?", "monivalinta", 1),
("Monennen vuoden opiskelija olet?", "monivalinta", 1),
("Miten arvioisit opiskelijajärjestöjen ja opiskelijoiden välisen vuorovaikutuksen? (face-to-face, sposti, puhelinnumerot)", "avoin", 1),
("Koetko oppilaiden ja ainejärjestöjen välisen kommunikoinnin olevan riittävää (tarpeelliseksi)?", "monivalinta", 1),
("Mitä kautta yleensä otat yhteyttä Helgaan tai opiskelijajärjestöihin?", "avoin", 1),
("Millä tavalla haluaisit ottaa ainejärjestöihin mieluiten yhteyttä?", "monivalinta", 1),
("Käyttäisitkö mahdollista chatbox-sovellusta ainejärjestöiden tavoittamiseksi, jos sellainen olisi olemassa?", "monivalinta", 1),
("Pitäisikö chatbox-sovelluksen käyttö olla mahdollista anonyymisti?", "avoin", 1),
("Onko mielestäsi ainejärjestöihin hankalaa ottaa yhteyttä/mitä voisi parantaa?", "avoin", 1);

INSERT INTO question (question, question_type, team_id)
VALUES
("Monettako vuotta opiskelet haaga-heliassa?", "avoin", 2),
("Ostatko koulussa virvokkeita?", "monivalinta",2),
("Miksi valitset limukoneet?", "monivalinta", 2),
("Onko koneita riittävästi ja onko ne sijoitettu hyvin?", "monivalinta", 2),
("Käyttäisitkö juoma-automaatteja jos niistä saisi muutakin kuin limsaa ja energiajuomia?", "monivalinta", 2),
("Miksi käytät kahviota?", "monivalinta", 2),
("Toivoisitko laajempaa valikoimaa kahvioon?", "monivalinta", 2),
("Onko kahviossa asioiminen nopeaa?", "monivalinta", 2);
