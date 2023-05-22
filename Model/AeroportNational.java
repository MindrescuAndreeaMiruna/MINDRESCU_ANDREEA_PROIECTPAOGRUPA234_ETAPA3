package Model;

import java.util.ArrayList;
import static Constants.Constants.SCOP_AEROPORT;


public class AeroportNational extends Aeroport{
    private boolean areWiFi;
    private boolean areLounge;

    public AeroportNational(String denumire, String tara, String oras, int numarTerminale, int numarPiste, ArrayList<CompanieAeriana> companii, boolean areWiFi, boolean areLounge) {
        super(denumire, tara, oras, numarTerminale, numarPiste, companii);
        this.areWiFi = areWiFi;
        this.areLounge = areLounge;
    }


    public void setAreWiFi(boolean areWiFi) {
        this.areWiFi = areWiFi;
    }

    public void setAreLounge(boolean areLounge) {
        this.areLounge = areLounge;
    }

    public boolean isAreWiFi() {
        return areWiFi;
    }

    public boolean isAreLounge() {
        return areLounge;
    }

    @Override
    public String scop() {
        return SCOP_AEROPORT;
    }


    @Override
    public String toString() {
        return "AeroportNational{" +
                super.toString() +
                "areWiFi=" + areWiFi +
                ", areLounge=" + areLounge +
                '}';
    }
}
