package Dam_M_09.claus;

import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextAmagat {
    public static void main(String[] args) throws IOException {

        File leerFile = new File("C:\\Users\\usuario\\IdeaProjects\\M_09\\src\\Dam_M_09\\claus\\ClausA4.txt");
        BufferedReader inputStream = new BufferedReader(new FileReader(leerFile));
        String line;

        while ((line = inputStream.readLine()) != null && !line.isEmpty()) {
            try {
                Path path = Paths.get("C:\\Users\\usuario\\IdeaProjects\\M_09\\src\\Dam_M_09\\claus\\textamagat.dat");
                byte[] textenbytes = Files.readAllBytes(path);
                System.out.println("\nPassword:  " + line);
                SecretKey pass = CodisClaus.passwordKeyGeneration(line, 128);
                byte[] decodificat = CodisClaus.decryptData(pass, textenbytes);
                String textDecodificat = new String(decodificat, "UTF8");
                System.out.println("Password CORRECTO :  " + textDecodificat);
            }catch(NullPointerException bi){
                System.out.println("     la cagamos");
            }
        }
        inputStream.close();
    }
}
