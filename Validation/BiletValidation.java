package Validation;
import java.util.Date;

public class BiletValidation {
    public static boolean validateDataPlecarii (Date dataPlecarii){
        Date dataCurenta = new Date();
        if(!dataPlecarii.after(dataCurenta))
            return false;
        return true;
    }

    public static boolean validateLoc(String loc){
        if(loc.matches("^[A-Z]\\d{1,2}$"))
            return true;
        return false; //locul trebuie sa fie de forma A2, B16 etc, maxim 2 cifre, doar o litera.

    }

    public static boolean validateClasa(String clasa){
        if(!clasa.equals("Business") && !clasa.equals("Economica"))
            return false;
        return true;
    }

    public static boolean numarPoartaValida(int numarPoarta){
        if(numarPoarta >=1 && numarPoarta <= 99)
            return true;
        return false;
    }


}
