package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class PersoanaManager {
    private static int numarUnicPersoana = 0;

    public static void cresteNumarUnicPersoana (int x){
        PersoanaManager.numarUnicPersoana += x;
    }

    public Persoana crearePersoana(Scanner in) throws ParseException{
        cresteNumarUnicPersoana(1);
        Persoana persoana = new Persoana(numarUnicPersoana, in);
        PersoanaSingleton.getInstance().addPersoana(persoana);
        return persoana;
    }

    public Persoana crearePersoana(ResultSet in) throws SQLException{
        cresteNumarUnicPersoana(1);
        Persoana persoana = new Persoana(numarUnicPersoana, in);
        PersoanaSingleton.getInstance().addPersoana(persoana);
        return persoana;
    }

}

