package Fork_Join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MultiplicaTask extends RecursiveTask {
    private int a,b;
    public static final int LLINDAR = 999;

    public MultiplicaTask(int _a, int _b) {
        this.a = _a;
        this.b = _b;
    }

    // Mètode Rus recursiu
    private long metodeRus (){
        if (a == 1 ) return ((long) b);
        MultiplicaTask m1 = new MultiplicaTask( a/2, b + b);
        System.out.println(a/2 + "x" + (int)( b + b));
        m1.fork();

        if ( a % 2 != 0 ) return b + (long) m1.join();
        else return (long) m1.join();
    }

    //Multiplicar mitjaçant un sumatori
    private long metodeSuma() {
        long sum = 0;
        for(int i = 1;i <= a; i++)
            sum = sum + b;
        return sum;
    }
    @Override
    protected Long compute() {
        if(a > LLINDAR) return metodeRus();
        else return metodeSuma();
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        MultiplicaTask mult = new MultiplicaTask(5000,15);
        pool.invoke(mult);
        long result = (long) mult.join();
        System.out.println("Resultat:" + result);
    }
}
