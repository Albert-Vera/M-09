package Semafors.Ascensor;

public class MonitorMotor {
    Ascensor ascensor = new Ascensor();
    boolean subiendo = true;

    public synchronized void mover(){


        if (ascensor.planta < 8 && ascensor.subiendo) {
            ascensor.planta++;

            if (ascensor.planta == 7) ascensor.subiendo = false;
            System.out.println("Soy Motor y SUBO planta: " + ascensor.planta+ "  subiendo: " + ascensor.subiendo);
            notifyAll();
        }


        if (ascensor.planta >= 0 && !ascensor.subiendo) {
            ascensor.planta--;

            System.out.println("Soy Motor y BAJO planta: " + ascensor.planta);

            if (ascensor.planta == 0) ascensor.subiendo = true;
            notifyAll();
        }

    }
}
