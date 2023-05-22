package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.*;

public class Persoana {
    private String nume;
    private String prenume;
    private String numarTelefon;
    private String email;
    private int varsta;
    private String cnp;
    private final int  numarUnic;


    public Persoana(String nume, String prenume, String numarTelefon, String email, int varsta, String cnp, int numarUnic) {
        this.nume = nume;
        this.prenume = prenume;
        this.numarTelefon = numarTelefon;
        this.email = email;
        this.varsta = varsta;
        this.cnp = cnp;
        this.numarUnic = numarUnic;
    }

    // functie de citire date membre
    public Persoana(int numarUnic){
        this.numarUnic = numarUnic;
    }

    public void reading(Scanner in) throws ParseException{
        System.out.println("Numele persoanei: ");
        this.nume = in.nextLine();
        System.out.println("Prenumele persoanei: ");
        this.prenume = in.nextLine();
        System.out.println("Numarul de telefon al persoanei: ");;
        this.numarTelefon = in.nextLine();
        System.out.println("Email-ul persoanei: ");
        this.email = in.nextLine();
        System.out.println("Varsta persoanei: ");
        this.varsta = Integer.parseInt(in.nextLine()); //convertim valoarea citita de la tastatura "string" in int
        System.out.println("CNP-ul persoanei: ");
        this.cnp = in.nextLine();
    }

    public void reading(ResultSet in) throws SQLException{
        this.nume = in.getString("nume");
        this.prenume = in.getString("prenume");
        this.numarTelefon = in.getString("numarTelefon");
        this.email = in.getString("email");
        this.varsta = in.getInt("varsta");
        this.cnp = in.getString("cnp");
    }

    public Persoana(int numarUnic, Scanner in) throws ParseException{
        this.numarUnic = numarUnic;
        this.reading(in);
    }

    public Persoana(int numarUnic, ResultSet in) throws SQLException{
        this.numarUnic = numarUnic;
        this.reading(in);
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public String getCnp() {
        return cnp;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public String getEmail() {
        return email;
    }

    public int getNumarUnic() {
        return numarUnic;
    }


    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", numarTelefon='" + numarTelefon + '\'' +
                ", email='" + email + '\'' +
                ", varsta=" + varsta +
                ", cnp='" + cnp + '\'' +
                '}';
    }

    @Override
    public int hashCode(){
        return Objects.hash(nume, prenume, numarTelefon, email, varsta, cnp, numarUnic);
    }

    public String CSV(){
        return numarUnic + ","
                + nume + "," +
                prenume + "," +
                numarTelefon + "," +
                email + "," +
                varsta + "," +
                cnp;
    }
}
