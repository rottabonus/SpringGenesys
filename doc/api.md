# Ohjelmistoprojekti API Dokumentaatio

## Kaikki Kysymykset

[http://167.99.253.212:8080/ohpro/questions/](http://167.99.253.212:8080/ohpro/questions/)

Method: GET

API Response:

```
[
{
question_id: 1,
question_type: {
question_type_id: 1,
question_type: "radio"
},
question: "Sukupuoli?",
survey: {
survey_id: 1,
survey: "Les Pasila"
},
option_list: [
{
answer_option_id: 1,
answer_option: "Mies"
},
{
answer_option_id: 2,
answer_option: "Nainen"
},
{
answer_option_id: 3,
answer_option: "Muu"
}
]
},
{
question_id: 2,
question_type: {
question_type_id: 1,
question_type: "radio"
},
question: "Ikä?",
survey: {
survey_id: 1,
survey: "Les Pasila"
},
option_list: [
{
answer_option_id: 4,
answer_option: "17-20"
},
{
answer_option_id: 5,
answer_option: "21-25"
},
{
answer_option_id: 6,
answer_option: "26-30"
},
{
answer_option_id: 7,
answer_option: "30+"
}
]
},
.
.
.
```

## Yksi Kysymys

[http://167.99.253.212:8080/ohpro/questions/1](http://167.99.253.212:8080/ohpro/questions/1)

Method: GET

URL:n viimeinen numero vastaa `question_id`:tä.

API Response:

```
{
question_id: 1,
question_type: {
question_type_id: 1,
question_type: "radio"
},
question: "Sukupuoli?",
survey: {
survey_id: 1,
survey: "Les Pasila"
},
option_list: [
{
answer_option_id: 1,
answer_option: "Mies"
},
{
answer_option_id: 2,
answer_option: "Nainen"
},
{
answer_option_id: 3,
answer_option: "Muu"
}
]
}
```

## Tiimikohtaiset Kysymykset

[http://167.99.253.212:8080/ohpro/questions/survey/2](http://167.99.253.212:8080/ohpro/questions/survey/2)

Method: GET

URL:n viimeinen numero vastaa `survey_id`:tä.
`survey_id: 1` on Les Pasila ja `survey_id: 2` on Kari Grandit.

API Respone:

```
[
{
question_id: 14,
question_type: {
question_type_id: 1,
question_type: "radio"
},
question: "Ostatko koulussa virvokkeita?",
survey: {
survey_id: 2,
survey: "Kari Grandit"
},
option_list: [
{
answer_option_id: 32,
answer_option: "Saan kaiken tarvitsemani koneesta"
},
{
answer_option_id: 33,
answer_option: "Ei tarvitse mennä kahvioon asti"
}
]
},
{
question_id: 15,
question_type: {
question_type_id: 1,
question_type: "radio"
},
question: "Miksi valitset limukoneet?",
survey: {
survey_id: 2,
survey: "Kari Grandit"
},
option_list: [
{
answer_option_id: 34,
answer_option: "Koneita on riittävästsi ja ne on sijoitettu hyvin"
},
{
answer_option_id: 35,
answer_option: "Ei, koneita voisi olla enemmän ja niiden sijoittamista voisi suunnitella uudelleen"
},
{
answer_option_id: 36,
answer_option: "Koneita on riittävästi, mutta ne voisi sijoittaa hyödyllisemmin"
},
{
answer_option_id: 37,
answer_option: "Koneita ei ole riittävästi, mutta tämän hetkiset sijainnit ocat käytännölliset"
}
]
},
.
.
.
```
## Yksittäisen vastauksen postaaminen

[http://167.99.253.212:8080/ohpro/answers/question/1](http://167.99.253.212:8080/ohpro/answers/1)

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
jossa vastaus on `answer_option_id`, joka saadaan tietää questionin perusteella. Vastaus generoi itselleen `choice_answer_id`:n automaattisesti.

```
Body: {
  "answer_option": {"answer_option_id": "3"}
}
```

API response: 

```
posted choiceAnswer: 23
```

## Vastaukset kyselykohtaisesti

[http://167.99.253.212:8080/ohpro/answers/survey/1](http://167.99.253.212:8080/ohpro/answers/survey/1)

Tekstivastauksissa tulee mukana kysymysten tarkat tiedot, radiovastauksissa vain `choice_answer_id` , `answer_option` sekä `answer_option_id` 

Method: GET

API response: 

```
[
{
"question":{"question_id":5,"question_type":{
"question_type_id":2,
"question_type":"text"
},
"question":"Miten arvioisit opiskelijajärjestöjen ja opiskelijoiden välisen vuorovaikutuksen? (face-to-face, sposti, puhelinnumerot)",
"survey":{"survey_id":1,"survey":"Les Pasila"
},
"option_list":[]
},
"answer":"En osaa sanoa","answer_id":1
},
{
"question":{"question_id":7,"question_type":{
"question_type_id":2,"question_type":"text"
},
"question":"Mitä kautta yleensä otat yhteyttä Helgaan tai opiskelijajärjestöihin?",
"survey":{"survey_id":1,"survey":"Les Pasila"
},
"option_list":[]
},
"answer":"Sähköpostilla","answer_id":2
},
{
"choice_answer_id":2,
"answer_option":{ "answer_option_id":1,
"answer_option":"Mies"
}
},
{
"choice_answer_id":3,
"answer_option":{"answer_option_id":1,
"answer_option":"Mies"
}
},
{
"choice_answer_id":1,
"answer_option":{ "answer_option_id":2,
"answer_option":"Nainen"
}
}
]

```


