# Kayttöohjeet 

Tallenna tiedosto [Pong](https://github.com/Radzilla/ot-harjoitustyo/releases/download/Viikko5/Pong-1.0.jar) haluamaasi sijaintiin

## Ohjelman käynnistäminen

Ohjelman voi avata tuplaklikkaamalla ladattua tiedostoa.



## Pelin tarkoitus

Pelissä ohjaamasi maila on vasemmassa reunassa ja tietokoneen ohjaaman vastustaja maila oikeassa reunassa. 
Tarkoituksena on yrittää saada pisteitä lyömällä vastustajan takana olevaan seinään ja estämällä pallon pääsy omaan seinään.

<img src="https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Pelinakyma.PNG">

## Pelin aloitus


Peli aloitusruudussa annetaan vielä lyhyet ohjeet pelin toimintaan ja Start game painiketta klikkaamalla siirrtyään varsinaiseen peliin.
Aloitustilanteessa pallo liikkuu mailojen välillä ilman pystysuuntaista liikettä. 
Palloon saa pystysuuntaista liikettä liikuttamalla mailaa sen osuessa palloon, jolloin myös vastustaja lähtee liikkeelle yrittäen seurata palloa.
Käytännössä pallon pystyliikettä tarvitsee kasvattaa niin ettei vastustaja pysy perässä.
Pelin voittaa se joka saa ensiksi 3 pistettä. 

## Pelin päättyminen

Jos vastustaja voittaa peliä voidaan ytittää uudelleen painiketta klikkaamalla. 
Jos pelaaja voittaa voit valita parannuksen mailaasi ja saat vastustajaksesi lujempaa lyövän mailan.
