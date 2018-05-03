# Ohjelmistoprojekti API Dokumentaatio

## Kaikki Kysymykset

[http://167.99.253.212:8080/ohjelmistoprojekti/questions/](http://167.99.253.212:8080/ohjelmistoprojekti/questions/)

Method: GET

API Response:

```
[
    {
        "question_id": 1,
        "question_type": {
            "question_type_id": 2,
            "question_type": "text"
        },
        "question": "Sukupuoli?",
        "survey": {
            "survey_id": 1,
            "survey": "Les Pasila"
        },
        "option_list": [
            {
                "answer_option_id": 1,
                "answer_option": "banaani"
            }
        ]
    },
    {
        "question_id": 2,
        "question_type": {
            "question_type_id": 1,
            "question_type": "radio"
        },
        "question": "Ikä?",
        "survey": {
            "survey_id": 1,
            "survey": "Les Pasila"
        },
        "option_list": []
    },
.
.
.
```

## Yksi Kysymys

[http://167.99.253.212:8080/ohjelmistoprojekti/questions/1](http://167.99.253.212:8080/ohjelmistoprojekti/questions/5)

Method: GET

URL:n viimeinen numero vastaa `question_id`:tä.

API Response:

```
{
    "question_id": 5,
    "question_type": {
        "question_type_id": 1,
        "question_type": "radio"
    },
    "question": "Miten arvioisit opiskelijajärjestöjen ja opiskelijoiden välisen vuorovaikutuksen? (face-to-face, sposti, puhelinnumerot)",
    "survey": {
        "survey_id": 1,
        "survey": "Les Pasila"
    },
    "option_list": [
        {
            "answer_option_id": 2,
            "answer_option": "Face-to-Face"
        },
        {
            "answer_option_id": 3,
            "answer_option": "Sposti"
        },
        {
            "answer_option_id": 4,
            "answer_option": "Puhelin"
        }
    ]
}
```

## Tiimikohtaiset Kysymykset

[http://167.99.253.212:8080/ohjelmistoprojekti/questions/survey/1](http://167.99.253.212:8080/ohjelmistoprojekti/questions/team/1)

Method: GET

URL:n viimeinen numero vastaa `survey_id`:tä.
`survey_id: 1` on Les Pasila ja `survey_id: 2` on Kari Grandit.

API Respone:

```
[
    {
        "question_id": 2,
        "question_type": {
            "question_type_id": 1,
            "question_type": "radio"
        },
        "question": "Ikä?",
        "survey": {
            "survey_id": 1,
            "survey": "Les Pasila"
        },
        "option_list": []
    },
    {
        "question_id": 3,
        "question_type": {
            "question_type_id": 1,
            "question_type": "radio"
        },
        "question": "Millä kampuksella opiskelet?",
        "survey": {
            "survey_id": 1,
            "survey": "Les Pasila"
        },
        "option_list": []
    },
.
.
.
```
## Yksittäisen vastauksen postaaminen

[http://167.99.253.212:8080/ohjelmistoprojekti/answers/question/1](http://167.99.253.212:8080/ohjelmistoprojekti/answers/1)

Url:n viimeinen numero vastaa `question_id`:tä, johon answer halutaan liittää.

HUOM! RequestBody täytyy olla oikeassa muodossa!

1. Jos kysymyksessä on tekstivastaus

Method: POST 
```
Headers: Key: "Content-Type", Value: "application-json"
```


```
Body: {
  "text_answer": {"answer": "2 vuotta"}
}
```
API response: 

```
posted textAnswer: 2 vuotta
```



2. Jos kysymyksessä on radiovastaus

```
Body: {
  "answer_option": {"answer_option_id": "3"}
}
```

API response: 

```
posted choiceAnswer: 23
```



## Vastaukset

[http://167.99.253.212:8080/ohjelmistoprojekti/answers/](http://167.99.253.212:8080/ohjelmistoprojekti/answers/)

Method: GET 

API response:

API Response:

```
[
  {
    "answer_id": 1,
    "answer": "2 vuotta",
    }
  },
  {
    "answer_id": 2,
    "answer": "En"
    }
  },
.
.
.
```
