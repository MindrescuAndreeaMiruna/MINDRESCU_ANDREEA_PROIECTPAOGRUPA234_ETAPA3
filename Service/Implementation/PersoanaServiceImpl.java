package Service.Implementation;

import Exception.InvalidVarstaException;
import Exception.InvalidEmailException;
import Exception.InvalidNumarTelefonException;
import Exception.NoPersoanaFoundException;
import Model.Persoana;
import Service.PersoanaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Validation.PersoanaValidation.validateEmail;
import static Validation.PersoanaValidation.validateVarsta;
import static Validation.PersoanaValidation.validateNumarTelefon;
public class PersoanaServiceImpl implements PersoanaService {
    List<Persoana> persoane;

    @Override
    public void addPersoana(Persoana persoana) {
        boolean validPersoana = true;
        try {
            if (!validateNumarTelefon(persoana.getNumarTelefon()))
                throw new InvalidNumarTelefonException("Numarul de telefon al persoanei este invalid.");

        } catch (InvalidNumarTelefonException exception) {
            validPersoana = false;
            System.out.println(exception.getMessage());
        }

        try {
            if (!validateEmail(persoana.getEmail()))
                throw new InvalidEmailException("Emailul persoanei este invalid.");

        } catch (InvalidEmailException exception) {
            validPersoana = false;
            System.out.println(exception.getMessage());
        }

        try {
            if (!validateVarsta(persoana.getVarsta()))
                throw new InvalidVarstaException("Persoana are o varsta invalida.");

        } catch (InvalidVarstaException exception) {
            validPersoana = false;
            System.out.println(exception.getMessage());
        }
        if (validPersoana) {
            if (persoane == null)
                persoane = new ArrayList<>();
            persoane.add(persoana);
        }


    }

    // override pe getPersoane
    @Override
    public List<Persoana> getPersoane() {
       /* try{
            if(persoane == null)
                throw new NoPersoanaFoundException("Nu exista nicio persoana in aceasta lista.");
        }
        catch(NoPersoanaFoundException exception){
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("Test Persoana finally"); //?
        }

        */
        return persoane;
    }
    @Override
    public void setPersoane(List<Persoana> persoane){
        this.persoane = persoane;
    }

    @Override
    public Persoana getPersoanaLista(Scanner in) throws Exception{
        if(this.persoane.size() == 0)
            throw new Exception("Nu exista inca persoane");
        if(this.persoane.size() == 1)
            return persoane.get(0);
        System.out.println("Persoane id [0-" + (this.persoane.size() - 1) + "]: ");
        int persoana_id = Integer.parseInt(in.nextLine());
        return persoane.get(persoana_id);

    }

    @Override
    public void afisarePersoana(Scanner in) throws Exception {
        var persoana = this.getPersoanaLista(in);
        System.out.println(persoana.toString());
    }
}
