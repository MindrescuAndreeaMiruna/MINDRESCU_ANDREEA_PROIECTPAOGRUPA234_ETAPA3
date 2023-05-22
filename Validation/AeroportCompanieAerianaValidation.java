package Validation;

import Model.Aeroport;
import Model.CompanieAeriana;

public class AeroportCompanieAerianaValidation {
    public static boolean validateCompanieAerianaInAeroport(CompanieAeriana companie, Aeroport aeroport){
        if(aeroport.getCompanii().contains((companie))){
            return false;
        }
        return true;
    }
}
