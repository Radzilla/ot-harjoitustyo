# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenteessa on vain pakkaukset fi.sillaras.funktionality ja fi.sillaras.components.


Paukkauksessa fi.sillaras.funktionality on sovelluksen käyttäliittymän ja sovelluslogikkan toteuttava luokka Scenes, sekä pisteiden laskusta ja huipputuloksien esityksestä huolehtiva luokka Scores

Paukkauksessa fi.sillaras.components sisältää luokat Paddle ja Ball, jotka huolehtivat pelivälineiden luonnista ja tuonnista peliruutuun.

<img src="https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Pong_Luokkakaavio.png">
Kuvassa on alkuperäinen ajatus luokkien rakenteesta. Screensin nimi on vaihdettu Scenesiksi ja luokka Scores lisätty valmiiseen sovellukseen.

## Käyttöliittymä

Pelin käyttöliittymä on kokonaan graafinen ja se koostuu neljästä näkymästä

Ohjenäkymä
Peliruutu
Päivityksen valinta
Pelin häviäminen

Nämä on toteutettu JavaFX:n valmiina Scene olioina ja näytettävä Scene siirretään sovelluksen Stageen. 

Ohjenäkymän, päivityksen valinta ja uuden pelin aloittaminen on toteutettu painikkeiden avulla.
Pelattavaa peliruutua käytetään nuolinäppäinten avulla.

## Sovelluslogiikka

Luokka Pong vastaa käyttöliittymän erilaisten näkymien luonnista ja näyttämisestä käyttäjälle, sekä niiden välillä siirtymisestä. 

Pong pystyy myös luomaan ja muuttamaan pallon ja pelaajien mailojen tietoja, sekä myös luomaan niiden perusteella peliruutuun tarvittavat komponentit muotoina. Alla olevassa kuvassa oleva sekvenssikaavio esittää peliruudun luomista.

<img src="https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Pelinakyma_Sekvenssi.PNG">

Pong luokassa on myös AnimationTimerin sisällä handle metodi, joka seuraa nuolinäppäinten painallusta ja pallon sijaintia vastustajan "tekoälyn" mailaan. Handle liikuttaa peliruudun luomisen yhteydessä luotuja komponentteja peliruudussa ohjeistetulla tavalla kymmeniä kertoja sekunnissa. 



## Ongelmat koodissa

Käyttöliittymää ja sovelluslogiikaa ei olla saatu eroteltua toistaan, sillä näkyminen ohjaaminen ja animation timerin käyttö tätä varten itse luodun Scenes luokan kautta osoittautui liian monimutkaiseksi. Näin ollen suuri osa koodista jäi useamman metodin sijaan pitkäksi kokonaisuudeksi.

Vastustajan muuttaminen erkittävästi erilaiseksi ei oikein toimi, sillä jos vastustajan maila on kovin nopea tai leveä, pisteiden tekemisestä tulee mahdotonta. Vastustajan voimaa kasvattamalla saadaan kuitenkin hyvää lisähaastetta pallon ja sitä kautta pelin nopeutuessa.

Pallon nopeuden muuttuminen kierteen perusteella toimii, mutta ainakin int arvoilla Y suuntaisen nopeuden kasvu on liian nopeaa, ellei sitä rajoiteta. Animation timerin ruudunpäivitysnopeutta saisi varmaan hidastettua, mutta pelin sulavuus kärsisi.
