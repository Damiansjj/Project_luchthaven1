package luchthaven;

public class Ticket {
    private Passagier passagier;
    private String klasse;
    private Vlucht vlucht;

    public Ticket(Passagier passagier, String klasse, Vlucht vlucht) {
        this.passagier = passagier;
        this.klasse = klasse;
        this.vlucht = vlucht;
    }



    public Vlucht getVlucht() {
        return vlucht;
    }

    public String getEindbestemming() {
        return vlucht.getEindBestemming();
    }
}
