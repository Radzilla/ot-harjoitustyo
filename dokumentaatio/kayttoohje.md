# Kayttöohjeet 

Tallenna tiedostot [Pong](https://github.com/Radzilla/ot-harjoitustyo/releases/download/v1.1/Pong-v1.1.jar) 
sekä [Configuration.properties](https://github.com/Radzilla/ot-harjoitustyo/releases/download/v1.1/config.properties)
samaan sijaintiin jos haluat huipputulosten toimivan. Tällöin luodaan myös tiedosto HighScores.txt pelin päättyessä.

## Ohjelman käynnistäminen

Ohjelman voi avata tuplaklikkaamalla ladattua Pong-v1.1.jar tiedostoa.



## Pelin tarkoitus

Pelissä ohjaamasi maila on vasemmassa reunassa ja tietokoneen ohjaaman vastustaja maila oikeassa reunassa. 
Tarkoituksena on yrittää saada pisteitä osumalla pallolla vastustajan takana olevaan seinään ja estämällä pallon osuminen omaan seinään.

<img src="https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Pelinakyma.PNG">

## Pelin aloitus


Peli aloitusruudussa annetaan vielä lyhyet ohjeet pelin toimintaan. 
Ruudussa on tekstikenttä mihin tulee syöttää 1-10 merkkiä pitkä nimimerkki ja Start game painiketta klikkaamalla siirrtyään varsinaiseen peliin.
Aloitustilanteessa pallo liikkuu mailojen välillä ilman pystysuuntaista liikettä. 
Palloon saa pystysuuntaista liikettä liikuttamalla mailaa sen osuessa palloon, jolloin myös vastustaja lähtee liikkeelle yrittäen seurata palloa.
Käytännössä pallon pystyliikettä tarvitsee kasvattaa niin ettei vastustaja pysy pallon perässä.
Erän voittaa se joka saa ensiksi 3 pistettä. 
Erän voitettuasi voit kasvattaa mailan voimaa tai nopeutta. Vastustajasta tulee myös vahvempi.

## Pelin päättyminen

Jos vastustaja voittaa, pääset näkemään parhaat tulokset ja ehkä sinutkin lisätään listalle. Peliä voidaan yrittää uudelleen Try again painiketta klikkaamalla.

