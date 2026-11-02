package fidness.vista;
//Import
import fidness.modelo.Ejercicio;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

//Historia 5: Ver detalle del ejercicio.
public class DetalleEjercicioDialog extends JDialog {

    public DetalleEjercicioDialog(JFrame padre, Ejercicio ejercicio) {
        super(padre, "Detalles de ejercicio", true);
        setSize(420, 480);
        setLocationRelativeTo(padre);
        setLayout(new BorderLayout());

        JButton btnRegresar = new JButton("← Regresar al catálogo");
        btnRegresar.addActionListener(e -> dispose());

        JLabel titulo = new JLabel("DETALLES DE EJERCICIO", SwingConstants.CENTER);

        JTextArea txtDetalles = new JTextArea(ejercicio.mostrarDetalles());
        txtDetalles.setEditable(false);
        txtDetalles.setLineWrap(true);
        txtDetalles.setWrapStyleWord(true);
        txtDetalles.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(titulo, BorderLayout.NORTH);
        add(new JScrollPane(txtDetalles), BorderLayout.CENTER);
        add(btnRegresar, BorderLayout.SOUTH);
    }
}
