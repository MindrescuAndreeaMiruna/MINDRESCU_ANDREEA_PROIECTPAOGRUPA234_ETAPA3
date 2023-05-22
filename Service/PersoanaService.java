package Service;
import Model.Persoana;
import java.util.List;
import java.util.Scanner;

public interface PersoanaService {
    void addPersoana(Persoana persoana) throws Exception;

    List<Persoana> getPersoane();

    void setPersoane(List<Persoana> persoane);

    Persoana getPersoanaLista(Scanner in) throws Exception;

    void afisarePersoana(Scanner in) throws Exception;
}
