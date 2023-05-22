package Service.Implementation;

import Exception.InvalidDenumireAeroportAterizareException;
import Exception.NoZboruriFoundException;
import Model.Zbor;
import Service.ZborService;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.Scanner;
import static Validation.ZborValidation.validateDenumireAeroportAterizare;


public class ZborServiceImpl implements ZborService {
    Set<Zbor> zboruri;
    List<Zbor> zboruri1;

    @Override
    public void addZbor(Zbor zbor){
        boolean validZbor = true;
        try{
            if(!validateDenumireAeroportAterizare(zbor.getDenumireAeroportAterizare()))
                throw new InvalidDenumireAeroportAterizareException("Denumirea acestui aeroport de aterizare nu exista.");
        }
        catch(InvalidDenumireAeroportAterizareException exception){
            validZbor = false;
            System.out.println(exception.getMessage());
        }
        if(validZbor){
            if(zboruri == null)
                zboruri = new HashSet<>();
            zboruri.add(zbor);
        }
    }
    @Override
    public List<Zbor> getZbor(){
      /*  try{
            if(zboruri == null)
                throw new NoZboruriFoundException("Nu sunt zboruri inregistrate in acest set.");
        }
        catch(NoZboruriFoundException exception){
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("Test Zbor finally.");
        }

       */
        return zboruri1;

    }
    @Override
    public void setZboruri(List<Zbor> zboruri){
        this.zboruri1 = zboruri;
    }

    @Override
    public Zbor getZborLista(Scanner in) throws Exception{
        if(this.zboruri1.size() == 0)
            throw new Exception("Nu exista inca zboruri");
        if(this.zboruri1.size() == 1)
            return zboruri1.get(0);
        System.out.println("Zboruri id [0-" + (this.zboruri1.size() - 1) + "]: ");
        int zboruri_id = Integer.parseInt(in.nextLine());
        return zboruri1.get(zboruri_id);

    }

    @Override
    public void afisareZbor(Scanner in) throws Exception{
        var zbor = this.getZborLista(in);
        System.out.println(zbor.toString());
    }



}
