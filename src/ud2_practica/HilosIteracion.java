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

    }

}
