import Model.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class Servicii {
    protected List<Avion> avioane = new ArrayList<>();
    protected List<Bilet> bilete = new ArrayList<>();
    protected List<Zbor> zboruri = new ArrayList<>();
    protected List<Persoana> persoane = new ArrayList<>();

    protected final AvionManager avionManager = new AvionManager();
    protected final BiletManager biletManager = new BiletManager();
    protected ZborManager  zborManager = new ZborManager();
    protected PersoanaManager persoanaManager = new PersoanaManager();

    Database db = new Database();
    public Servicii() throws SQLException {
    }

    public List<Avion> getAvioane() {
        return avioane;
    }
    public List<Bilet> getBilete() {
        return bilete;
    }
    public List<Zbor> getZboruri() {
        return zboruri;
    }
    public List<Persoana> getPersoane() {
        return persoane;
    }

    public void setAvioane(List<Avion> avioane) {
        this.avioane = avioane;
    }
    public void setZboruri(List<Zbor> zboruri) {
        this.zboruri = zboruri;
    }
    public void setPersoane(List<Persoana> persoane) {
        this.persoane = persoane;
    }
    public void setBilete(List<Bilet> bilete) {
        this.bilete = bilete;
    }

    private Avion getAvionLista(Scanner in) throws Exception {
        if (this.avioane.size() == 0)
            throw new Exception("Nu exista inca avioane");
        if (this.avioane.size() == 1)
            return avioane.get(0);
        System.out.println("Avioane id [0-" + (this.avioane.size() - 1) + "]: ");
        int avion_id= Integer.parseInt(in.nextLine());
        return avioane.get(avion_id);
    }

    private Zbor getZboruriLista(Scanner in) throws Exception {
        if (this.zboruri.size() == 0)
            throw new Exception("Nu exista inca zboruri");
        if (this.zboruri.size() == 1)
            return zboruri.get(0);
        System.out.println("Zboruri id [0-" + (this.zboruri.size() - 1) + "]: ");
        int zbor_id = Integer.parseInt(in.nextLine());
        return zboruri.get(zbor_id);
    }

    private Bilet getBiletLista(Scanner in) throws Exception {
        if (this.bilete.size() == 0)
            throw new Exception("Nu exista inca bilete");
        if (this.bilete.size() == 1)
            return bilete.get(0);
        System.out.println("Bilete id [0-" + (this.bilete.size() - 1) + "]: ");
        int bilet_id = Integer.parseInt(in.nextLine());
        return bilete.get(bilet_id);
    }

    private Persoana getPersoanaLista(Scanner in) throws Exception {
        if (this.persoane.size() == 0)
            throw new Exception("Nu exista inca persoane");
        if (this.persoane.size() == 1)
            return persoane.get(0);
        System.out.println("Persoana id [0-" + (this.persoane.size() - 1) + "]: ");
        int persoana_id = Integer.parseInt(in.nextLine());
        return persoane.get(persoana_id);
    }

    public void crearePersoana(Scanner in) throws ParseException {
        Persoana persoanaNoua = persoanaManager.crearePersoana(in);
        this.persoane.add(persoanaNoua);
        if(this.db.readPersoana() != null)
            this.db.createPersoana(persoanaNoua);
        System.out.println("Persoana noua creat cu succes!");
    }

    public void creareBilet(Scanner in) throws ParseException {
        Bilet biletNou = biletManager.creareBilet(in);
        this.bilete.add(biletNou);
        if(this.db.readBilet() != null)
            this.db.createBilet(biletNou);
        System.out.println("Bilet nou creat cu succes!");
    }

    public void creareAvion(Scanner in) throws ParseException {
        Avion avionNou = avionManager.creareAvion(in);
        this.avioane.add(avionNou);
        if(this.db.readAvion() != null)
            this.db.createAvion(avionNou);
        System.out.println("Avion nou creat cu succes!");
    }

    public void creareZbor(Scanner in) throws ParseException {
        Zbor zborNou = zborManager.creareZbor(in);
        this.zboruri.add(zborNou);
        if(this.db.readZbor() != null)
            this.db.createZbor(zborNou);
        System.out.println("Zbor nou creat cu succes!");
    }

  /*  public void stergeAvionDinBazaDeDate(Avion avion) {
        if (avioane.contains(avion)) {
            db.deleteAvion(avion);
            avioane.remove(avion);
            System.out.println("Avionul a fost șters din baza de date.");
        } else {
            System.out.println("Avionul nu există în baza de date.");
        }
    }

    public void stergeBiletDinBazaDeDate(Bilet bilet) {
        if (bilete.contains(bilet)) {
            db.deleteBilet(bilet);
            bilete.remove(bilet);
            System.out.println("Biletul a fost șters din baza de date.");
        } else {
            System.out.println("Biletul nu există în baza de date.");
        }
    }

    public void stergeZborDinBazaDeDate(Zbor zbor) {
        if (zboruri.contains(zbor)) {
            db.deleteZbor(zbor);
            zboruri.remove(zbor);
            System.out.println("Zborul a fost șters din baza de date.");
        } else {
            System.out.println("Zborul nu există în baza de date.");
        }
    }

    public void stergePersoanaDinBazaDeDate(Persoana persoana) {
        if (persoane.contains(persoana)) {
            db.deletePersoana(persoana);
            persoane.remove(persoana);
            System.out.println("Persoana a fost ștearsa din baza de date.");
        } else {
            System.out.println("Persoana nu există în baza de date.");
        }
    }


   */









}
