package luchthaven;

public class BeveiligingsPersoneel extends Personeel {
    public BeveiligingsPersoneel(String naam, int leeftijd, String adres) {
        super(naam, leeftijd, adres);
    }

    public void veiligheidControleren() {
        System.out.println("Veiligheidscontrole uitgevoerd.");
    }
}
