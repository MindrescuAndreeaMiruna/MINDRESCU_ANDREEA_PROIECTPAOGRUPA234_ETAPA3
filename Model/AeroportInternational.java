package Model;

import java.util.ArrayList;
import static Constants.Constants.SCOP_AEROPORT;
public class AeroportInternational extends Aeroport {
    private boolean areHotel;
    private boolean areDutyFree;

    public AeroportInternational(String denumire, String tara, String oras, int numarTerminale, int numarPiste, ArrayList<CompanieAeriana> companii, boolean areHotel, boolean areDutyFree) {
        super(denumire, tara, oras, numarTerminale, numarPiste, companii);
        this.areHotel = areHotel;
        this.areDutyFree = areDutyFree;
    }

    public void setAreHotel(boolean areHotel) {
        this.areHotel = areHotel;
    }

    public void setAreDutyFree(boolean areDutyFree) {
        this.areDutyFree = areDutyFree;
    }

    public boolean isAreHotel() {
        return areHotel;
    }

    public boolean isAreDutyFree() {
        return areDutyFree;
    }

    @Override
    public String scop() {
        return SCOP_AEROPORT;
    }


    @Override
    public String toString() {
        return "AeroportInternational{" +
                super.toString() +
                "areHotel=" + areHotel +
                ", areDutyFree=" + areDutyFree +
                '}';
    }
}
