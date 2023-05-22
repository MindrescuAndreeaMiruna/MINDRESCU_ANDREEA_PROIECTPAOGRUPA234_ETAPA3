import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;
import Service.Implementation.*;
import Service.AvionService;

import Model.*;

public class Main {


    public static void main(String[] args) throws Exception {
        CallableStatement spro = null;

        Scanner in = new Scanner(System.in);
        boolean ok = false;
        Servicii servicii = new Servicii();
        AvionManager avionManager = new AvionManager();
        BiletManager biletManager = new BiletManager();
        ZborManager zborManager = new ZborManager();
        PersoanaManager persoanaManager = new PersoanaManager();
        var connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proiect", "root", "floare27");
        Database db = new Database();


        while (!ok) {
            System.out.println("Inserati comanda: ");
            System.out.println("1: Creare avion nou: ");
            System.out.println("2: Creare bilet nou: ");
            System.out.println("3: Creare zbor nou: ");
            System.out.println("4: Creare persoana noua: ");
            System.out.println("5: Sterge un anumit avion din baza de date: ");
            System.out.println("6: Sterge un anumit bilet din baza de date: ");
            System.out.println("7: Sterge un anumit zbor din baza de date: ");
            System.out.println("8: Sterge o anumita persoana din baza de date: ");
            System.out.println("9: Afiseaza avioanele: ");
            System.out.println("0: EXIT");
            String command = in.nextLine();
            try {
                switch (command) {
                    case "1":
                        servicii.creareAvion(in);
                        break;
                    case "2":
                        servicii.creareBilet(in);
                        break;
                    case "3":
                        servicii.creareZbor(in);
                        break;
                    case "4":
                        servicii.crearePersoana(in);
                        break;
                    case "5":
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Introduceți id-ul avionului de șters: ");
                        int idAvion = scanner.nextInt();
                        Avion avionDeSters = new Avion(idAvion);
                        db.deleteAvion(avionDeSters);
                        break;
                    case "6":
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.print("Introduceți id-ul biletului de șters: ");
                        int id_bilet = scanner1.nextInt();
                        Bilet biletDeSters = new Bilet(id_bilet);
                        db.deleteBilet(biletDeSters);
                        break;
                    case "7":
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.print("Introduceți id-ul zborului de șters: ");
                        int idZbor = scanner2.nextInt();
                        Zbor zborDeSters = new Zbor(idZbor);
                        db.deleteZbor(zborDeSters);
                        break;
                    case "8":
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.print("Introduceți id-ul persoanei de șters: ");
                        int idPersoana = scanner3.nextInt();
                        Persoana persoanaDeSters = new Persoana(idPersoana);
                        db.deletePersoana(persoanaDeSters);
                        break;
                    case "9":
                        List<Avion> avioane = db.readAvion();
                        for(Avion avion1 : avioane)
                        {
                            System.out.println(avion1.getDistantaMaxima());
                            System.out.println(avion1.getOrasDestinatie());
                            System.out.println(avion1.getOrasPlecare());
                            System.out.println(avion1.getSerieAvion());
                        }

                    case "0":
                        ok = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        try {
            assert connection != null;
            connection.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}