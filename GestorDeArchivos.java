import java.util.ArrayList;
import java.util.Scanner;

public class GestorDeArchivos {
    private static final Scanner sc = new Scanner(System.in);
    private ArrayList<Archivo> archivos = new ArrayList<>();  // Lista para almacenar los archivos

    // Método para crear un archivo con contenido
    public void crearArchivo() {
        String rutaArchivo = "";
        boolean rutaValida = false;

        // Validación de la ruta del archivo (solo simulada)
        while (!rutaValida) {
            System.out.print("Escribe la ruta del archivo (ejemplo: C:\\Usuarios\\TuUsuario\\Documents\\): ");
            rutaArchivo = sc.nextLine();

            // Simulamos que la ruta siempre es válida
            System.out.println("Ruta aceptada: " + rutaArchivo);
            rutaValida = true;  // No verificamos realmente la existencia de la ruta en el sistema de archivos
        }

        System.out.print("Nombre del archivo (sin extensión): ");
        String nombreArchivo = sc.nextLine();

        String extensionArchivo = "";
        boolean tipoValido = false;

        // Validación del tipo de archivo
        while (!tipoValido) {
            System.out.print("Formato de archivo (txt, docx, csv): ");
            extensionArchivo = sc.nextLine();

            if (extensionArchivo.equalsIgnoreCase("txt") || extensionArchivo.equalsIgnoreCase("docx") || extensionArchivo.equalsIgnoreCase("csv")) {
                tipoValido = true;
            } else {
                System.out.println("Formato de archivo no válido. Por favor, elige entre txt, docx, o csv.");
            }
        }

        Archivo nuevoArchivo = new Archivo(rutaArchivo + nombreArchivo + "." + extensionArchivo);  // Crear archivo con ruta y nombre completo

        System.out.println("Ingresa el contenido del archivo (escribe 'finclose' para terminar):");
        String linea;
        while (!(linea = sc.nextLine()).equalsIgnoreCase("finclose")) {
            nuevoArchivo.agregarContenido(linea);
        }

        archivos.add(nuevoArchivo);

        System.out.println("Archivo " + nuevoArchivo.getNombre() + " guardado correctamente (simulado) en: " + nuevoArchivo.getRuta());
    }

    // Método para ver los archivos disponibles
    public void verArchivosDisponibles() {
        if (archivos.isEmpty()) {
            System.out.println("No hay archivos disponibles.");
            return;
        }

        System.out.println("Archivos disponibles:");
        for (int i = 0; i < archivos.size(); i++) {
            System.out.println((i + 1) + ". " + archivos.get(i).getNombre());
        }
    }

    // Método para leer el contenido de un archivo
    public void leerArchivo() {
        verArchivosDisponibles();
        System.out.print("Escribe el número del archivo que deseas ver: ");
        int opcion = sc.nextInt();
        sc.nextLine();  // Limpiar el buffer

        if (opcion < 1 || opcion > archivos.size()) {
            System.out.println("Opción no válida.");
            return;
        }

        Archivo archivoSeleccionado = archivos.get(opcion - 1);
        archivoSeleccionado.mostrarContenido();
    }
}
