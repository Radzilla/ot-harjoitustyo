# Ponglike

Jatkettu versio klassikkopelistä Pong

## Dokumentaatio

[Kayttöohje](https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/testausdokumentti.md)

## Releaset

[Pong Viikko 5](https://github.com/Radzilla/ot-harjoitustyo/releases)


## Komentorivitoiminnot

### Testit suoritetaan komennolla

```
mvn test
```

## Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Generoi hakemistoon target/site/jacoco tiedoston index.html mistä voidaan tarkastella testikattavuutta

## Suoritettavan jarin generointi

```
mvn package
```
Generoi hakemistoon target suoritettavan jar tiedoston Pong-1.0-SNAPSHOT.jar

## Checkstyle

[checkstyle.xml](https://github.com/Radzilla/ot-harjoitustyo/blob/master/Pong/checkstyle.xml) määritellyt tarkistukset suoritetaan komennolla 

```
 mvn jxr:jxr checkstyle:checkstyle
```

## JavaDoc

JavaDoc voidaan generoida komennolla

```
 mvn javadoc:javadoc
```

Generoi hakemistoon target/site/apidocs html tiedostoja joiden avulla nähdää sovelluksen API
