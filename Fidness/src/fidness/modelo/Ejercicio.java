package fidness.modelo;

//Clase Padre para los otros ejercicios.
public abstract class Ejercicio {

    private int id;//Id del ejercicio
    private String nombre;//Nombre del ejercicio
    private String instrucciones;//Instrucciones del ejercicio
    private String urlVideo;//URL del video, como nota, se que el prototipo dice video, pero en retrospectiva eso solo lo complicaria mucho por lo que decidi referenciar un URL para un potencial sitio web del app

    public Ejercicio(int id, String nombre, String instrucciones, String urlVideo) {
        this.id = id;
        this.nombre = nombre;
        this.instrucciones = instrucciones;
        this.urlVideo = urlVideo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    // Cada subclase decide su propio tipo y músculos.
    public abstract String getTipo();

    public abstract String getMusculosTrabajados();

    //El resultado cambia segun la clase.
    public String mostrarDetalles() {
        return "Nombre: " + nombre + "\n"
                + "Tipo: " + getTipo() + "\n"
                + "Músculos: " + getMusculosTrabajados() + "\n\n"
                + "Video: " + urlVideo + "\n\n"
                + "Instrucciones:\n" + instrucciones;
    }
}
