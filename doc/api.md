# Ohjelmistoprojekti API Dokumentaatio

## Kaikki Kysymykset

[http://167.99.253.212:8080/ohjelmistoprojekti/questions/](http://167.99.253.212:8080/ohjelmistoprojekti/questions/)

Method: GET

API Response:

```
[
  {
    "question_id": 1,
	"question": "Sukupuoli?",
	"question_type": "avoin",
	"team_id": {
	  "team_id": 1,
	  "team_name": "Les Pasila"
	  }
  },
  {
	"question_id": 2,
	"question": "Ikä?",
	"question_type": "monivalinta",
	"team_id": {
	  "team_id": 1,
	  "team_name": "Les Pasila"
	  }
  },
.
.
.
```

## Yksi Kysymys

[http://167.99.253.212:8080/ohjelmistoprojekti/questions/1](http://167.99.253.212:8080/ohjelmistoprojekti/questions/1)

Method: GET

URL:n viimeinen numero vastaa `question_id`:tä.

API Response:

```
{
  "question_id": 1,
  "question": "Sukupuoli?",
  "question_type": "avoin",
  "team_id": {
    "team_id": 1,
    "team_name": "Les Pasila"
  }
}
```

## Tiimikohtaiset Kysymykset

[http://167.99.253.212:8080/ohjelmistoprojekti/questions/team/1](http://167.99.253.212:8080/ohjelmistoprojekti/questions/team/1)

Method: GET

URL:n viimeinen numero vastaa `team_id`:tä.
`team_id: 1` on Les Pasila ja `team_id: 2` on Kari Grandit.

API Respone:

```
[
  {
    "question_id": 1,
    "question": "Sukupuoli?",
    "question_type": "avoin",
    "team_id": {
      "team_id": 1,
      "team_name": "Les Pasila"
    }
  },
  {
    "question_id": 2,
    "question": "Ikä?",
    "question_type": "monivalinta",
    "team_id": {
      "team_id": 1,
      "team_name": "Les Pasila"
    }
  },
.
.
.
```

