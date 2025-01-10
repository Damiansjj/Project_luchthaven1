    package luchthaven;

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Luchthaven luchthaven = new Luchthaven();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                toonKeuzemenu();
                int keuze = scanner.nextInt();
                scanner.nextLine();  // consume newline
                verwerkKeuze(keuze, scanner, luchthaven);
            }
        }

        // Toon het keuzemenu
        private static void toonKeuzemenu() {
            System.out.println("\nWelkom bij de luchthaven");
            System.out.println("1. Nieuwe passagier toevoegen");
            System.out.println("2. Nieuwe vlucht toevoegen");
            System.out.println("3. Ticket aanmaken");
            System.out.println("4. Boarding");
            System.out.println("5. Personeel toewijzen");
            System.out.println("6. Print vlucht info");
            System.out.println("7. Stoppen");
            System.out.print("Kies een optie: ");
        }

        // Verwerk de keuze van de gebruiker
        private static void verwerkKeuze(int keuze, Scanner scanner, Luchthaven luchthaven) {
            switch (keuze) {
                case 1:
                    voegPassagier(scanner, luchthaven);
                    break;
                case 2:
                    voegVlucht(scanner, luchthaven);
                    break;
                case 3:
                    maakTicket(scanner, luchthaven);
                    break;
                case 4:
                    voegBoarding(scanner, luchthaven);
                    break;
                case 5:
                    voegPersoneel(scanner, luchthaven);
                    break;
                case 6:
                    printVluchtInfo(scanner, luchthaven);
                    break;
                case 7:
                    System.out.println("Applicatie afgesloten.");
                    scanner.close();
                    break;
                default:
                    System.out.println("Ongeldige keuze. Probeer het opnieuw.");
            }
        }

        // Voeg een passagier toe
        private static void voegPassagier(Scanner scanner, Luchthaven luchthaven) {
            System.out.print("Naam van de passagier: ");
            String naam = scanner.nextLine();
            System.out.print("Leeftijd van de passagier: ");
            int leeftijd = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Adres van de passagier: ");
            String adres = scanner.nextLine();

            Passagier nieuwePassagier = new Passagier(naam, leeftijd, adres, null, 15.5);
            if (luchthaven.findPassagier(naam) == null) {
                luchthaven.voegPassagierToe(nieuwePassagier);
                System.out.println("Passagier toegevoegd: " + nieuwePassagier.getNaam());
            } else {
                System.out.println("Passagier bestaat al.");
            }
        }

        // Voeg een vlucht toe
        private static void voegVlucht(Scanner scanner, Luchthaven luchthaven) {
            System.out.print("Vluchtcode: ");
            String vluchtCode = scanner.nextLine();
            System.out.print("Eindbestemming: ");
            String bestemming = scanner.nextLine();
            System.out.print("Aantal economy plaatsen: ");
            int economy = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Aantal business plaatsen: ");
            int business = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Vlucht nieuweVlucht = new Vlucht(vluchtCode, bestemming, economy, business);
            luchthaven.voegVluchtToe(nieuweVlucht);
            System.out.println("Vlucht toegevoegd.");
        }

        // Maak een ticket aan voor een passagier
        private static void maakTicket(Scanner scanner, Luchthaven luchthaven) {
            System.out.print("Passagier naam: ");
            String naam = scanner.nextLine();
            Passagier passagier = luchthaven.findPassagier(naam);
            if (passagier == null) {
                System.out.print("Leeftijd: ");
                int leeftijd = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Adres: ");
                String adres = scanner.nextLine();
                passagier = new Passagier(naam, leeftijd, adres, null, 15.5);
                luchthaven.voegPassagierToe(passagier);
            }

            System.out.print("Vluchtcode: ");
            String vluchtCode = scanner.nextLine();
            Vlucht vlucht = luchthaven.findVlucht(vluchtCode);
            if (vlucht != null) {
                System.out.print("Klasse (economy/business): ");
                String klasse = scanner.nextLine();
                if (vlucht.isErPlaatsInKlasse(klasse)) {
                    Ticket nieuwTicket = new Ticket(passagier, klasse, vlucht);
                    passagier.setTicket(nieuwTicket);
                    vlucht.boekPlaats(klasse);
                    System.out.println("Ticket aangemaakt voor " + passagier.getNaam());
                } else {
                    System.out.println("Geen plaats beschikbaar in de gekozen klasse.");
                }
            } else {
                System.out.println("Vlucht niet gevonden.");
            }
        }

        // Uitvoeren van boarding voor een passagier
        private static void voegBoarding(Scanner scanner, Luchthaven luchthaven) {
            System.out.print("Vluchtcode voor boarding: ");
            String vluchtCode = scanner.nextLine();
            Vlucht vlucht = luchthaven.findVlucht(vluchtCode);
            if (vlucht != null) {
                System.out.print("Passagier naam: ");
                String naam = scanner.nextLine();
                Passagier passagier = luchthaven.findPassagier(naam);
                if (passagier != null && passagier.getTicket() != null && passagier.getTicket().getVlucht().equals(vlucht)) {
                    vlucht.voegPassagierToe(passagier);
                    System.out.println("Passagier mag boarden.");
                } else {
                    System.out.println("Ticket is niet geldig voor deze vlucht.");
                }
            } else {
                System.out.println("Vlucht niet gevonden.");
            }
        }

        // Personeel toewijzen aan een vlucht
        private static void voegPersoneel(Scanner scanner, Luchthaven luchthaven) {
            System.out.print("Vluchtcode voor personeel: ");
            String vluchtCode = scanner.nextLine();
            Vlucht vlucht = luchthaven.findVlucht(vluchtCode);
            if (vlucht != null) {
                System.out.print("Naam personeel: ");
                String naam = scanner.nextLine();
                System.out.print("Leeftijd personeel: ");
                int leeftijd = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Functie (Piloot/Beveiligingspersoneel/Bagagepersoneel/Checkpersoneel): ");
                String functie = scanner.nextLine();

                Personeel personeel = new Personeel(naam, leeftijd, functie);
                vlucht.voegPersoneelToe(personeel);

                System.out.println("Personeel toegewezen: " + naam + " (" + functie + ")");
                System.out.println("Functie wordt uitgevoerd:");
                personeel.voerFunctieUit();
            } else {
                System.out.println("Vlucht niet gevonden.");
            }
        }


        // Print vluchtinformatie
        private static void printVluchtInfo(Scanner scanner, Luchthaven luchthaven) {
            System.out.print("Vluchtcode voor informatie: ");
            String vluchtCode = scanner.nextLine();
            Vlucht vlucht = luchthaven.findVlucht(vluchtCode);
            if (vlucht != null) {
                vlucht.printVluchtInfo();
            } else {
                System.out.println("Vlucht niet gevonden.");
            }
        }
    }
