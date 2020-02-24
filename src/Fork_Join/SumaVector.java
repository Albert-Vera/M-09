package Fork_Join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumaVector extends RecursiveTask {

    int[] data = {1,2,40,500,505,34,56,987,1009,2345,67,0,345};

    int metodeSuma (){
        int suma = 0;

        for (int i = 0; i < data.length; i++) {
            suma += data[i];
            System.out.println("suma : " +suma);
        }
        return suma;
    }


    @Override
    protected Object compute() {

        return metodeSuma();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        SumaVector sumaVector = new SumaVector();
        pool.invoke (sumaVector) ;
        int resultat = (int) sumaVector.join();
        System.out.println("Resultat Total: " + resultat);
    }
}
