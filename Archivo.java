import java.util.ArrayList;

public class Archivo {
    private String nombre;
    private String ruta;
    private ArrayList<String> contenido = new ArrayList<>();

    public Archivo(String ruta) {
        this.ruta = ruta;
        this.nombre = ruta.substring(ruta.lastIndexOf("\\") + 1);  // Obtener el nombre del archivo de la ruta
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void agregarContenido(String linea) {
        contenido.add(linea);
    }

    public void mostrarContenido() {
        System.out.println("Contenido del archivo " + nombre + ":");
        if (contenido.isEmpty()) {
            System.out.println("El archivo está vacío.");
        } else {
            for (String linea : contenido) {
                System.out.println(linea);
            }
        }
    }
}
