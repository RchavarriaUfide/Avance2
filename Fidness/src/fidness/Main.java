package fidness;
//Imports
import fidness.servicio.AutenticacionService;
import fidness.servicio.CatalogoEjercicios;
import fidness.vista.LoginFrame;
import javax.swing.SwingUtilities;

//Clase Main
public class Main {

    public static void main(String[] args) {
        AutenticacionService auth = new AutenticacionService(); //Objeto de autenticacion
        CatalogoEjercicios catalogo = new CatalogoEjercicios();//Objeto de catalogo

        SwingUtilities.invokeLater(() -> new LoginFrame(auth, catalogo).setVisible(true));//Swing para el GUI
    }
}
