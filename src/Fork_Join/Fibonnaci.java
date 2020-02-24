package Fork_Join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fibonnaci extends RecursiveTask {

    int n;
    int retornado = 0;
    int anterior1 = 1; int anterior2;
    int anterior = 0;
    private static List<Integer> fibonnaciList = new ArrayList<>();

    public Fibonnaci(List<Integer> fibonnaciList) {
        this.fibonnaciList = fibonnaciList;
    }

    public Fibonnaci(int n) {
        this.n = n;
    }

    List<Integer> seqFibonnaci(int n){

        for (int i = 0; i < n; i++) {

            if ( i > 1) {
                fibonnaciList.add(fibonnaciList.get(i-1) + fibonnaciList.get(i -2));
            }else {
                fibonnaciList.add(i);
            }
        }
        return fibonnaciList;
    }
    int recFibonnaci(int n){
//        anterior2 = anterior1;
//        anterior1 = anterior;

        if( n < 2){
           // anterior = n;
            System.out.println("recursive mode : " + n);

            return n;
        }else{

           // anterior = n;

            recFibonnaci(n-1);

            retornado = anterior + anterior1;
            anterior1 = retornado;
            anterior = anterior1;
            anterior2 = n-1 + n-2;

            System.out.println("recursive mode : " + retornado);
            return n;
        }

    }

    @Override
    protected Object compute() {

        if (n < 25) {
            return seqFibonnaci(n);
        }else{

            return  recFibonnaci(n);
        }
    }

    public static void main(String[] args) {


        ForkJoinPool pool = new ForkJoinPool();
        Fibonnaci task1 = new Fibonnaci(10);
        pool.invoke(task1);
         task1.join();

        for ( Integer result: fibonnaciList)
        System.out.println("Resultat: " + result);

    }
}
