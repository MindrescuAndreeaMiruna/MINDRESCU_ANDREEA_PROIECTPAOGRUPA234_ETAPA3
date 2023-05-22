package Model;

import java.util.*;
import java.text.*;
import java.io.*;

public class PersoanaSingleton {
    private static PersoanaSingleton instantaPersoana = null;
    final private PersoanaManager persoanaManager = new PersoanaManager();
    //constructor privat
    private List<Persoana> persoane = new ArrayList<Persoana>();

    public void setPersoane(List<Persoana> persoane){
        this.persoane = persoane;
    }
    public List<Persoana> getPersoane(){
        return persoane;
    }

    public static PersoanaSingleton getInstance(){
        if(instantaPersoana == null)
            instantaPersoana = new PersoanaSingleton();
        return instantaPersoana;
    }

    //                Persoana persoanaNoua = new Persoana(campuri[0], campuri[1], campuri[2], campuri[3], Integer.parseInt(campuri[4]), campuri[5], Integer.parseInt(campuri[6]));
    private static List<String[]> readCSV(String fileName) {

        List<String[]> columns = new ArrayList<>();

        try (var in = new BufferedReader(new FileReader(fileName))) { //https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/

            String line;

            while ((line = in.readLine()) != null) {
                String[] fields = line.replaceAll(" ", "").split(",");
                columns.add(fields);
            }
        } catch (IOException e) {
            System.out.println("Error!");
        }

        return columns;
    }

    public void getCSV() { //https://www.javatpoint.com/how-to-read-csv-file-in-java
        try {
            var columns = PersoanaSingleton.readCSV("data_final/persoana.csv");
            for (var fields : columns) {
                Persoana persoanaNoua = new Persoana(fields[0], fields[1], fields[2], fields[3], Integer.parseInt(fields[4]), fields[5], Integer.parseInt(fields[6]));
                persoane.add(persoanaNoua);
            }
            PersoanaManager.cresteNumarUnicPersoana(columns.size());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void writeCSV() {
        try {
            var writer = new FileWriter("data_final/persoana.csv");
            for (var persoana : this.persoane) {
                writer.write(persoana.CSV());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void addPersoana(Persoana persoana){
        persoane.add(persoana);
        writeCSV();
    }


}
