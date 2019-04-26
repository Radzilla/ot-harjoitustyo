# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenteessa on vain pakkaukset fi.sillaras.funktionality ja fi.sillaras.components.


Paukkauksessa fi.sillaras.funktionality on sovelluksen käyttäliittymän ja sovelluslogikkan toteuttava luokka Pong, sekä luokka Scenenes jonka tarkoitus olisi onnistuessaan siirtää näkymien luominen omiksi metodeikseen.

Paukkauksessa fi.sillaras.components sisältää luokat Paddle ja Ball, jotka huolehtivat pelivälineiden luonnista ja tuonnista peliruutuun.

<img src="https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Pong_Luokkakaavio.png">

## Käyttöliittymä

Pelissä on neljä näkymää 

Ohjenäkymä
Peliruutu
Päivityksen valinta
Pelin häviäminen ja uuden aloitus

Nämä on toteutettu Scene olioina ja yksi kerrallaan näkyvä Scene siirretään sovelluksen stageen. 

Ohjenäkymän, päivityksen valinta ja uuden pelin aloittaminen on toteutettu painikkeiden avulla.
Pelattavaa peliruutua käytetään nuolinäppäinten avulla.

## Sovelluslogiikka

Sovelluslogiikka pystyy luomaan ja muuttamaan pallon ja pelaajien mailojen tietoja, sekä myös luomaan niiden perusteella peliruutuun tarvittavat komponentit. 

<img src="https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Pelinakyma_Sekvenssi.PNG">

Sovelluslogiikassa on myös AnimationTimerin sisällä handle metodi, joka seuraa nuolinäppäinten painallusta ja pallon sijaintia vastustajan "tekoälyn" mailaan. Handle liikuttaa komponentteja peliruudussa näiden perusteella. 


## Ongelmat koodissa

Käyttöliittymää ja sovelluslogiikaa ei olla saatu eroteltua toistaan ja näkyminen ohjaaminen Scenes olion kautta osoittautui hankalaksi. 
Säilytetään kuitenkin Scenes olio jatkokehittelyä ajatellen.
