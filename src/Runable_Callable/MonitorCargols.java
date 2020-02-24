package Runable_Callable;

public class MonitorCargols implements Runnable{
    private Cargol cargol;

    public MonitorCargols(Cargol c) {
        cargol = c;
    }

    @Override
    public void run() {
        System.out.println(cargol.getNom()  + " acumula " + cargol.getMetres() + " metres");
    }

}
