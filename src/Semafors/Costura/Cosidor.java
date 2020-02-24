package Semafors.Costura;

public class Cosidor extends Thread {

    private Cistell cistell;
    private boolean lliure = true;

    public Cosidor(String name, Cistell cistell) {
        super(name);
        this.cistell = cistell;

    }


    @Override
    public void run() {
        super.run();

        for (;;) {
            try {
                cistell.agafar(getName());

                // slepp per temps
                try {
                    Thread.sleep((long) (Math.random() * 1000) + 1000);
                } catch (InterruptedException a) {
                    a.printStackTrace();
                }

                cistell.deixar(getName());

            }catch (InterruptedException r){
                System.out.println("s'ha prodüit un error");
            }

        }
    }
}
