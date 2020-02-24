package Runable_Callable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client implements Runnable {

    private int id, preuTotal;
    private List<Integer> preus = new ArrayList<Integer>();


    public Client(int id, List<Integer> preu) {
        this.id = id;
        this.preus = new ArrayList<>(preu);
        this.preuTotal = preuTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getPreu() {
        return preus;
    }

    public void setPreu(int preu) {
        this.preus = Collections.singletonList(preu);
    }

    public int getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(int preuTotal) {
        this.preuTotal = preuTotal;
    }

    @Override
    public void run() {
        caixa(preus);
    }

    void caixa(List<Integer> preu){
        preuTotal = calcular(preus, preuTotal);
        System.out.println( " Caixa : " + id + "  Import Total de la compra es: " + preuTotal);
    }

    int calcular(List<Integer> preus, int preuTotal){

        for (Integer preu : preus) {
            preuTotal += preu;
        }
        return preuTotal;
    }
}
