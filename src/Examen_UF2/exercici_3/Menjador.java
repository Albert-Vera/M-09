package Examen_UF2.exercici_3;

import java.util.concurrent.Callable;

/**
 * Albert Vera
 * Exrecici 3 pero mal·lament
 * Clases  Processos (main), Recurs, ProcesAB
 *
 */
public class Menjador implements Callable<Integer> {

    String nom;
    int cantitatOusParcial = 0;
    int cantitatOusTotal = 0;

    public Menjador(String nom) {
        this.nom = nom;
        this.cantitatOusParcial = cantitatOusParcial;
        this.cantitatOusTotal = cantitatOusTotal;
    }

    @Override
    public Integer call() throws Exception {
        return menjaOus();
    }

    public int menjaOus(){

        cantitatOusParcial ++;
        cantitatOusTotal ++;


        if (cantitatOusParcial == 4){
            cantitatOusParcial = 0;
            try {
                Thread.sleep((long) (Math.random()*2000)+2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return cantitatOusTotal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCantitatOusParcial() {
        return cantitatOusParcial;
    }

    public void setCantitatOusParcial(int cantitatOusParcial) {
        this.cantitatOusParcial = cantitatOusParcial;
    }

    public int getCantitatOusTotal() {
        return cantitatOusTotal;
    }

    public void setCantitatOusTotal(int cantitatOusTotal) {
        this.cantitatOusTotal = cantitatOusTotal;
    }
}
