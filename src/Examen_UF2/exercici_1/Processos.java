package Examen_UF2.exercici_1;

/**
 * Albert Vera
 * Exrecici 1
 * Clases  Processos (main), Recurs, ProcesAB
 *
 */
public class Processos {

    public static void main(String[] args) {


       // ProcesAB[] pro_A;  // i intentat un array de processos pero no pirula

       // for (int i = 0; i < 20 ; i++) {

        Recurs recurs = new Recurs();
            ProcesAB pro_A1 = new ProcesAB("proces_A", recurs);
            ProcesAB pro_A2 = new ProcesAB("proces_A", recurs);
            ProcesAB pro_A3 = new ProcesAB("proces_A", recurs);
            ProcesAB pro_A4 = new ProcesAB("proces_A", recurs);
            ProcesAB pro_A5 = new ProcesAB("proces_A", recurs);
            ProcesAB pro_A6 = new ProcesAB("proces_A", recurs);
            ProcesAB pro_A7 = new ProcesAB("proces_A", recurs);
            ProcesAB pro_A8 = new ProcesAB("proces_A", recurs);

            ProcesAB pro_B1 = new ProcesAB("proces_B", recurs);
            ProcesAB pro_B2 = new ProcesAB("proces_B", recurs);
            ProcesAB pro_B3 = new ProcesAB("proces_B", recurs);
            ProcesAB pro_B4= new ProcesAB("proces_B", recurs);
            ProcesAB pro_B5 = new ProcesAB("proces_B", recurs);
            ProcesAB pro_B6 = new ProcesAB("proces_B", recurs);
            ProcesAB pro_B7 = new ProcesAB("proces_B", recurs);
            ProcesAB pro_B8 = new ProcesAB("proces_B", recurs);
            ProcesAB pro_B9= new ProcesAB("proces_B", recurs);

      //  }
        pro_A1.start();
        pro_A2.start();
        pro_A3.start();
        pro_A4.start();
        pro_A5.start();
        pro_A6.start();
        pro_A7.start();
        pro_A8.start();

        pro_B1.start();
        pro_B2.start();
        pro_B3.start();
        pro_B4.start();
        pro_B5.start();
        pro_B6.start();
        pro_B7.start();
        pro_B8.start();
        pro_B9.start();

    }
}
