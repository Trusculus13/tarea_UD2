package ud2_practica;

// Clase principal del programa
public class HilosConcurrencia {

    public static void main(String[] args) {

    }

}

// Clase que implementa Runnable para definir la lógica del hilo
class MiHilo implements Runnable {

    private String nombre; // Variable para almacenar el nombre del hilo

    // Constructor que inicializa el nombre del hilo
    public MiHilo(String nombre) {
        this.nombre = nombre;
    }

    // Método que contiene la lógica que ejecutará cada hilo
    @Override
    public void run() {
        // Mensaje indicando el inicio del hilo
        System.out.println("Inicio del hilo: " + nombre);

        try {
            // Simula una actividad del hilo con una pausa aleatoria entre 0 y 1 segundo
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            // Maneja la interrupción del hilo
            System.out.println("El hilo " + nombre + " fue interrumpido.");
        }

        // Mensaje indicando la finalización del hilo
        System.out.println("Finalizacion del hilo: " + nombre);
    }
}
