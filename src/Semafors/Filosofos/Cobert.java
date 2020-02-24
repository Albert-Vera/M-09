package Semafors.Filosofos;

public class Cobert {

    boolean forquillaLliure1 = true;
    boolean culleraLliure1 = true;
    boolean forquillaLliure2 = true;
    boolean culleraLliure2 = true;

    public synchronized void agafa(int filosof) {
        try {
            if (filosof == 1)
                while (true) {
                    if (forquillaLliure1) {
                        forquillaLliure1= false;
                        while (!culleraLliure1) wait();
                        culleraLliure1 = false;
                        break;
                    }
                }
            if (filosof == 2 ){
                while (true) {
                    if (forquillaLliure2) {
                        forquillaLliure2= false;
                        while (!culleraLliure1) wait();
                        culleraLliure1 = false;
                        break;
                    }
                }
            }

            if (filosof == 3 ){
                while (true) {
                    if (forquillaLliure2) {
                        forquillaLliure2 = false;
                        while (!culleraLliure2) wait();
                        culleraLliure2 = false;
                        break;
                    }
                }
            }

            if (filosof == 4 ){
                while (true) {
                    if (forquillaLliure1) {
                        forquillaLliure1= false;
                        while (!culleraLliure2) wait();
                        culleraLliure2 = false;
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notifyAll();
    }

    public synchronized void deixa(int filosof) {

        if (filosof == 1) {
            forquillaLliure1 = true;
            culleraLliure1 = true;
        }

        if (filosof == 2) {
            forquillaLliure2 = true;
            culleraLliure1 = true;
        }
        if (filosof == 3) {
            forquillaLliure2 = true;
            culleraLliure2 = true;
        }
        if (filosof == 4) {
            forquillaLliure1 = true;
            culleraLliure2 = true;
        }
        notifyAll();
    }
}
