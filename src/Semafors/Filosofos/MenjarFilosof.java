package Semafors.Filosofos;

public class MenjarFilosof {


    public static void main(String[] args) {


        Filosof Andreu = new Filosof("X", 1);
        Filosof Joan = new Filosof("OI", 2);
        Filosof Maria = new Filosof("XI", 3);
        Filosof Anna = new Filosof( "O", 4);
        Andreu.start();
        Joan.start();
        Maria.start();
        Anna.start();
    }
}

