package Examen_UF2.exercici2;

import Fork_Join.MaximTask;
import Fork_Join.SumaVector;

import java.lang.reflect.Array;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Albert Vera
 * Exrecici 1  iniciat , pero no li acabat
 * Clases  Processos (main), Recurs, ProcesAB
 *
 */
public class Exercici_2 extends RecursiveTask {

//    public static void main(String[] args) {
//
//
//        short[] data = createArray(100000);
//        int processadors = Runtime.getRuntime().availableProcessors();
//        ForkJoinPool pool = new ForkJoinPool(processadors);
//        BusquedaRecursiva tasca = new BusquedaRecursiva();
//
//
//
//    }
//
//    private int buscarMesGran(){
//
//
//    }
//
//    private static short[] createArray(int size) {
//        short[] ret = new short[size];
//        for (int i = 0; i < size; i++) {
//            ret[i] = (short) (1000 * Math.random());
//            if (i == ((short) (size * 0.9))) {
//                ret[i] = 1005;
//            }
//        }
//        return ret;
//    }

    @Override
    protected Object compute() {
        return null;
    }
}

