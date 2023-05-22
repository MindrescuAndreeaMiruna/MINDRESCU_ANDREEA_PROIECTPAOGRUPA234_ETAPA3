package Model;

import java.text.ParseException;
import java.util.Scanner;

public class Pasager extends Persoana{
    private Bilet bilet;
    private int numarBagaje;

    public Pasager(String nume, String prenume, String numarTelefon, String email, int varsta, String cnp, int numarUnic, Bilet bilet, int numarBagaje) {
        super(nume, prenume, numarTelefon, email, varsta, cnp, numarUnic);
        this.bilet = bilet;
        this.numarBagaje = numarBagaje;
    }

    public Pasager(int numarUnic, Scanner in, Bilet bilet, int numarBagaje) throws ParseException {
        super(numarUnic, in);
        this.bilet = bilet;
        this.numarBagaje = numarBagaje;
    }

    public void setBilet(Bilet bilet) {
        this.bilet = bilet;
    }

    public void setNumarBagaje(int numarBagaje) {
        this.numarBagaje = numarBagaje;
    }

    public Bilet getBilet() {
        return bilet;
    }

    public int getNumarBagaje() {
        return numarBagaje;
    }

    @Override
    public String toString() {
        return "Pasager{" +
                super.toString() +
                "bilet=" + bilet +
                ", numarBagaje=" + numarBagaje +
                '}';
    }
}
