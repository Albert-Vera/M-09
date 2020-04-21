package Examen_UF2.exercici_1;

/**
 * Exrecici 1
 * Clases  Processos (main), Recurs, ProcesAB
 *
 */

public class Recurs {

    int numeroProcesos_A, numeroProcesos_B;
    public Recurs() {
    }

    public synchronized void utilitzarRecurs(String name) throws InterruptedException {

        if (name.equals("proces_A")){
            while ( numeroProcesos_A < (numeroProcesos_B * 2) || numeroProcesos_B < 2 ) {
                System.out.println("proces A:  esperant ......");
                wait();
            }
            numeroProcesos_A++;
            notifyAll();
            System.out.println("entra un proces A numero de A: " +numeroProcesos_A);

        }else{
            numeroProcesos_B++;
            notifyAll();
            System.out.println("entra un proces B cantitat de B: " + numeroProcesos_B);
        }
        try {
            Thread.sleep((long) (Math.random() * 8000) + 1000);
        } catch (InterruptedException a) {
            a.printStackTrace();
        }
    }

    public synchronized void sortinProces(String name){

        if (name.equals("proces_A")){
            numeroProcesos_A --;
        }else numeroProcesos_B--;

        notifyAll();
    }
}
