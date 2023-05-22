package Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.text.ParseException;


public class BiletManager {
    private static int numarUnicBilet = 0;

    public static void cresteNumarUnicBilet(int i) {
        BiletManager.numarUnicBilet += i;
    }

    public Bilet creareBilet(ResultSet in) throws SQLException {
        cresteNumarUnicBilet(1);
        Bilet bilet = new Bilet(numarUnicBilet, in);
        BiletSingleton.getInstance().addBilet(bilet);
        return bilet;
    }

    public Bilet creareBilet(Scanner in) throws ParseException {
        cresteNumarUnicBilet(1);
        Bilet bilet = new Bilet(numarUnicBilet, in);
        BiletSingleton.getInstance().addBilet(bilet);
        return bilet;

    }

}
