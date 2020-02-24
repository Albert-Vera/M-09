package Semafors.BanyMixte;

public class UtilitzarBany {
    public enum sexe{
        HOME,
        DONA
    }
    public static void main(String[] args) {
        Lavabo lavabo = new Lavabo();

        UsuariLavabo home1 = new UsuariLavabo("Albert", "mascle", lavabo);
        UsuariLavabo home2 = new UsuariLavabo("LLuis", "mascle", lavabo);
        UsuariLavabo home3 = new UsuariLavabo("Marc", "mascle", lavabo);
        UsuariLavabo home4 = new UsuariLavabo("Jaume", "mascle", lavabo);
        UsuariLavabo home5 = new UsuariLavabo("Joan", "mascle", lavabo);
        UsuariLavabo home6 = new UsuariLavabo("sdad", "mascle", lavabo);


        UsuariLavabo dona1 = new UsuariLavabo("Maria", "femella", lavabo);
        UsuariLavabo dona2 = new UsuariLavabo("Carme", "femella", lavabo);
        UsuariLavabo dona3 = new UsuariLavabo("Alba", "femella", lavabo);
        UsuariLavabo dona4 = new UsuariLavabo("Nathalie", "femella", lavabo);
        UsuariLavabo dona5 = new UsuariLavabo("Aisatha", "femella", lavabo);

        home1.start();
        home2.start();
        home3.start();
        home4.start();
        home5.start();

        dona1.start();
        dona2.start();
        dona3.start();
        dona4.start();
        dona5.start();
    }
}
