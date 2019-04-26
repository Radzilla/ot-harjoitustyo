# Ponglike

Jatkettu versio klassikkopelistä Pong

## Dokumentaatio

[vaatimusmaarittely](https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/Radzilla/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

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

## Suoritettavan jarin generointi

```
mvn package
```
generoi hakemistoon target suoritettavan jar tiedoston Pong-1.0-SNAPSHOT.jar

## Checkstyle

[checkstyle.xml](https://github.com/Radzilla/ot-harjoitustyo/blob/master/Pong/checkstyle.xml) määritellyt tarkistukset suoritetaan komennolla 

```
 mvn jxr:jxr checkstyle:checkstyle
```



