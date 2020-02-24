package Semafors.Ascensor;

public class Edifici {

    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        Persona persona1 = new Persona("Elisabeth", 0, 3, ascensor);
        Persona persona2 = new Persona("Josep", 0, 6, ascensor);
        Persona persona3 = new Persona("Maria", 1, 0, ascensor);
        Persona persona4 = new Persona("Joan", 6, 2, ascensor);
        Persona persona5 = new Persona("Anna", 7, 3, ascensor);
        Motor motor = new Motor(ascensor);

        persona1.start();
        persona2.start();
        persona3.start();
        persona4.start();
        persona5.start();
        motor.start();

    }
}
