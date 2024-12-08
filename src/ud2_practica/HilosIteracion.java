package ud2_practica;

import java.util.Random;

// Clase que implementa Runnable
class HiloConPausa implements Runnable {

    private final int idHilo; // Identificador único del hilo

    // Constructor que recibe el identificador del hilo
    public HiloConPausa(int idHilo) {
        this.idHilo = idHilo;
    }

    @Override
    public void run() {
        Random random = new Random(); // Generador de números aleatorios para las pausas

        // Bucle de 10 iteraciones
        for (int i = 1; i <= 10; i++) {
            try {
                // Generar una pausa aleatoria entre 500 y 1500 milisegundos
                int pausa = random.nextInt(1000) + 500;
                System.out.println("Hilo " + idHilo + " - Iteracion " + i + ": Pausa de " + pausa + " ms");

                // Simular la pausa haciendo que el hilo duerma por el tiempo generado
                Thread.sleep(pausa);
            } catch (InterruptedException e) {
                // Manejo de interrupciones durante la pausa del hilo
                System.err.println("Hilo " + idHilo + " interrumpido durante la pausa.");
                e.printStackTrace();
            }
        }

        // Mensaje final indicando que el hilo ha terminado su tarea
        System.out.println("Hilo " + idHilo + " ha terminado.");
    }
}

public class HilosIteracion {

    public static void main(String[] args) {
        // Cantidad de hilos a lanzar
        int numHilos = 5;

        // Arreglo para guardar las referencias a los hilos
        Thread[] hilos = new Thread[numHilos];

        // Mensaje inicial indicando que se inician los hilos
        System.out.println("Iniciando los hilos...");

        // Crear e iniciar los hilos
        for (int i = 0; i < numHilos; i++) {
            // Crear una nueva tarea que implementa la lógica del hilo
            Runnable tarea = new HiloConPausa(i + 1); // Se pasa un identificador único a cada hilo
            hilos[i] = new Thread(tarea); // Se envuelve la tarea en un objeto Thread
            hilos[i].start(); // Inicia la ejecución del hilo
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                // El hilo principal espera que cada hilo secundario complete su ejecución
                hilo.join();
            } catch (InterruptedException e) {
                // Manejo de interrupciones durante la espera
                System.err.println("Error al esperar la finalizacion de un hilo.");
                e.printStackTrace();
            }
        }

        // Mensaje final indicando que todos los hilos han terminado
        System.out.println("Todos los hilos han finalizado. Programa terminado.");
    }
}
