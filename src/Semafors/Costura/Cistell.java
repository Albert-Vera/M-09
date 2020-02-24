package Semafors.Costura;

public class Cistell {
    private int unitatsManigas ;
    private int unitatsCos ;
    private final int maxManigas = 12;
    private final int maxCosos = 12;
    private final int minManigas = 2;
    private final int minCosos = 1;

    public Cistell() {
    }

    public Cistell(int cistellManiga, int cistellCos) {
        this.unitatsManigas = cistellManiga;
        this.unitatsCos = cistellCos;
        System.out.println("construbcrtor: " + unitatsManigas + " jkjkj  " + unitatsCos);

    }

    public int getUnitatsManigas() {
        return unitatsManigas;
    }

    public void setUnitatsManigas(int unitatsManigas) {
        this.unitatsManigas = unitatsManigas;
    }

    public int getUnitatsCos() {
        return unitatsCos;
    }

    public void setUnitatsCos(int unitatsCos) {
        this.unitatsCos = unitatsCos;
    }

    public synchronized void agafar(String name) throws InterruptedException {

        if (name.equals("CosidorJersey")) {

            while ((getUnitatsManigas() < minManigas) || ( getUnitatsCos() < minCosos) ) wait();
            setUnitatsManigas(getUnitatsManigas() -2);
            setUnitatsCos(getUnitatsCos()-1);
            System.out.println("\nAgafo manigas: " + getUnitatsManigas());
            System.out.println("Agafo cos: " + getUnitatsCos());
            System.out.println("Un jersey més");
            notifyAll();
        }
    }

    public synchronized void deixar(String name) throws InterruptedException {

        if (name.equals("CosidorManiga")) {
            while (getUnitatsManigas() > maxManigas) wait();

            setUnitatsManigas(getUnitatsManigas() +1 );
            System.out.println("\nDeixo Maniga : " + getUnitatsManigas());
            notifyAll();
        }
        if (name.equals("CosidorCos")){

            while (getUnitatsCos() > maxCosos) wait();
            setUnitatsCos(getUnitatsCos() +1);
            System.out.println("\nDeixo cos: " + getUnitatsCos());
            notifyAll();
        }

    }
}
