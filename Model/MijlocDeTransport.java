package Model;

public interface MijlocDeTransport {
    public String ruta();

    default String getDefaultMessage(){
        return "Aceasta este o metoda definita in interfata MijlocdeTransport";
    }

}
