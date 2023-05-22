package Service;
import Model.Avion;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public interface AvionService {
    void addAvioane(Avion avion) throws Exception;
    ArrayList <Avion> getAvioane();
    double calculConsumKerosen(Avion avion);
    Map<String, Double> getConsumuriAvioaneSortateDupaCheie(ArrayList<Avion> avioane);
    List<Map.Entry<String, Double>> listaSortataDupaConsum(Map<String, Double> consumuriAvioane);
    void setAvioane(List<Avion> avioane);
    Avion getAvionLista(Scanner in) throws Exception;
    void afisareAvion(Scanner in) throws Exception;


}
