package fidness.servicio;
//Imports
import fidness.modelo.Ejercicio;
import fidness.modelo.EjercicioBrazo;
import fidness.modelo.EjercicioEspalda;
import fidness.modelo.EjercicioPierna;
import java.util.ArrayList;
import java.util.List;

public class CatalogoEjercicios {

    //Coleccion de ejercicios.
    private List<Ejercicio> ejercicios = new ArrayList<>();

    public CatalogoEjercicios() {
        //Ejercicios de prueba precargados
        ejercicios.add(new EjercicioPierna(1, "Sentadilla",
                "1. Pies al ancho de los hombros.\n2. Baja las caderas como si te sentaras.\n3. Mantén la espalda recta.\n4. Sube empujando con los talones.",
                "https://fidness.com/videos/sentadilla"));
        ejercicios.add(new EjercicioPierna(2, "Zancada",
                "1. Da un paso largo al frente.\n2. Baja hasta que ambas rodillas formen 90 grados.\n3. Empuja con el pie delantero para volver.",
                "https://fidness.com/videos/zancada"));
        ejercicios.add(new EjercicioPierna(3, "Prensa de pierna",
                "1. Siéntate en la máquina con la espalda apoyada.\n2. Empuja la plataforma sin bloquear las rodillas.\n3. Regresa de forma controlada.",
                "https://fidness.com/videos/prensa"));
        ejercicios.add(new EjercicioEspalda(4, "Remo con mancuerna",
                "1. Apoya una rodilla y una mano en el banco.\n2. Jala la mancuerna hacia la cadera.\n3. Baja lentamente.",
                "https://fidness.com/videos/remo"));
        ejercicios.add(new EjercicioEspalda(5, "Dominadas",
                "1. Agarra la barra con las palmas al frente.\n2. Sube hasta que el mentón pase la barra.\n3. Baja con control.",
                "https://fidness.com/videos/dominadas"));
        ejercicios.add(new EjercicioEspalda(6, "Jalón al pecho",
                "1. Siéntate y sujeta la barra ancha.\n2. Jala la barra hacia el pecho.\n3. Regresa despacio.",
                "https://fidness.com/videos/jalon"));
        ejercicios.add(new EjercicioBrazo(7, "Curl de bíceps",
                "1. De pie, con una mancuerna en cada mano.\n2. Flexiona los codos subiendo las mancuernas.\n3. Baja sin balancear el cuerpo.",
                "https://fidness.com/videos/curl"));
        ejercicios.add(new EjercicioBrazo(8, "Fondos de tríceps",
                "1. Apoya las manos en un banco detrás de ti.\n2. Baja flexionando los codos.\n3. Sube extendiendo los brazos.",
                "https://fidness.com/videos/fondos"));
    }
//Listar todos los ejercicios
    public List<Ejercicio> listarTodos() {
        return new ArrayList<>(ejercicios);
    }

    // Devuelve solo los ejercicios del tipo indicado y si se elige todos, muestra todos.
    public List<Ejercicio> filtrarPorTipo(String tipo) {
        if (tipo.equals("Todos")) {
            return listarTodos();
        }

        List<Ejercicio> resultado = new ArrayList<>();
        for (Ejercicio e : ejercicios) {
            if (e.getTipo().equals(tipo)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public String[] getTipos() {
        return new String[]{"Todos", "Pierna", "Espalda", "Brazo"};
    }
}
