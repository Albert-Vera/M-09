package Dam_M_09.claus;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextAmagat {
    public static void main(String[] args) throws IOException {


        String pass=llegirFitxerPassword();
        //CodisClaus.decryptData(pass,textenbytes);
    }

    static String llegirFitxerPassword() throws IOException {

        File leerFile = new File("C:\\Users\\usuario\\IdeaProjects\\M_09\\src\\Dam_M_09\\claus\\ClausA4.txt");
        BufferedReader inputStream = new BufferedReader(new FileReader(leerFile));
        String line;
        String pass="jk";
//        Path path = Paths.get("C:\Users\usuario\IdeaProjects\M_09\src\Dam_M_09\claus\textamagat.dat");
        FileInputStream lecturaData = new FileInputStream("C:\\Users\\usuario\\IdeaProjects\\M_09\\src\\Dam_M_09\\claus\\textamagat.dat");
        DataInputStream datos = new DataInputStream(lecturaData);
        byte[] textenbytes = datos.readAllBytes();

        while((line = inputStream.readLine()) != null && !line.isEmpty()) {
            System.out.println(line + " ");

            byte[] decodificat = CodisClaus.decryptData((line,textenbytes));

            String textDecodificat = new String(decodificat,"UTF8");
            System.out.println("   " + textDecodificat);
        }
        inputStream.close();
        return pass;
    }
}


//
//    byte[] textABytes= textClau.getBytes("UTF8");
//    SecretKey passtext = CodisClaus.passwordKeyGeneration(paraulaClau, 128);
//    byte[] encriptat = CodisClaus.encryptData(passtext,textABytes);
//        System.out.print("\n   Introdueix la clau per poder desincriptar :   " );
//                String acceso = in.nextLine();
//                SecretKey pass = CodisClaus.passwordKeyGeneration(acceso, 128);
//                byte[] decodificat = CodisClaus.decryptData(pass,encriptat);
//                String textDecodificat = new String(decodificat,"UTF8");
//                System.out.println("   " + textDecodificat);
//
//                String dsad= passtext.getAlgorithm();
//                String dsa = passtext.getFormat();
//                System.out.println("\n  Codificat amb : " + dsad + "   Format:  " +dsa);