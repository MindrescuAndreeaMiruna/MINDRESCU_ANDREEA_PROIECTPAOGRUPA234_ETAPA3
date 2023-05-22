package Model;

import java.util.*;
import java.text.*;
import java.io.*;

public class BiletSingleton {
    private static BiletSingleton instantaBilet = null;
    final private BiletManager biletManager = new BiletManager();
    private List<Bilet> bilete = new ArrayList<>();

    public void setBilete(List<Bilet> bilete) {
        this.bilete = bilete;
    }

    public List<Bilet> getBilete() {
        return bilete;
    }

    public static BiletSingleton getInstance() {
        if (instantaBilet == null)
            instantaBilet = new BiletSingleton();
        return instantaBilet;
    }

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
            var columns = BiletSingleton.readCSV("data_final/bilet.csv");
            for (var fields : columns) {
                UUID uuid = UUID.fromString(fields[4]);
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                Date date = dateFormat.parse(fields[0]);

                Bilet biletNou = new Bilet(date, fields[1], fields[2], Integer.parseInt(fields[3]), uuid, Integer.parseInt(fields[5]));
                bilete.add(biletNou);
            }
            BiletManager.cresteNumarUnicBilet(columns.size());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
        /*  public void getCSV() {
        List<String[]> coloane = BiletSingleton.readCSV("data_final/bilet.csv");
        for (String[] campuri : coloane) {
            UUID id = UUID.fromString(campuri[4]);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataPlecarii = dateFormat.parse(campuri[0]);
            Date dataPlecarii;
            try {
                dataPlecarii = dateFormat.parse(campuri[0]);
            } catch (ParseException e) {
                System.out.println("Data plecării nu este în formatul corect. Se va folosi data curentă.");
                dataPlecarii = new Date(); // Example: using the current date as a default value
            }

            Bilet biletNou = new Bilet(dataPlecarii, campuri[1], campuri[2], Integer.parseInt(campuri[3]), id, Integer.parseInt(campuri[5]));
            bilete.add(biletNou);
        }
        BiletManager.cresteNumarUnicBilet(coloane.size());
    }
    */

    public void writeCSV(){
        try{
            FileWriter writer = new FileWriter("data_final/bilet.csv");
            for(Bilet bilet:this.bilete){
                writer.write(bilet.CSV());
                writer.write("\n");
            }
            writer.close();

        } catch(IOException e){
            System.out.println(e.toString());
        }
    }

    public void addBilet(Bilet bilet){
        bilete.add(bilet);
        writeCSV();
    }

}
