package fidness.modelo;
//Clase de usuario
public class Usuario {

    private String nombreUsuario;
    private String contrasena;

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean validarContrasena(String intento) {//Validar contraseña 
        return contrasena.equals(intento);
    }
}
