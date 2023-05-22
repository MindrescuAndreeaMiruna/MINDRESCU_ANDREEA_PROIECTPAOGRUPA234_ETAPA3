package Validation;

public class AvionValidation {
    public static boolean validateSerieAvion(String serieAvion){
        String regex = "[a-zA-Z0-9]+";
        return serieAvion.matches(regex);
    }

    public static boolean validateDistantaMaxima(double distantaMaxima){
        if(distantaMaxima < 300)
            return false;
        return true;
    }

    public static boolean validateConsumKerosenMediu(double consumKerosenMediu){
        if(consumKerosenMediu <= 0)
            return false;
        return true;
    }
}
