import java.io.File;
import java.util.Scanner;

public class GestorDeArchivos {
    private static final Scanner sc = new Scanner(System.in);

    public void crearArchivo() {
        System.out.print("Escribe la ruta del directorio: ");
        String rutaDirectorio = sc.nextLine();
        File directorio = new File(rutaDirectorio);

        if (!directorio.exists() && !directorio.mkdirs()) {
            System.out.println("No se pudo crear el directorio.");
            return;
        }

        System.out.print("Nombre del archivo (sin extensión): ");
        String nombreArchivo = sc.nextLine();

        System.out.print("Formato de archivo (txt, docx, csv): ");
        String extensionArchivo = sc.nextLine();
        
        if (!extensionArchivo.startsWith(".")) {
            extensionArchivo = "." + extensionArchivo;
        }

        File archivo = new File(directorio, nombreArchivo + extensionArchivo);
        
        try (java.io.PrintWriter writer = new java.io.PrintWriter(archivo)) {
            System.out.println("Ingresa el contenido del archivo (escribe 'finclose' para terminar):");
            String linea;
            while (!(linea = sc.nextLine()).equalsIgnoreCase("finclose")) {
                writer.println(linea);
            }
            System.out.println("Archivo guardado en: " + archivo.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void leerArchivo() {
        System.out.print("Escribe la ruta completa del archivo: ");
        File archivo = new File(sc.nextLine());

        if (!archivo.exists() || !archivo.isFile()) {
            System.out.println("El archivo no existe o la ruta es incorrecta.");
            return;
        }

        try (Scanner fileScanner = new Scanner(archivo)) {
            System.out.println("Contenido del archivo:");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
