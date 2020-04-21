package Examen_UF2.exercici_1;
/**
 * Albert Vera
 * Exrecici 1
 * Clases  Processos (main), Recurs, ProcesAB
 *
 */
public class ProcesAB extends Thread {
    Recurs recurs ;
    public ProcesAB(String name, Recurs recurs) {
        super(name);
        this.recurs = recurs;
    }


    @Override
    public void run() {
        super.run();


        for (;;) {
            try {

                recurs.utilitzarRecurs(getName());

                System.out.println("proces sortin: " + getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            recurs.sortinProces(getName());


        }
    }
}
