package Model;
import java.io.*;
import java.text.*;
import java.util.*;
public class ZborSingleton {
    private static ZborSingleton singleInstance = null;
    final private ZborManager zborManager = new ZborManager();
    private List<Zbor> zboruri = new ArrayList<Zbor>();

    public List<Zbor> getZboruri(){
        return zboruri;
    }

    public void setZboruri(List<Zbor> zboruri){
        this.zboruri = zboruri;
    }

    public static ZborSingleton getInstance(){
        if(singleInstance == null)
            singleInstance = new ZborSingleton();
        return singleInstance;
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

//     Zbor zborNou = new Zbor(Integer.parseInt(campuri[0]), campuri[1], Integer.parseInt(campuri[2]), Integer.parseInt(campuri[4]));

    public void getCSV() { //https://www.javatpoint.com/how-to-read-csv-file-in-java
        try {
            var columns = ZborSingleton.readCSV("data_final/zbor.csv");
            for (var fields : columns) {
              Zbor zborNou = new Zbor(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[4]));
                zboruri.add(zborNou);
            }
            ZborManager.generateId(columns.size());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public void writeCSV(){

        try{
            FileWriter writer = new FileWriter("data_final/zbor.csv");
            for(Zbor zbor:this.zboruri){
                writer.write(zbor.CSV());
                writer.write("\n");
            }
            writer.close();

        } catch(IOException e){
            System.out.println(e.toString());
        }
    }

}
