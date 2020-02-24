package Semafors.Ascensor;

public class Persona extends Thread {

    int origen, desti;
    Ascensor ascensor ;
    MonitorMotor monitorMotor= new MonitorMotor();

    public Persona(String name, int origen, int desti, Ascensor ascensor) {
        super(name);
        this.origen = origen;
        this.desti = desti;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        super.run();

        while (true) {
            try {

                ascensor.entrar(origen, getName());


                ascensor.sortir(desti, getName());

            } catch (InterruptedException e) {
                System.out.println(" error ");
                e.printStackTrace();
            }
        }

    }
}