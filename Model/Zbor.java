package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.*;

public class Zbor {
    private int numarZbor;
    private String denumireAeroportAterizare;
    private int durataZborMinute;
    private final int id_zbor;

    public Zbor(int numarZbor, String denumireAeroportAterizare, int durataZborMinute, int id_zbor) {
        this.numarZbor = numarZbor;
        this.denumireAeroportAterizare = denumireAeroportAterizare;
        this.durataZborMinute = durataZborMinute;
        this.id_zbor = id_zbor;
    }

    public Zbor(int id_zbor, Scanner in) throws ParseException{
        this.id_zbor = id_zbor;
        this.citire(in);
    }

    public Zbor(int id_zbor, ResultSet in) throws SQLException{
        this.id_zbor = id_zbor;
        this.citire(in);
    }

    public Zbor(int id_zbor){
        this.id_zbor = id_zbor;
    }

    public void citire(Scanner in) throws ParseException{
        System.out.println("Numarul zborului: ");
        this.numarZbor = Integer.parseInt(in.nextLine());
        System.out.println("Denumirea aeroportului de aterizare: ");
        this.denumireAeroportAterizare = in.nextLine();
        System.out.println("Durata zborului in minute: ");
        this.durataZborMinute = Integer.parseInt(in.nextLine());
    }

    public void citire(ResultSet in) throws SQLException{
        this.numarZbor = in.getInt("numarZbor");
        this.denumireAeroportAterizare = in.getString("denumireAeroportAterizare");
        this.durataZborMinute = in.getInt("durataZborMinute");
    }

    public String CSV(){
        return id_zbor + "," +
                numarZbor + "," +
                denumireAeroportAterizare + "," +
                durataZborMinute;

    }

    public int getId_zbor() {
        return id_zbor;
    }

    public void setNumarZbor(int numarZbor) {
        this.numarZbor = numarZbor;
    }

    public void setDenumireAeroportAterizare(String denumireAeroportAterizare) {
        this.denumireAeroportAterizare = denumireAeroportAterizare;
    }

    public void setDurataZborMinute(int durataZborMinute) {
        this.durataZborMinute = durataZborMinute;
    }

    public int getNumarZbor() {
        return numarZbor;
    }

    public String getDenumireAeroportAterizare() {
        return denumireAeroportAterizare;
    }

    public int getDurataZborMinute() {
        return durataZborMinute;
    }

    @Override
    public String toString() {
        return "Zbor{" +
                "numarZbor=" + numarZbor +
                ", denumireAeroportAterizare='" + denumireAeroportAterizare + '\'' +
                ", durataZborMinute=" + durataZborMinute +
                '}';
    }
}
