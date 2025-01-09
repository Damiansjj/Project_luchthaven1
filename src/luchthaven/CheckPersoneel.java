package luchthaven;

public class CheckPersoneel extends Personeel {
    public CheckPersoneel(String naam, int leeftijd, String adres) {
        super(naam, leeftijd, adres);
    }

    public void inchecken() {
        System.out.println("Passagier ingecheckt.");
    }
}
