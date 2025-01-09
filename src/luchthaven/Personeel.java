package luchthaven;

public class Personeel {
    private String naam;
    private int leeftijd;
    private String functie;

    public Personeel(String naam, int leeftijd, String functie) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.functie = functie;
    }

    public String getNaam() {
        return naam;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }
}