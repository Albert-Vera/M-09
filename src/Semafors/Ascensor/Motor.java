package Semafors.Ascensor;

public class Motor extends Thread{
//    motor li paso la ascensor
MonitorMotor monitorMotor = new MonitorMotor();
    int planta = 0;
    Ascensor ascensor;

    public Motor(Ascensor ascensor) {
        this.planta = planta;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {

                Thread.sleep((long) (Math.random() * 3000) + 1000);

                monitorMotor.mover();

            } catch (InterruptedException a) {
                a.printStackTrace();
            }
        }
    }
}
