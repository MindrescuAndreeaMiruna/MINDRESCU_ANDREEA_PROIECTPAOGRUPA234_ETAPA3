package Model;

import java.util.*;
import java.io.*;

public class AvionSingleton {
    private static AvionSingleton instantaAvion = null;

    private List<Avion> avioane = new ArrayList<>();

    public void setAvioane(List<Avion> avioane) {
        this.avioane = avioane;
    }

    public List<Avion> getAvioane() {
        return this.avioane;
    }

    public static AvionSingleton getInstance() {
        if (instantaAvion == null)
            instantaAvion = new AvionSingleton();
        return instantaAvion;
    }

    /*
     * private static List<String[]> readCSV(String numeFisier){
     * List<String[]> coloane = new ArrayList<>();
     *
     * // tratam erorile
     * // inspiratie: javatpoint.com - how to read and parse csv file in java
     *
     * try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))){
     * String linie;
     * while((linie = reader.readLine()) != null){
     * String[] campuri = linie.replaceAll(" ", "").split(",");
     * coloane.add(campuri);
     *
     * }
     * } catch(IOException e){
     * System.out.println("A intervenit o eroare.");
     * }
     * return coloane;
     * }
     *
     */

    private static List<String[]> readCSV(String numeFisier) {
        List<String[]> coloane = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] campuri = linie.replaceAll("\\s", "").split(",");
                coloane.add(campuri);
            }
        } catch (IOException e) {
            System.out.println("A intervenit o eroare.");
        }
        return coloane;
    }

    public void getCSV() {

        // inspiratie : how to read csv file in java - geeksforgeeks

        List<String[]> coloane = AvionSingleton.readCSV("data_final/avion.csv");
        for (String[] campuri : coloane) {
            if (campuri.length == 8) {
                int distantaMaxima = Integer.parseInt(campuri[1]);
                int numarPasageri = Integer.parseInt(campuri[2]);
                String serieAvion = campuri[3];
                int capacitateKerosen = Integer.parseInt(campuri[4]);
                int consumKerosenMediu = Integer.parseInt(campuri[5]);
                String orasPlecare = campuri[6];
                String orasDestinatie = campuri[7];
                int idAvion = Integer.parseInt(campuri[0]);
                Avion avionNou = new Avion(
                        distantaMaxima,
                        numarPasageri,
                        serieAvion,
                        capacitateKerosen,
                        consumKerosenMediu,
                        orasPlecare,
                        orasDestinatie,
                        idAvion);
                avioane.add(avionNou);
            } else {
                System.out.println("Rândul din fișier nu conține toate câmpurile necesare.");
            }
        }

        PersoanaManager.cresteNumarUnicPersoana(coloane.size());
    }

    public void writeCSV() {
        try {
            FileWriter writer = new FileWriter("data_final/avion.csv");
            for (Avion avion : avioane) {
                writer.write(avion.CSV());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void addAvion(Avion avion) {
        avioane.add(avion);
        writeCSV();
    }

}