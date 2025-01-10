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

    public int getLeeftijd() {
        return leeftijd;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    // Functies specifiek voor rollen
    public void voerFunctieUit() {
        switch (functie.toLowerCase()) {
            case "piloot":
                bekijkVluchtInfo();
                break;
            case "bagagepersoneel":
                bagageVerwerken();
                break;
            case "checkpersoneel":
                inchecken();
                break;
            case "beveiligingspersoneel":
                veiligheidControleren();
                break;
            default:
                System.out.println("Onbekende functie: " + functie);
        }
    }

    // Specifieke methoden voor elke functie
    private void bekijkVluchtInfo() {
        System.out.println("Vluchtinformatie wordt bekeken.");
    }

    private void bagageVerwerken() {
        System.out.println("Bagage wordt verwerkt.");
    }

    private void inchecken() {
        System.out.println("Passagier ingecheckt.");
    }

    private void veiligheidControleren() {
        System.out.println("Veiligheidscontrole uitgevoerd.");
    }
}
