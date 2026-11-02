package fidness.excepciones;

//Excepcion si se dejan campos vacios en el login.
public class CampoVacioException extends Exception {

    public CampoVacioException(String mensaje) {
        super(mensaje);
    }
}
