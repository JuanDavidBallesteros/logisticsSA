package exception;

public class GraphException extends Exception {
    private String message;

    public GraphException(boolean isFrom) {
        
        message = (isFrom) ? "El nodo de origen no existe" : "El nodo de destino no existe";
    }

    public String getMessage() {
        return message;
    }
}
