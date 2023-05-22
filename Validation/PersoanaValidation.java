package Validation;

public class PersoanaValidation {
    public static boolean validateNumarTelefon(String numarTelefon){
        if(!numarTelefon.matches("[0-9]+"))
            return false;
        if(numarTelefon.length() != 10)
            return false;
        return true;
    }

    public static boolean validateEmail(String email) {
        if(email == null || email.isEmpty()) {
            return false;
        }
        if(!email.contains("@") || !email.contains(".")) {
            return false;
        }
        return true;
    }

    public static boolean validateVarsta(int varsta){
        if(varsta < 0 )
            return false;
        return true;

    }

}
