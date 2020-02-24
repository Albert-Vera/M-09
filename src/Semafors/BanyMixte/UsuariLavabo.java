package Semafors.BanyMixte;

public class UsuariLavabo extends Thread{

    String sexe;
    Lavabo lavabo;

    public UsuariLavabo(String name, String sexe,Lavabo lavabo) {
        super(name);
        this.sexe = sexe;
        this.lavabo = lavabo;
    }

    public UsuariLavabo(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(true) {

            try {
                lavabo.entrar(sexe);
                System.out.println("entra en: " + getName());
                Thread.sleep((int) (Math.random() * 1000) + 500);
                lavabo.sortir(sexe);
                Thread.sleep((int) (Math.random() * 3000) + 500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
