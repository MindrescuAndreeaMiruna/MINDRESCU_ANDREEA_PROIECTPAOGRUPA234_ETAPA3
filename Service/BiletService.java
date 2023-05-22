package Service;
import Model.Bilet;

import java.util.*;


public interface BiletService {
    void addBilet(Bilet bilet) throws Exception;
    //Map<UUID, Bilet> getBilete() throws Exception;
    void setBilete(ArrayList<Bilet> bilete);
    Bilet getBiletLista(Scanner in) throws Exception;
    void afisareBilet(Scanner in) throws Exception;
    ArrayList<Bilet> getBilete();
}
