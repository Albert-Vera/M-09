package Semafors.Filosofos;

public class Filosof extends Thread {

    Cobert cobert = new Cobert();
    int filosof ;

    public Filosof(String name, int filosof) {
        super(name);
        this.filosof = filosof;
    }

    @Override
    public void run() {
        super.run();

        while(true) {
            cobert.agafa(filosof);

            System.out.println(getName() + "  Ara es hora jalar...");
            // slepp per temps que pasa menjant
            try {
                Thread.sleep((long) (Math.random() * 3500) + 3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Deixa els coberts
            cobert.deixa(filosof);
            //Es posa a pensar
            try {
               // System.out.println(getName() + " Ara vaig a pensar una miqueta");
                Thread.sleep((long) (Math.random() * 1000) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
