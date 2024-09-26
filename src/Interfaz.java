import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // trim() elimina los espacios en blanco al inicio y final de una cadena

            // Pedida de datos:
            System.out.println("Introduce el comando a ejecutar ('notepad.exe'/'kwrite'): ");
            String comando = sc.nextLine().trim();
            System.out.println("Introduce los parámetros del comando: ");
            String parametros = sc.nextLine().trim();

            String[] argsEjecutor = parametros.isEmpty() ? new String[]{comando} : (comando + " " + parametros).split(" ");

            // Usando un StringBuilder para construir el comando completo
            StringBuilder comandoCompleto = new StringBuilder();
            for (int i = 0; i < argsEjecutor.length; i++) {
                comandoCompleto.append(argsEjecutor[i]);
                if (i < argsEjecutor.length - 1) {
                    comandoCompleto.append(" ");
                }
            }

            // Muestra mensaje de inicio
            System.out.println("Ejecutando el comando: " + comandoCompleto.toString());

            // Llama a la clase Ejecutor para ejecutar el comando
            Ejecutor ejecutor = new Ejecutor();
            int resultado = ejecutor.ejecutarComando(argsEjecutor);

            // Mensaje resultado, si saltan los excepcion sera -1
            if (resultado == 0) {
                System.out.println("El proceso finalizó correctamente.");
            } else {
                System.out.println("Se produjo un error. Código de salida: " + resultado);
            }

        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}
