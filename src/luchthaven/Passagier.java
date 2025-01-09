package luchthaven;

public class Passagier {
    private String naam;
    private int leeftijd;
    private String adres;
    private Ticket ticket;
    private double gewichtBagage;

    public Passagier(String naam, int leeftijd, String adres, Ticket ticket, double gewichtBagage) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres = adres;
        this.ticket = ticket;
        this.gewichtBagage = gewichtBagage;
    }

    public String getNaam() {
        return naam;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
