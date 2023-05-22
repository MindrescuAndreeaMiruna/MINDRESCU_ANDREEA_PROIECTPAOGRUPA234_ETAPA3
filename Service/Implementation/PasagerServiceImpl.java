package Service.Implementation;
import Exception.NoPasagerException;
import Exception.InvalidNumarBagajeException;

import static Validation.PasagerValidation.validateNumarBagaje;
import Model.Pasager;
import Service.PasagerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


public class PasagerServiceImpl implements PasagerService {
    List<Pasager> pasageri;
    public void addPasager(Pasager pasager){
        boolean validPasager = true;
        try{
            if(!validateNumarBagaje(pasager.getNumarBagaje()))
                throw new InvalidNumarBagajeException("Nu este permis ca un pasager sa aiba mai mult de 3 bagaje.");

        }
        catch(InvalidNumarBagajeException exception){
            validPasager = false;
            System.out.println(exception.getMessage());
        }
        if(validPasager){
            if(pasageri == null)
                pasageri = new ArrayList<>();
            pasageri.add(pasager);
        }
    }

    @Override
    public List<Pasager> getPasageri() throws Exception{
        try{
            if(pasageri == null)
                throw new NoPasagerException("Aceasta lista nu contine niciun pasager.");
        }
        catch(NoPasagerException exception){
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("Pasager test finally");
        }
        return pasageri;
    }


    @Override
    public List<Pasager> getPasageriOrdonatiDupaNumarulDeBagaje(List<Pasager> pasageri)
        {
        if (pasageri != null) {
            Comparator<Pasager> comparator = new Comparator<Pasager>() {
                @Override
                public int compare(Pasager o1, Pasager o2) {
                    return o2.getNumarBagaje() - o1.getNumarBagaje();
                }
            };
            Collections.sort(pasageri, comparator);
        }
        return pasageri;
    }


}
