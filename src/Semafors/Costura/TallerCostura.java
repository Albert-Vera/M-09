package Semafors.Costura;

public class TallerCostura {

    public static void main(String[] args) {

       // Cistell cistellManigas = new Cistell(8);
        Cistell cistell = new Cistell(12,8);
        Cosidor manigas = new Cosidor("CosidorManiga", cistell);
        Cosidor cosos = new Cosidor("CosidorCos", cistell );
        Cosidor jerseys = new Cosidor("CosidorJersey",cistell );

        manigas.start();
        cosos.start();
        jerseys.start();
    }

}
