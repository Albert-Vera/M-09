package Semafors.CursaAtletas;

public class Testimoni1 {
    private boolean lliure;

    public Testimoni1() {
        lliure = true;
    }

    public synchronized void Agafa() {
        try {
            while(!lliure) wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lliure = false;
        notifyAll();
    }

    public synchronized void Deixa() {
        lliure = true;
        notifyAll();
    }
}
