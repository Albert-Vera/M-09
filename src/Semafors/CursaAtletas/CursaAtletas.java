package Semafors.CursaAtletas;

public class CursaAtletas {

    public static void main(String[] args) {

        Testimoni1 testimoni1 = new Testimoni1();
        Testimoni1 testimoni2 = new Testimoni1();

        Atleta santako_1 = new Atleta(testimoni1,  "SantaKo_1");
        Atleta santako_2 = new Atleta(testimoni1, "SantaKo_2");
        Atleta santako_3 = new Atleta(testimoni1,  "SantaKo_3");
        Atleta santAdria_1 = new Atleta(testimoni2,"santAdria_1");
        Atleta santAdria_2 = new Atleta(testimoni2, "santAdria_2");
        Atleta santAdria_3 = new Atleta(testimoni2, "santAdria_3");

        santAdria_1.start();
        santAdria_2.start();
        santAdria_3.start();
        santako_1.start();
        santako_2.start();
        santako_3.start();
    }

}
