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
## Yksittäisen vastauksen postaaminen

[http://167.99.253.212:8080/ohjelmistoprojekti/answers/1](http://167.99.253.212:8080/ohjelmistoprojekti/answers/1)

Method: POST 
```
Headers: Key: "Content-Type", Value: "application-json"
```

```
Body: {
  "answer": "koira"
}
```

Url:n viimeinen numero vastaa `question_id`:tä, johon answer halutaan liittää.

API response: 

```
{
  "answer": "koira"
}
```

## Vastauksien postaaminen listana Teamin mukaan

[http://167.99.253.212:8080/ohjelmistoprojekti/answers/team/2](http://167.99.253.212:8080/ohjelmistoprojekti/answers/team/2)

Method: POST 
```
Headers: Key: "Content-Type", Value: "application-json"
```


```
Body: [
{ "id": 0, "answer": "2 vuotta"}, 
{ "id": 0, "answer": "En"},
{ "id": 0, "answer": "COla"},
{ "id": 0, "answer": "Ei"}, 
{ "id": 0, "answer": "Kyllä"},
{ "id": 0, "answer": "Kahvin takia"},
{ "id": 0, "answer": "Kyllä"},
{ "id": 0, "answer": "Kahvin takia"},
{ "id": 0, "answer": "2 vuotta"}, 
{ "id": 0, "answer": "En"},
{ "id": 0, "answer": "COla"}
]
```

Url:n viimeinen numero vastaa `team_id`:tä, johon lista vastauksista halutaan liittää.
Vastaukset saavat`question_id`:n aina järjestyksessä. Esim. Ensimmäinen vastaus saa ensimmäisen `team_id`:n `question_id`:n. 
API response: 

```
Body: [
{ "id": 1, "answer": "2 vuotta"}, 
{ "id": 2, "answer": "En"},
{ "id": 3, "answer": "COla"},
{ "id": 4, "answer": "Ei"}, 
{ "id": 5, "answer": "Kyllä"},
{ "id": 6, "answer": "Kahvin takia"},
{ "id": 7, "answer": "Kyllä"},
{ "id": 8, "answer": "Kahvin takia"},
{ "id": 9, "answer": "2 vuotta"}, 
{ "id": 10, "answer": "En"},
{ "id": 11, "answer": "COla"}
]
```

Vastauksen attribuutin "id" arvo ei vaikuta mihinkään. Sen voi siis jättää tyhjäksi!

=> 

```
Body: [
{ "answer": "2 vuotta"}, 
{ "answer": "En"},
{ "answer": "COla"},
{ "answer": "Ei"}, 
{ "answer": "Kyllä"},
{ "answer": "Kahvin takia"},
{ "answer": "Kyllä"},
{ "answer": "Kahvin takia"},
{ "answer": "2 vuotta"}, 
{ "answer": "En"},
{ "answer": "COla"}
]
```

API response: 

```
Body: [
{ "id": 1, "answer": "2 vuotta"}, 
{ "id": 2, "answer": "En"},
{ "id": 3, "answer": "COla"},
{ "id": 4, "answer": "Ei"}, 
{ "id": 5, "answer": "Kyllä"},
{ "id": 6, "answer": "Kahvin takia"},
{ "id": 7, "answer": "Kyllä"},
{ "id": 8, "answer": "Kahvin takia"},
{ "id": 9, "answer": "2 vuotta"}, 
{ "id": 10, "answer": "En"},
{ "id": 11, "answer": "COla"}
]
```
