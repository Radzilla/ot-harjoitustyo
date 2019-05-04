package fi.sillaras.functionality;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Scores luokka huolehtii voitettujen vastustajien määrästä ja pelin päätyttyä
 * lisää pelaajan nimen ja voitettujen vastustajien määrän txt tiedostoon
 *
 * @author sillaras
 */
public class Scores {

    ArrayList<String> allScores = new ArrayList<>();
    private String name;
    private int round;
    private File file;

    public Scores() {
        this.round = 0;
        this.name = "";

    }

    /**
     * Lisää voitetun kierroksen
     */
    public void addRound() {
        this.round++;
    }

    /**
     * Nollaa voitetut kierrokset
     */
    public void resetRound() {
        this.round = 0;
    }

    /**
     * Vaihtaa pelaajan nimen Scenesin tekstikentään syöetyksi
     *
     * @param name Pelaajan nimi annetaan parametrina metodille
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Kirjoittaa HighScores.txt tiedostoon voitetut vastustajat ja pelaajan
     * nimen omalle rivilleen
     *
     * @throws IOException
     */
    public void setScore() throws IOException {
        File file = new File("HighScore.txt");
        FileWriter fileW = new FileWriter(file, true);
        try (BufferedWriter bufferedW = new BufferedWriter(fileW)) {
            bufferedW.write(this.round + " - " + this.name + "\n");
        }

    }

    /**
     * Tallentaa HighScores.txt tiedoston ArrayList muodossa ja järjestää sen
     * niin että parhaat pisteet ovat ensimmäisenä ja palauttaa listan 5
     * ensimmäistä pelaajaa Stringinä Scenes liuokalle missä ne asetetaan
     * näkyviin.
     *
     * @return 5 parasta pelaaja yhtenä Stringinä
     * @throws FileNotFoundException
     */
    public String getScore() throws FileNotFoundException {
        int top = 0;
        StringBuilder scoreString = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("HighScore.txt"))) {
            while (scanner.hasNextLine()) {
                allScores.add(scanner.nextLine());
            }
            Collections.sort(allScores);
            Collections.reverse(allScores);
            for (int i = 0; i < allScores.size() && i < 5; i++) {
                scoreString.append(allScores.get(i) + "\n");
            }
            String highScores = scoreString.toString();
            return highScores;
        }

    }

}
