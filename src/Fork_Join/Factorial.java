package Fork_Join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Factorial ejemplo
 * De 4 es 24 (4 x 3 x 2 x 1)
 */
public class Factorial extends RecursiveTask<Long> {
    private int n;
    public static final int LLINDAR = 10;

    public Factorial(int _n) {
        n = _n;
    }

    private Long factorialR() {
        // no cal comprovar per n=1 perquè ja ho fa el seqüencial
        Factorial f1 = new Factorial(n-1);
        f1.fork();
        return f1.join() * n;
    }

    private Long factorialS() {
        if(n==1) return (long)1;
        else {
            long temp = 1;
            for(int i=1; i<=n; i++) {
                temp = temp * i;
            }
            return temp;
        }
    }

    @Override
    protected Long compute() {
        if(n < LLINDAR) return factorialS();
        else return factorialR();

    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Factorial factorial = new Factorial(4);
        pool.invoke(factorial);
        Long result2 = factorial.join();

        System.out.println(result2);
    }
}
