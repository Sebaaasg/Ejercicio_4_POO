// @author Sebastian_Garcia
// @version 1.0
// @fecha 28/09/2025
// Descripción: Excepción personalizada para manejar errores que puedan surgir del programa.

public class AccionInvalidaException extends Exception {
    public AccionInvalidaException(String message){
        super(message); // envía el mensaje a la superclase
    }
}
