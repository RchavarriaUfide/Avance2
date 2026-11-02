package fidness.vista;
//Imports
import fidness.excepciones.CampoVacioException;
import fidness.excepciones.CredencialesInvalidasException;
import fidness.modelo.Usuario;
import fidness.servicio.AutenticacionService;
import fidness.servicio.CatalogoEjercicios;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// Historia 1: Iniciar sesión.
public class LoginFrame extends JFrame {

    private AutenticacionService auth;
    private CatalogoEjercicios catalogo;

    private JTextField txtUsuario = new JTextField();
    private JPasswordField txtContrasena = new JPasswordField();
    private JButton btnIniciar = new JButton("Iniciar Sesion");
//Frame para el login
    public LoginFrame(AutenticacionService auth, CatalogoEjercicios catalogo) {
        this.auth = auth;
        this.catalogo = catalogo;

        setTitle("Fidness - Iniciar sesión");
        setSize(350, 330);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel logo = new JLabel("FIDNESS", SwingConstants.CENTER);
        logo.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));

        panel.add(logo);
        panel.add(new JLabel("Usuario"));
        panel.add(txtUsuario);
        panel.add(new JLabel("Contraseña"));
        panel.add(txtContrasena);
        panel.add(btnIniciar);

        add(panel);

        btnIniciar.addActionListener(e -> iniciarSesion());
    }

    private void iniciarSesion() {
        String usuario = txtUsuario.getText().trim();
        String contrasena = new String(txtContrasena.getPassword());

        try {
            Usuario u = auth.iniciarSesion(usuario, contrasena);

            new CatalogoFrame(u, auth, catalogo).setVisible(true);
            dispose();

        } catch (CampoVacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Campos vacíos", JOptionPane.WARNING_MESSAGE);
        } catch (CredencialesInvalidasException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Error de acceso", JOptionPane.ERROR_MESSAGE);
        }
    }
}
