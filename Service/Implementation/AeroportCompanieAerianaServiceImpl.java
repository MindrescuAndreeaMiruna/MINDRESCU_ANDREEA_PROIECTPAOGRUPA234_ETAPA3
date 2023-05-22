package Service.Implementation;
import Model.Aeroport;
import Model.CompanieAeriana;
import Exception.ExistentCompanieAerianaInAeroport;
import Service.AeroportCompanieAerianaService;
import Validation.AeroportCompanieAerianaValidation;
public class AeroportCompanieAerianaServiceImpl implements AeroportCompanieAerianaService {
    @Override
    public void addCompanieNoua(CompanieAeriana companie, Aeroport aeroport){
        boolean validCompanie = true;
        try{
            if(AeroportCompanieAerianaValidation.validateCompanieAerianaInAeroport(companie, aeroport) == false)
                throw new ExistentCompanieAerianaInAeroport("Aceasta companie aeriana exista deja in acest aeroport.");
        }
        catch(ExistentCompanieAerianaInAeroport exception){
            validCompanie = false;
            System.out.println(exception.getMessage());
        }
        if(validCompanie){
            aeroport.getCompanii().add(companie);
        }

    }
}
