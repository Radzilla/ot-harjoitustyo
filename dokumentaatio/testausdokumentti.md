# Testausdokumentti

## Sovelluslogiikka

Peliruudut luova Scenes olio ja pisteiden sovelluslogiikasta huolehtiva Scores jätettiin testien ulkopuolle jottei sekoita tuloslistaa.
Testejä on tehty ruudun komponenttien luomiselle ja niiden arvojen käsittelylle. JavaFX toimintojen testaus ei kuitenkaan sujunut ja testikattavuus jäi etenkin Ball luokan osalta huonolle tasolle.

<img src="https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/jacoco_raportti.png">

## Järjestelmätestaus

### Asennus

Sovelluksen Pong-v1.1.jar sekä configuration.properties on haettu repositorion uusimmasta releasesta ja kokeiltu kahdella tietokoneella joista toisessa on käyttöjärjestelmänä Windows ja toisessa Linux. 
HighScores.txt luominen toimii jos sitä ei ole ja sitä editoidaan oikein jos se onkin olemassa. Tiedostoa editoimalla voi sekoittaa huipputlosruutua.
Sovellus toimii myös ilman configuration.properties tiedostoa, mutta huipputulosten seuranta ei tällöin toimi. 

### Toiminnallisuus

Sovellukset toimivuuden kokeilua on suoritettu manuaalisesti kehitysvaiheessa ja sovelluksen valmistuttua. Kaikkia mahdollisia painikkeita ollaan yritetty painaa ja käyttäjä käsiksi ei pääse sovellukseen juuri muuten käsikisi kuin nimimerkin syötössä ja virheelliset syötteet huomataan hyvin.

