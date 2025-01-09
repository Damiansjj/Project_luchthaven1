package luchthaven;

import java.util.ArrayList;
import java.util.List;

public class Vlucht {
    private String vluchtCode;
    private String eindBestemming;
    private int aantalEconomyPlaatsen;
    private int aantalBusinessPlaatsen;
    private int economyPlaatsenBeschikbaar;
    private int businessPlaatsenBeschikbaar;
    private List<Passagier> passagiers = new ArrayList<>();
    private List<Personeel> personeelLijst = new ArrayList<>();

    public Vlucht(String vluchtCode, String eindBestemming, int aantalEconomyPlaatsen, int aantalBusinessPlaatsen) {
        this.vluchtCode = vluchtCode;
        this.eindBestemming = eindBestemming;
        this.aantalEconomyPlaatsen = aantalEconomyPlaatsen;
        this.aantalBusinessPlaatsen = aantalBusinessPlaatsen;
        this.economyPlaatsenBeschikbaar = aantalEconomyPlaatsen;
        this.businessPlaatsenBeschikbaar = aantalBusinessPlaatsen;
    }

    public String getVluchtCode() {
        return vluchtCode;
    }

    public String getEindBestemming() {
        return eindBestemming;
    }

    public void setEindBestemming(String eindBestemming) {
        this.eindBestemming = eindBestemming;
    }

    public void setAantalEconomyPlaatsen(int aantalEconomyPlaatsen) {
        this.aantalEconomyPlaatsen = aantalEconomyPlaatsen;
        this.economyPlaatsenBeschikbaar = aantalEconomyPlaatsen; // Update beschikbaarheid
    }

    public void setAantalBusinessPlaatsen(int aantalBusinessPlaatsen) {
        this.aantalBusinessPlaatsen = aantalBusinessPlaatsen;
        this.businessPlaatsenBeschikbaar = aantalBusinessPlaatsen; // Update beschikbaarheid
    }


    public boolean isErPlaatsInKlasse(String klasse) {
        if (klasse.equalsIgnoreCase("economy")) {
            return economyPlaatsenBeschikbaar > 0;
        } else if (klasse.equalsIgnoreCase("business")) {
            return businessPlaatsenBeschikbaar > 0;
        }
        return false;
    }

    public void voegPersoneelToe(Personeel personeel) {
        personeelLijst.add(personeel);
    }

    public void voegPassagierToe(Passagier passagier) {
        passagiers.add(passagier);
    }

    public void boekPlaats(String klasse) {
        if (klasse.equalsIgnoreCase("economy") && economyPlaatsenBeschikbaar > 0) {
            economyPlaatsenBeschikbaar--;
        } else if (klasse.equalsIgnoreCase("business") && businessPlaatsenBeschikbaar > 0) {
            businessPlaatsenBeschikbaar--;
        } else {
            System.out.println("Geen beschikbare plaatsen in de " + klasse + " klasse.");
        }
    }
    public void printVluchtInfo() {
        System.out.println("Vluchtcode: " + vluchtCode);
        System.out.println("Eindbestemming: " + eindBestemming);
        System.out.println("Passagiers:");
        for (Passagier passagier : passagiers) {
            System.out.println("- " + passagier.getNaam());
        }
        System.out.println("Personeel:");
        for (Personeel personeel : personeelLijst) {
            System.out.println("- " + personeel.getNaam() + " (" + personeel.getFunctie() + ")");
        }

    }
}