package Service.Implementation;

import Exception.InvalidDataPlecariiException;
import Exception.InvalidLocException;
import Exception.InvalidClasaException;
import Exception.InvalidNumarPoartaException;
import Exception.NoBiletFoundException;

import static Validation.BiletValidation.validateClasa;
import static Validation.BiletValidation.validateLoc;
import static Validation.BiletValidation.validateDataPlecarii;
import static Validation.BiletValidation.numarPoartaValida;

import Model.Bilet;
import Service.BiletService;

import java.util.*;

public class BiletServiceImpl implements BiletService {
   // Map<UUID, Bilet> bilete = new HashMap<>();
ArrayList<Bilet> bilete;


    @Override
    public void addBilet(Bilet bilet){
        boolean validBilet = true;
        try{
            if(!validateDataPlecarii(bilet.getDataPlecarii()))
                throw new InvalidDataPlecariiException("Data de plecare de pe biletul de zbor este invalida.");
        }
        catch (InvalidDataPlecariiException exception){
            validBilet = false;
            System.out.println(exception.getMessage());
        }

        try{
            if(!validateClasa(bilet.getClasa()))
                throw new InvalidClasaException("Clasa de pe biletul de avion nu este valida.");
        }
        catch (InvalidClasaException exception){
            validBilet = false;
            System.out.println(exception.getMessage());
        }

        try{
            if(!validateLoc(bilet.getLoc()))
                throw new InvalidLocException("Locul de pe acest bilet nu este valid.");
        }
        catch(InvalidLocException exception){
            validBilet = false;
            System.out.println(exception.getMessage());
        }

        try{
            if(!numarPoartaValida(bilet.getNumarPoarta()))
                throw new InvalidNumarPoartaException("Numarul portii nu este valid.");
        }
        catch(InvalidNumarPoartaException exception){
            validBilet = false;
            System.out.println(exception.getMessage());
        }
        if(validBilet){
            if(bilete == null)
                bilete = new ArrayList<>();
            bilete.add(bilet);

        }
    }

   /* @Override
    public Map<UUID, Bilet> getBilete() throws Exception{
        try{
            if(bilete == null)
                throw new NoBiletFoundException("In acest dictionar nu exista niciun bilet.");
        }
        catch(NoBiletFoundException exception){
            System.out.println(exception.getMessage());
        }
        finally{
            System.out.println("Test Bilet finally.");
        }
        return bilete;
    }

    */


    @Override
    public void setBilete(ArrayList<Bilet> bilete) {
        this.bilete = bilete;
    }

    @Override
    public ArrayList<Bilet> getBilete(){
        return bilete;
    }

    @Override
    public Bilet getBiletLista(Scanner in) throws Exception{
        if(this.bilete.size() == 0)
            throw new Exception("Nu exista inca bilete");
        if(this.bilete.size() == 1)
            return bilete.get(0);
        System.out.println("Bilete id [0-" + (this.bilete.size() - 1) + "]: ");
        int bilet_id = Integer.parseInt(in.nextLine());
        return bilete.get(bilet_id);
    }

   @Override
    public void afisareBilet(Scanner in) throws Exception{
        var bilet = this.getBiletLista(in);
       System.out.println(bilet.toString());
   }
}
