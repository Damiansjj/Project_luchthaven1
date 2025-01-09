package luchthaven;

import java.util.ArrayList;
import java.util.List;

public class Luchthaven {
    private List<Vlucht> vluchten;
    private List<Passagier> passagiers;

    public Luchthaven() {
        this.vluchten = new ArrayList<>();
        this.passagiers = new ArrayList<>();
    }
    public void voegPassagierToe(Passagier passagier) {
        passagiers.add(passagier);
    }
    public void voegVluchtToe(Vlucht vlucht) {
        vluchten.add(vlucht);
    }
    public Vlucht findVlucht(String vluchtCode) {
        for (Vlucht vlucht : vluchten) {
            if (vluchtCode.equals(vlucht.getVluchtCode())) {
                return vlucht;
            }
        }
        return null; // Vlucht niet gevonden
    }
    public Passagier findPassagier(String naam) {
        for (Passagier passagier : passagiers) {
            if (passagier.getNaam().equalsIgnoreCase(naam)) {
                return passagier;
            }
        }
        return null; // Geen passagier gevonden
    }
}