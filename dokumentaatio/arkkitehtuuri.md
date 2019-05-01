# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenteessa on vain pakkaukset fi.sillaras.funktionality ja fi.sillaras.components.


Paukkauksessa fi.sillaras.funktionality on sovelluksen käyttäliittymän ja sovelluslogikkan toteuttava luokka Pong, sekä luokka Scenenes jonka tarkoitus olisi onnistuessaan siirtää näkymien luominen omiksi metodeikseen.

Paukkauksessa fi.sillaras.components sisältää luokat Paddle ja Ball, jotka huolehtivat pelivälineiden luonnista ja tuonnista peliruutuun.

<img src="https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Pong_Luokkakaavio.png">
Kuvassa Pong luoka on Screen osoittamassa erilaisten ruutujen/näkymien hallintaa.

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

Luokka Pong vastaa käyttöliittymän erilaisten näkymien luonnista ja näyttämisestä käyttäjälle. 

Pong pystyy myös luomaan ja muuttamaan pallon ja pelaajien mailojen tietoja, sekä myös luomaan niiden perusteella peliruutuun tarvittavat komponentit muotoina. 

<img src="https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Pelinakyma_Sekvenssi.PNG">

Pong luokassa on myös AnimationTimerin sisällä handle metodi, joka seuraa nuolinäppäinten painallusta ja pallon sijaintia vastustajan "tekoälyn" mailaan. Handle liikuttaa komponentteja peliruudussa näiden perusteella kymmeniä kertoja sekunnissa. 



## Ongelmat koodissa

Käyttöliittymää ja sovelluslogiikaa ei olla saatu eroteltua toistaan, sillä näkyminen ohjaaminen ja animation timerin käyttö tätä varten luodun Scenes luokan kautta osoittautui liian monimutkaiseksi itselleni. Näin ollen suuri osa koodista jäi useamman metodin sijaan hieman epäselväksi pötköksi.

Vastustajan muuttaminen erkittävästi erilaiseksi ei oikein toimi, sillä jos vastustajan maila on kovin nopea tai leveä, pisteiden tekemisestä tulee mahdotonta. Vastustajan voimaa kasvattamalla saadaan kuitenkin hyvää lisähaastetta pallon ja sitä kautta pelin nopeutuessa.

Pallon nopeuden muuttuminen kierteen perusteella toimii, mutta ainakin int arvoilla Y suuntaisen nopeuden kasvu on liian nopeaa, ellei sitä rajoiteta. Animation timerin ruudunpäivitysnopeutta saisi varmaan hidastettua, mutta pelin sulavuus kärsisi.
