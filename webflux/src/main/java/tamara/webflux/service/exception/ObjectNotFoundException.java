package tamara.webflux.service.exception;

public class ObjectNotFoundException extends  RuntimeException{
    public ObjectNotFoundException(String message){
        super(message);
    }
}
