package Service;

import Model.Zbor;

import java.util.List;
import java.util.Scanner;
import java.util.Set;


public interface ZborService {
     void addZbor(Zbor zbor) throws Exception;
     List<Zbor> getZbor();
     void setZboruri(List<Zbor> zboruri);
     Zbor getZborLista(Scanner in) throws Exception;
     void afisareZbor(Scanner in) throws Exception;


}
