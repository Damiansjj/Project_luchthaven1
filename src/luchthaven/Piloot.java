package luchthaven;

public class Piloot extends Personeel {
    public Piloot(String naam, int leeftijd, String adres) {
        super(naam, leeftijd, adres);
    }

    public void flightCheck() {
        System.out.println("Flightcheck uitgevoerd door piloot.");
    }
}
