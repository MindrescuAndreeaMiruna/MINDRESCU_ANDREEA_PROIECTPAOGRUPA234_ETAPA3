package Exception;

public class NoBiletFoundException extends RuntimeException{
    public NoBiletFoundException(String message){
        super(message);
    }
}
