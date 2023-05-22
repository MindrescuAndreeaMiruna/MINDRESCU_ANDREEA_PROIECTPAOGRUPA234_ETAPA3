import Model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class Audit {
    FileWriter writer;
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public void denumireActiune(String actiune) throws IOException{
        writer.append(actiune);
        writer.append(",");
        writer.append(formatter.format(LocalDateTime.now()));
        writer.append("\n");
        writer.flush();
    }
    public Audit(){
        try{
            this.writer = new FileWriter("data_final/audit.csv");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
