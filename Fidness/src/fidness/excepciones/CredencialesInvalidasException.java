package fidness.excepciones;

// Se lanza cuando el usuario no existe o la contraseña es incorrecta.
public class CredencialesInvalidasException extends Exception {

    public CredencialesInvalidasException(String mensaje) {
        super(mensaje);
    }
}
