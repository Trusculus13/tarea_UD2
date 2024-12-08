package ud2_practica;

// Clase principal del programa
public class HilosConcurrencia {

    public static void main(String[] args) {
        // Define el número de hilos que se van a crear
        int numeroDeHilos = 5;

        // Crea un arreglo para almacenar los hilos que se van a iniciar
        Thread[] hilos = new Thread[numeroDeHilos];

        // Bucle para crear y arrancar los hilos
        for (int i = 0; i < numeroDeHilos; i++) {
            // Asigna un nombre único a cada hilo
            String nombreHilo = "Hilo " + (i + 1);

            // Crea una instancia de MiHilo (implementación de Runnable) con el nombre del hilo
            MiHilo miHilo = new MiHilo(nombreHilo);

            // Crea un hilo asociado a la instancia de MiHilo y lo almacena en el arreglo
            hilos[i] = new Thread(miHilo);

            // Inicia la ejecución del hilo
            hilos[i].start();
        }

        // Bucle para esperar que todos los hilos terminen su ejecución
        for (int i = 0; i < numeroDeHilos; i++) {
            try {
                // join() asegura que el programa principal espere la finalización de este hilo
                hilos[i].join();
            } catch (InterruptedException e) {
                // Maneja la interrupción del hilo principal
                System.out.println("El hilo principal fue interrumpido.");
            }
        }

        // Mensaje que indica que todos los hilos han finalizado su ejecución
        System.out.println("Todos los hilos han terminado su ejecucion.");
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
