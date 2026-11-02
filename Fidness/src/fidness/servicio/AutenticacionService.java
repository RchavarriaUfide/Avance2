package fidness.servicio;
//Imports
import fidness.excepciones.CampoVacioException;
import fidness.excepciones.CredencialesInvalidasException;
import fidness.modelo.Usuario;
import java.util.HashMap;
import java.util.Map;

//Servicio para autenticar
public class AutenticacionService {

    // Coleccion con usuarios usando hashes.
    private Map<String, Usuario> usuarios = new HashMap<>();

    public AutenticacionService() {
        //Usuarios de prueba precargados
        usuarios.put("Romario", new Usuario("Romario", "1234"));
        usuarios.put("Ana", new Usuario("Ana", "abcd"));
        usuarios.put("Carlos", new Usuario("Carlos", "1111"));
    }
//Pantalla para el inicio de sesion
    public Usuario iniciarSesion(String nombreUsuario, String contrasena)
            throws CampoVacioException, CredencialesInvalidasException {

        if (nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            throw new CampoVacioException("Debe ingresar usuario y contraseña.");
        }

        Usuario usuario = usuarios.get(nombreUsuario);
///Si el usuario no es correcto
        if (usuario == null || !usuario.validarContrasena(contrasena)) {
            throw new CredencialesInvalidasException("Usuario o contraseña incorrectos.");
        }

        return usuario;
    }
}
