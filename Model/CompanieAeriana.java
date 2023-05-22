package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompanieAeriana {
    private String numeCompanie;
    private String codCompanie;
    private List<String> destinatii;
    private ArrayList<Avion> avioane;
    private TipCompanie tipCompanie;

    public CompanieAeriana(String numeCompanie, String codCompanie, List<String> destinatii, ArrayList<Avion> avioane, TipCompanie tipCompanie) {
        this.numeCompanie = numeCompanie;
        this.codCompanie = codCompanie;
        this.destinatii = destinatii;
        this.avioane = avioane;
        this.tipCompanie = tipCompanie;
    }

    public void setNumeCompanie(String numeCompanie) {
        this.numeCompanie = numeCompanie;
    }

    public void setCodCompanie(String codCompanie) {
        this.codCompanie = codCompanie;
    }

    public void setDestinatii(List<String> destinatii) {
        this.destinatii = destinatii;
    }

    public void setAvioane(ArrayList<Avion> avioane) {
        this.avioane = avioane;
    }

    public void setTipCompanie(TipCompanie tipCompanie) {
        this.tipCompanie = tipCompanie;
    }

    public String getNumeCompanie() {
        return numeCompanie;
    }

    public String getCodCompanie() {
        return codCompanie;
    }

    public List<String> getDestinatii() {
        return destinatii;
    }

    public ArrayList<Avion> getAvioane() {
        return avioane;
    }

    public TipCompanie getTipCompanie() {
        return tipCompanie;
    }

    @Override
    public String toString() {
        return "CompanieAeriana{" +
                "numeCompanie='" + numeCompanie + '\'' +
                ", codCompanie='" + codCompanie + '\'' +
                ", destinatii=" + destinatii +
                ", avioane=" + avioane +
                ", tipCompanie=" + tipCompanie +
                '}';
    }
}





