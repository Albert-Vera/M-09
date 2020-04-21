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

//        if (n <= 1)  return (long) n;
//        Fibonnaci f1 = new Fibonnaci(n - 1);
//        f1.fork();
//        Fibonnaci f2 = new Fibonnaci(n - 2);
//        f2.fork();
//        return f2.join() + f1.join();
        return 0;
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
        Fibonnaci task1 = new Fibonnaci(15);
        pool.invoke(task1);
         task1.join();

        for ( Integer result: fibonnaciList)
        System.out.println("Resultat: " + result);

    }
}
