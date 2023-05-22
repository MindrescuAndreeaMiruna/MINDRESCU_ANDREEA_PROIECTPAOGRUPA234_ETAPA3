package Model;
import Model.Avion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Bilet {
    private Date dataPlecarii;
    private String loc;
    private String clasa;
    private int numarPoarta;
    private UUID id;
    private final int idBilet;


    public Bilet(Date dataPlecarii, String loc, String clasa, int numarPoarta, UUID id, int idBilet) {
        this.dataPlecarii = dataPlecarii;
        this.loc = loc;
        this.clasa = clasa;
        this.numarPoarta = numarPoarta;
        this.id = id;
        this.idBilet = idBilet;
    }

    public Bilet(int idBilet){
        this.idBilet = idBilet;
    }

    public void reading(Scanner in) throws ParseException{
        System.out.println("Data plecarii scrisa pe bilet: ");
        this.dataPlecarii = new SimpleDateFormat("yyyy-MM-dd").parse(in.nextLine());
        System.out.println("Locul: ");
        this.loc = in.nextLine();
        System.out.println("Clasa: ");
        this.clasa = in.nextLine();
        System.out.println("Numar poarta: ");
        this.numarPoarta = Integer.parseInt(in.nextLine());
        System.out.println("UUID: ");
        String idString = in.nextLine();
        this.id = UUID.fromString(idString);

    }

    public void reading(ResultSet in) throws SQLException {
        this.dataPlecarii = in.getDate("dataPlecarii");
        this.loc = in.getString("loc");
        this.clasa = in.getString("clasa");
        this.numarPoarta = in.getInt("numarPoarta");
        this.id = (UUID) in.getObject("id");
    }


    public Bilet(int idBilet, Scanner in) throws ParseException{
        this.idBilet = idBilet;
        this.reading(in);
    }

    public Bilet(int idBilet, ResultSet  in) throws SQLException{
        this.idBilet = idBilet;
        this.reading(in);
    }

    public String CSV(){
        return idBilet + "," +
                dataPlecarii + "," +
                loc + "," +
                clasa + "," +
                numarPoarta + "," +
                id;
    }


    public int getIdBilet() {
        return idBilet;
    }

    public UUID getId() {
        return id;
    }


    public void setDataPlecarii(Date dataPlecarii) {
        this.dataPlecarii = dataPlecarii;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    public void setNumarPoarta(int numarPoarta) {
        this.numarPoarta = numarPoarta;
    }



    public Date getDataPlecarii() {
        return dataPlecarii;
    }

    public String getLoc() {
        return loc;
    }

    public String getClasa() {
        return clasa;
    }

    public int getNumarPoarta() {
        return numarPoarta;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "dataPlecarii=" + dataPlecarii +
                ", loc='" + loc + '\'' +
                ", clasa='" + clasa + '\'' +
                ", numarPoarta=" + numarPoarta +
                ", id=" + id +
                ", idBilet=" + idBilet +
                '}';
    }
}
