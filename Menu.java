import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            GestorDeArchivos gestor = new GestorDeArchivos();

        while (true) {
            System.out.println("---- GESTIONADOR DE ARCHIVOS ----");
            System.out.println("1. Crear archivo nuevo");
            System.out.println("2. Ver contenido de un archivo");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    gestor.crearArchivo();
                    break;
                case 2:
                    gestor.leerArchivo();
                    break;
                case 3:
                    System.out.println("Programa finalizado.");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
        
    }
}
