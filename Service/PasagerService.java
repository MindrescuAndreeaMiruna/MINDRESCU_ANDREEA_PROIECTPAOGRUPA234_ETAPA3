package Service;
import Model.Pasager;
import java.util.List;
public interface PasagerService {
    void addPasager(Pasager pasager) throws Exception;
    List<Pasager> getPasageri() throws Exception;
    List<Pasager> getPasageriOrdonatiDupaNumarulDeBagaje(List<Pasager> pasageri);
}
