package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Aeroport {
    private String denumire;
    private String tara;
    private String oras;
    private int numarTerminale;
    private int numarPiste;
    private ArrayList<CompanieAeriana> companii;

    public Aeroport(String denumire, String tara, String oras, int numarTerminale, int numarPiste, ArrayList<CompanieAeriana> companii) {
        this.denumire = denumire;
        this.tara = tara;
        this.oras = oras;
        this.numarTerminale = numarTerminale;
        this.numarPiste = numarPiste;
        this.companii = companii;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public void setNumarTerminale(int numarTerminale) {
        this.numarTerminale = numarTerminale;
    }

    public void setNumarPiste(int numarPiste) {
        this.numarPiste = numarPiste;
    }

    public void setCompanii(ArrayList<CompanieAeriana> companii) {
        this.companii = companii;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getTara() {
        return tara;
    }

    public String getOras() {
        return oras;
    }

    public int getNumarTerminale() {
        return numarTerminale;
    }

    public int getNumarPiste() {
        return numarPiste;
    }

    public ArrayList<CompanieAeriana> getCompanii() {
        return companii;
    }

    public abstract String scop();

    @Override
    public String toString() {
        return "Aeroport{" +
                "denumire='" + denumire + '\'' +
                ", tara='" + tara + '\'' +
                ", oras='" + oras + '\'' +
                ", numarTerminale=" + numarTerminale +
                ", numarPiste=" + numarPiste +
                ", companii=" + companii +
                '}';
    }
}
