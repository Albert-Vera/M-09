package Semafors.Ascensor;


public class Ascensor {
    volatile int planta= 0 ;
    int origen, desti;
    boolean subiendo = true;


    public Ascensor() {
    }

    public Ascensor(int origen, int desti) {
        this.origen = origen;
        this.desti = desti;
    }


    public synchronized void entrar(int origen, String name) throws InterruptedException {

        while (planta != origen) {

            System.out.println("toy esperando: " + planta + " nombre: " + name + " origen " + origen );
            wait();
        }
        System.out.println(name + " ENTRAR a la ascensor");
        notifyAll();
    }

    public synchronized void sortir(int desti, String name) throws InterruptedException {

        while (planta != desti) {
            System.out.println("soy : " + name +" y estoy esperando para salir en destino: " + desti+  " ahora estoy en planta  " +
                    "" + planta);
            wait();
        }
        System.out.println(name + " SURT del ascensor");

        notifyAll();
    }




}
