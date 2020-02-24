package Semafors.BanyMixte;

public class Lavabo {
    volatile int totalHomes ;
    volatile int totalDones ;

    boolean disponibleHomes = true;
    boolean disponibleDones = true;


    public synchronized void entrar(String sexe) throws InterruptedException {


        if (sexe.equalsIgnoreCase("mascle")){
            while (!disponibleHomes ) wait();
            disponibleDones = false;

            totalHomes++;
            notifyAll();
            System.out.println("entra home i som : " + totalHomes + "     total dones dins: " + totalDones);
        }else {
            while (!disponibleDones ) {
                System.out.println("dona esperant -.....");
                wait();
            }
            disponibleHomes = false;
            totalDones ++;
            notifyAll();
            System.out.println("entra dona i som : " + totalDones + "      total homes dins: " +totalHomes);

        }

        if (totalHomes == 4 ) {
            disponibleHomes = false;
        }
        if (totalDones == 4 ){
            disponibleDones = false;
        }



    }
    synchronized void sortir(String sexe){
        if (sexe.equalsIgnoreCase("mascle")){
            totalHomes--;
            if (totalHomes == 0) {
                System.out.println("NO QUEDEN HOMES");
                disponibleDones = true;
                disponibleHomes = true;
                notifyAll();
                try {
                    Thread.sleep((int) (Math.random() * 8000) + 500);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("HOME sortin");
        }else {
            totalDones--;
            if (totalDones == 0){
                disponibleHomes= true;
                disponibleDones= true;
                notifyAll();            }
            System.out.println("DONA sortin");

        }
    }

}
