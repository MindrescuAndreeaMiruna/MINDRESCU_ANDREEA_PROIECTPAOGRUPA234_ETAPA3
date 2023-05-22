package Service.Implementation;

import Model.Avion;
import Service.AvionService;

import Exception.InvalidSerieAvionException;
import Exception.InvalidDistantaMaximaException;
import Exception.InvalidConsumKerosenMediuException;

import static Validation.AvionValidation.validateSerieAvion;
import static Validation.AvionValidation.validateDistantaMaxima;
import static Validation.AvionValidation.validateConsumKerosenMediu;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import Model.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class AvionServiceImpl implements AvionService {
    ArrayList<Avion> avioane;

    @Override
    public void addAvioane(Avion avion) {
        boolean validAvion = true;
        try {
            if (!validateSerieAvion(avion.getSerieAvion()))
                throw new InvalidSerieAvionException("Seria acestui avion este invalida.");
        } catch (InvalidSerieAvionException exception) {
            validAvion = false;
            System.out.println(exception.getMessage());
        }

        try {
            if (!validateDistantaMaxima(avion.getDistantaMaxima()))
                throw new InvalidDistantaMaximaException("Nu exista niciun avion care sa parcurga o distanta asa scurta.");
        } catch (InvalidDistantaMaximaException exception) {
            validAvion = false;
            System.out.println(exception.getMessage());
        }
        try {
            if (!validateConsumKerosenMediu(avion.getConsumKerosenMediu()))
                throw new InvalidConsumKerosenMediuException("Un avion nu poate avea consumul mediu de combustibil mai mic sau egal cu 0.");
        } catch (InvalidConsumKerosenMediuException exception) {
            validAvion = false;
            System.out.println(exception.getMessage());
        }
        if (validAvion) {
            if (avioane == null)
                avioane = new ArrayList<>();
            avioane.add(avion);
        }
    }

    @Override
    public ArrayList<Avion> getAvioane(){
      /*  try {
            if (avioane == null)
                throw new InvalidAvionException("Lista de avioane este goala.");
        } catch (InvalidAvionException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Avion test finally.");
        }

       */
        return avioane;
    }

    @Override
    public double calculConsumKerosen(Avion avion) {
        double consumKerosen = avion.getDistantaMaxima() / avion.getConsumKerosenMediu();
        return consumKerosen;
    }

    @Override
    public Map<String, Double> getConsumuriAvioaneSortateDupaCheie(ArrayList<Avion> avioane) {
        Map<String, Double> consumuriAvioane = new TreeMap<>();
        for (Avion avion : avioane) {
            double consumKerosen = calculConsumKerosen(avion);
            consumuriAvioane.put(avion.getSerieAvion(), consumKerosen);

        }
        return consumuriAvioane;
    } //aceasta functie returneaza un treemap sortat dupa cheie, adica dupa seria avionului

    @Override
    public List<Map.Entry<String, Double>> listaSortataDupaConsum(Map<String, Double> consumuriAvioane) {
        List<Map.Entry<String, Double>> listaConsumuri = new ArrayList<>(consumuriAvioane.entrySet());
        Collections.sort(listaConsumuri, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return Double.compare(o1.getValue(), o2.getValue());

            }

        });
        return listaConsumuri;

    }

    public void setAvioane(List<Avion> avioane) {
        this.avioane = new ArrayList<>(avioane);
    }

    @Override
    public Avion getAvionLista(Scanner in) throws Exception{
        if(this.avioane.size() == 0)
            throw new Exception("Nu exista inca avioane");
        if(this.avioane.size() == 1)
            return avioane.get(0);
        System.out.println("Avioane id [0-" + (this.avioane.size() - 1) + "]: ");
        int avion_id = Integer.parseInt(in.nextLine());
        return avioane.get(avion_id);

    }

    @Override
    public void afisareAvion(Scanner in) throws Exception{
        Avion avion = this.getAvionLista(in);
        System.out.println(avion.toString());
    }
}
