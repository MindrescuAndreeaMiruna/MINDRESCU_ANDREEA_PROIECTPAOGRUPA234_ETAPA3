package Validation;

public class PasagerValidation {
    public static boolean validateNumarBagaje(int numarBagaje){
        if(numarBagaje > 3 )
            return false;
        return true;
    }
}
