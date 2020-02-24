package Fork_Join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Factorial extends RecursiveTask {
    int n;
    public Factorial(int n) {
        this.n = n;
    }

    @Override
    protected Object compute() {

        if (n < 25){
            System.out.println("Estic aqui");
            facSeq(n);
        }else{
            System.out.println( "Valor del else: " + facRec(n));
        }
        return null;
    }
    public void facSeq(double n){
        double resultat = 1;

        for (int i = 1; i <= n ; i++) {
            resultat =  resultat * (i);
            System.out.println(" Valor del sequencial: " + resultat);
        }

    }
    public double facRec( double n){

        if (n == 0){
            return 1;
        }
//        if (n < 25){
//            facSeq(n);
//        }
//        else{

            double resultat = n * facRec( n -1 );
            System.out.println("Valor Recursiu: " + n + " result: " + resultat);
            return resultat;
        //}
        //return 1;
    }

    public static void main(String[] args) {

        int numeroA = 320;
        int numeroB = 85;

        ForkJoinPool pool = new ForkJoinPool();
        Factorial task = new Factorial(50);
        pool.invoke(task);
        task.join();
    }
}
