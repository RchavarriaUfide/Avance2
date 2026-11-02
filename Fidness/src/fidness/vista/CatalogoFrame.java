package fidness.vista;
//Imports
import fidness.modelo.Ejercicio;
import fidness.modelo.Usuario;
import fidness.servicio.AutenticacionService;
import fidness.servicio.CatalogoEjercicios;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

// Historia 3: Filtrar catálogo por tipo e Historia 9: Cerrar sesión.
//Frame para el catalogo
public class CatalogoFrame extends JFrame {

    private Usuario usuario;
    private AutenticacionService auth;
    private CatalogoEjercicios catalogo;

    private JComboBox<String> cmbTipo;
    private JPanel panelLista = new JPanel(new GridLayout(0, 2, 10, 10));

    public CatalogoFrame(Usuario usuario, AutenticacionService auth, CatalogoEjercicios catalogo) {
        this.usuario = usuario;
        this.auth = auth;
        this.catalogo = catalogo;

        setTitle("Fidness - Catálogo de ejercicios (" + usuario.getNombreUsuario() + ")");
        setSize(480, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Exit on close, sin esto se me cerraba el software cuando cerraba sub ventanas
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Filtro por tipo
        cmbTipo = new JComboBox<>(catalogo.getTipos());
        JPanel panelFiltro = new JPanel(new FlowLayout());
        panelFiltro.add(new JLabel("Filtros - Tipo:"));
        panelFiltro.add(cmbTipo);
        add(panelFiltro, BorderLayout.NORTH);

        //Lista de ejercicios
        panelLista.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.add(panelLista, BorderLayout.NORTH);
        add(new JScrollPane(contenedor), BorderLayout.CENTER);

        //Barra de botones del prototipo
        add(crearBarraInferior(), BorderLayout.SOUTH);

        cmbTipo.addActionListener(e -> cargarEjercicios());
        cargarEjercicios();
    }

    private void cargarEjercicios() {
        String tipo = (String) cmbTipo.getSelectedItem();
        List<Ejercicio> lista = catalogo.filtrarPorTipo(tipo);

        panelLista.removeAll();

        if (lista.isEmpty()) {//Esto como ejemplo, en este ejercicio no se daria este caso porque ya estan los ejercicios precargados
            panelLista.add(new JLabel("No hay ejercicios disponibles"));
        }

       
        for (Ejercicio ej : lista) {
            JButton btn = new JButton("<html><center>" + ej.getNombre()
                    + "<br>(" + ej.getTipo() + ")</center></html>");
            btn.setPreferredSize(new Dimension(180, 80));
            btn.addActionListener(e -> new DetalleEjercicioDialog(this, ej).setVisible(true));
            panelLista.add(btn);
        }

        panelLista.revalidate();
        panelLista.repaint();
    }

    private JPanel crearBarraInferior() {
        JPanel barra = new JPanel(new GridLayout(1, 4));

        JButton btnRutinas = new JButton("Mis rutinas");
        JButton btnCrear = new JButton("Crear rutina");
        JButton btnRegistrar = new JButton("Registrar Ejercicio");
        JButton btnSalir = new JButton("Salir");

        //Los botones bajos que por ahora no hacen nada
        btnRutinas.addActionListener(e -> avisoProximoAvance());
        btnCrear.addActionListener(e -> avisoProximoAvance());
        btnRegistrar.addActionListener(e -> avisoProximoAvance());
        btnSalir.addActionListener(e -> cerrarSesion());

        barra.add(btnRutinas);
        barra.add(btnCrear);
        barra.add(btnRegistrar);
        barra.add(btnSalir);
        return barra;
    }
//Nota si se cliquea una de las opciones aun no presentes
    private void avisoProximoAvance() {
        JOptionPane.showMessageDialog(this, "Disponible en el próximo avance.");
    }

    //Historia 9.
    private void cerrarSesion() {
        new LoginFrame(auth, catalogo).setVisible(true);
        dispose();
    }
}
