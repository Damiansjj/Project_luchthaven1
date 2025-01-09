package luchthaven;

public class BagagePersoneel extends Personeel {
    public BagagePersoneel(String naam, int leeftijd, String adres) {
        super(naam, leeftijd, adres);
    }

    public void bagageVerwerken() {
        System.out.println("Bagage wordt verwerkt.");
    }
}
