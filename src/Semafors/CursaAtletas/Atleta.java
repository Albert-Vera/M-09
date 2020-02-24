package Semafors.CursaAtletas;

public class Atleta extends Thread{
    Testimoni1 testimoni1;


    public Atleta(Testimoni1 t1, String nom) {
        super(nom);
        testimoni1 = t1;
    }

    @Override
    public void run() {
        for(;;) {
            //Agafa el testimoni
            testimoni1.Agafa();

            System.out.println(getName() + " Ha agafat el testimoni");
            //Corre amb el testmoni
            try {
                Thread.sleep((long) (Math.random()*3500)+3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Deixa el testimoni
            testimoni1.Deixa();
            //Descansa de tanta tele
            try {
                System.out.println(getName() + " Ha deixat el testimoni");
                Thread.sleep((long) (Math.random()*1000)+500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
