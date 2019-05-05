# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenteessa on vain pakkaukset fi.sillaras.funktionality ja fi.sillaras.components.


Paukkauksessa fi.sillaras.funktionality on sovelluksen käyttäliittymän ja sovelluslogikkan toteuttava luokka Scenes, sekä pisteiden laskusta ja huipputuloksien esityksestä huolehtiva luokka Scores

Paukkauksessa fi.sillaras.components sisältää luokat Paddle ja Ball, jotka huolehtivat pelivälineiden luonnista ja tuonnista peliruutuun.

<img src="https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Pong_Luokkakaavio.png">
Kuvassa on alkuperäinen ajatus luokkien rakenteesta. Screensin nimi on vaihdettu Scenesiksi ja luokka Scores lisätty valmiissa sovelluksessa.

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

## Luokat

### Scenes

Huolehtii erilaisten näkymien näyttämisestä ja myös pelin komponenttien ohjaamisesta 

### Scores

Huolehtii HighScore listan ylläpidosta ja palautuksesta näkyviin Scenesille String muodossa.

### Ball 

Ball luokkan olioon on tallennettu palloon liittyvät ominaisuudet kuten X ja Y suuntaiset nopeudet, kierre ja pallolla on myös metodi millä tarkastetaan sen osuminen mailoihin. Scenes luokan animation timerin handle hyödyntää näitä. 

### Paddle

Paddle oliot luodaan kummallekkin pleaajalle ja oliolla on tiedo mailan ominaisuuksista ja kuten voimasta ja leveydestä, mutta myös mailan kiihtyvyydestä ja nopeudesta. Scenes luokan animation timern handle hyödyntää tietoa mailojen nopeudesta liikutellessaan niitä peliruudussa.

## Ongelmat koodissa

Käyttöliittymää ja sovelluslogiikaa ei olla saatu kokonaan eroteltua toistaan. Tarkoituksena oli tehdä jokaisesta näkymästä oma luokka tai edes metodi erilliseen luokkaan, mutta näkyminen ohjaaminen ja animation timerin käyttö tätä varten luodun luokan kautta osoittautui liian monimutkaiseksi. Näin ollen suuri osa koodista jäi useamman metodin sijaan pitkäksi kokonaisuudeksi Scenes luokkaan.

Vastustajan muuttaminen erkittävästi erilaiseksi ei oikein toimi, sillä jos vastustajan maila on kovin nopea tai leveä, pisteiden tekemisestä tulee mahdotonta. Vastustajan voimaa kasvattamalla saadaan kuitenkin hyvää lisähaastetta pallon ja sitä kautta pelin nopeutuessa. 

Mailan leveyden muutosta ei onnistuttu päivittämämään peliruutun, joten ainoastaan voimaa ja nopeutta voidaan kasvattaa.

Pallon kiihtyminen kierteen perusteella toimii, mutta ainakin int arvoilla Y suuntaisen nopeuden kasvu on liian nopeaa, ellei sitä rajoiteta. Myös mailojen kiihtyminen maksinopeuteensa käy nopeasti samasta syystä.
