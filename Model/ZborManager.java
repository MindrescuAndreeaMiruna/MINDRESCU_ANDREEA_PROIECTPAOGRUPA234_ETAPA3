package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.*;

public class ZborManager {
    private static int idUnic = 0;

    public static void generateId(int i){
        ZborManager.idUnic += i;
    }

    public Zbor creareZbor(Scanner in) throws ParseException{
        return new Zbor(idUnic++, in);
    }

    public Zbor creareZbor(ResultSet in) throws SQLException{
        return new Zbor(idUnic++, in);
    }
}
