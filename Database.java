import Model.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Scanner;
import java.sql.Types;


public class Database {
    Connection connection;
    CallableStatement callableStatement = null;

    public Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proiect", "root", "floare27");
    }

    public void creareTabele() throws Exception {
        List<String> tabele = new ArrayList<>();
        tabele.add("CREATE TABLE Avioane (distantaMaxima varchar(255), numarPasageri varchar(100), serieAvion varchar(20), capacitateKerosen varchar(30), consumKerosenMediu varchar(20), orasPlecare varchar(20), orasDestinatie varchar(20), idAvion varchar(50) primary key)");
        tabele.add("CREATE TABLE Bilete (dataPlecarii varchar(255), loc varchar(10), clasa varchar(10), numarPoarta varchar(10), id varchar(255), idBilet varchar(255) primary key)");
        tabele.add("CREATE TABLE Persoane(nume varchar(255), prenume varchar(255), numarTelefon varchar(10), email varchar(255), varsta varchar(10), cnp varchar(13), numarUnic varchar(50) primary key)");
        tabele.add("CREATE TABLE Zboruri(numarZbor varchar(255), denumireAeroportAterizare varchar(255), durataZborMinute varchar(100), idZbor varchar(50) primary key)");

        connection.createStatement().execute(tabele.get(0));
        connection.createStatement().execute(tabele.get(1));
        connection.createStatement().execute(tabele.get(2));
        connection.createStatement().execute(tabele.get(3));
    }

    //----------Avion-----------
    AvionManager avionManager = new AvionManager();

    public List<Avion> readAvion() {
        List<Avion> avioane = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from Avioane";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Avion avionCurent = avionManager.creareAvion(rs);
                avioane.add(avionCurent);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return avioane;
    }

    public void updateAvion(Avion creareAvion){
        PreparedStatement ps = null;
        try{
            String query = "update Avioane set distantaMaxima = ?, numarPasageri = ?, serieAvion = ?, capacitateKerosen = ?, consumKerosenMediu = ?, orasPlecare = ?, orasDestinatie = ? where idAvion = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, creareAvion.getDistantaMaxima());
            ps.setInt(2, creareAvion.getNumarPasageri());
            ps.setString(3, creareAvion.getSerieAvion());
            ps.setInt(4, creareAvion.getCapacitateKerosen());
            ps.setInt(5, creareAvion.getConsumKerosenMediu());
            ps.setString(6, creareAvion.getOrasPlecare());
            ps.setString(7, creareAvion.getOrasDestinatie());
            ps.setInt(8, creareAvion.getIdAvion());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void createAvion(Avion avion){
        PreparedStatement ps = null;
        try{
            String query = "insert into Avioane (distantaMaxima, numarPasageri, serieAvion, capacitateKerosen, consumKerosenMediu, orasPlecare, orasDestinatie, idAvion) values (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, avion.getDistantaMaxima());
            ps.setInt(2, avion.getNumarPasageri());
            ps.setString(3, avion.getSerieAvion());
            ps.setInt(4, avion.getCapacitateKerosen());
            ps.setInt(5, avion.getConsumKerosenMediu());
            ps.setString(6, avion.getOrasPlecare());
            ps.setString(7, avion.getOrasDestinatie());
            ps.setInt(8, avion.getIdAvion());


            ps.execute();
            ps.close();;
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deleteAvion(Avion avion){
        PreparedStatement ps = null;
        try{
            String query = "delete from Avioane where idAvion = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, avion.getIdAvion());
            ps.execute();
            ps.close();
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }

    //-------------------Bilet-------
    BiletManager biletManager = new BiletManager();


    public List<Bilet> readBilet() {
        List<Bilet> bilete = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from Bilete";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bilet biletCurent = biletManager.creareBilet(rs);
                bilete.add(biletCurent);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return bilete;
    }

    public void updateBilet(Bilet creareBilet) {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE Bilete SET dataPlecarii = ?, loc = ?, clasa = ?, numarPoarta = ?, id = ? WHERE idBilet = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, (new SimpleDateFormat("yyyy-MM-dd")).format(creareBilet.getDataPlecarii()));
            ps.setString(2, creareBilet.getLoc());
            ps.setString(3, creareBilet.getClasa());
            ps.setInt(4, creareBilet.getNumarPoarta());
            ps.setObject(5, creareBilet.getId(), Types.OTHER);
            ps.setInt(6, creareBilet.getIdBilet());


            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    public void createBilet(Bilet bilet){
        PreparedStatement ps = null;
        try{
            String query = "insert into Bilete (dataPlecarii, loc, clasa, numarPoarta, id, idBilet) values (?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, (new SimpleDateFormat("yyyy-MM-dd")).format(bilet.getDataPlecarii()));
            ps.setString(2, bilet.getLoc());
            ps.setString(3, bilet.getClasa());
            ps.setInt(4, bilet.getNumarPoarta());
            ps.setObject(5, bilet.getId(), Types.OTHER);
            ps.setInt(6, bilet.getIdBilet());

            ps.execute();
            ps.close();;
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deleteBilet(Bilet bilet){
        PreparedStatement ps = null;
        try{
            String query = "delete from Bilete where idBilet = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, bilet.getIdBilet());
            ps.execute();
            ps.close();
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }

    //---------------PERSOANA

    PersoanaManager persoanaManager = new PersoanaManager();

    public List<Persoana> readPersoana() {
        List<Persoana> persoane = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from Persoane";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persoana persoanaCurenta = persoanaManager.crearePersoana(rs);
                persoane.add(persoanaCurenta);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return persoane;
    }

    public void updatePersoana(Persoana crearePersoana){
        PreparedStatement ps = null;
        try{
            String query = "update Persoane set nume = ?, prenume = ?, numarTelefon = ?, email = ?, varsta = ?, cnp = ? where numarUnic = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, crearePersoana.getNume());
            ps.setString(2, crearePersoana.getPrenume());
            ps.setString(3, crearePersoana.getNumarTelefon());
            ps.setString(4, crearePersoana.getEmail());
            ps.setInt(5, crearePersoana.getVarsta());
            ps.setString(6, crearePersoana.getCnp());
            ps.setInt(7, crearePersoana.getNumarUnic());


            ps.executeUpdate();
            ps.close();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void createPersoana(Persoana persoana){
        PreparedStatement ps = null;
        try{
            String query = "insert into Persoane (nume, prenume, numarTelefon, email, varsta, cnp, numarUnic) values (?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, persoana.getNume());
            ps.setString(2, persoana.getPrenume());
            ps.setString(3, persoana.getNumarTelefon());
            ps.setString(4, persoana.getEmail());
            ps.setInt(5, persoana.getVarsta());
            ps.setString(6, persoana.getCnp());
            ps.setInt(7, persoana.getNumarUnic());
            ps.execute();
            ps.close();;
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deletePersoana(Persoana persoana){
        PreparedStatement ps = null;
        try{
            String query = "delete from Persoane where numarUnic = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, persoana.getNumarUnic());
            ps.execute();
            ps.close();
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }

    //------ZBOR

      ZborManager zborManager = new ZborManager();

    public List<Zbor> readZbor() {
        List<Zbor> zboruri = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from Zboruri";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Zbor zborCurent = zborManager.creareZbor(rs);
                zboruri.add(zborCurent);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return zboruri;
    }

    public void updateZbor(Zbor creareZbor){
        PreparedStatement ps = null;
        try{
            String query = "update Zbor set numarZbor = ?, denumireAeroportAterizare = ?, durataZborMinute = ? where idZbor = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, creareZbor.getNumarZbor());
            ps.setString(2, creareZbor.getDenumireAeroportAterizare());
            ps.setInt(3, creareZbor.getDurataZborMinute());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void createZbor(Zbor zbor){
        PreparedStatement ps = null;
        try{
            String query = "insert into Zboruri (numarZbor, denumireAeroportAterizare, durataZborMinute, idZbor) values (?, ?, ?, ?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, zbor.getNumarZbor());
            ps.setString(2, zbor.getDenumireAeroportAterizare());
            ps.setInt(3, zbor.getDurataZborMinute());
            ps.setInt(4, zbor.getId_zbor());

            ps.execute();
            ps.close();;
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deleteZbor(Zbor zbor){
        PreparedStatement ps = null;
        try{
            String query = "delete from Zboruri where idZbor = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, zbor.getId_zbor());
            ps.execute();
            ps.close();
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }

}

