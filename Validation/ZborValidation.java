package Validation;

public class ZborValidation {
    public static boolean validateDenumireAeroportAterizare( String denumireAeroportAterizare){
        if(denumireAeroportAterizare.matches("^[a-zA-Z\\s]+$"))
            return true;
        return false;
    }
}
