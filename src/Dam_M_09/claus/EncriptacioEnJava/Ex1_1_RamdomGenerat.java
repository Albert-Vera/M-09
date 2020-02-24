package Dam_M_09.claus.EncriptacioEnJava;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

// PROGRAMA QUE GENERA DUES CLAUS ALEATORIAS, CODIFICA I DESCODIFICAR UN TEXT INTROUIT

public class Ex1_1_RamdomGenerat {
    public static void main(String[] args) throws UnsupportedEncodingException {

        Scanner sc = new Scanner(System.in);
        KeyPair claus = randomGenerate(1024);

        System.out.print("Introdueix un text clar per ser codificat:  ");
        String text = sc.nextLine();
        byte[] textenBytes = text.getBytes("UTF8");
        byte[] textEncryptat = encryptData(textenBytes, claus.getPublic());
        byte[] textDescriptat = dencryptData(textEncryptat,claus.getPrivate());
        String textDecod = new String(textDescriptat, "UTF8");// PASAR DE BYTES A STRING
        System.out.println("Text un cop ja descodificat:   " + textDecod + "\n\n");

        System.out.println("         ###########     AQUESTA ES LA CLAU PRIVADA    ############### ");
        System.out.println(claus.getPrivate() );
        System.out.println("                                  --------- " );
        System.out.println("         ###########     AQUESTA ES LA CLAU PRIVADA    ############### ");
        System.out.println(claus.getPublic());
    }

    public static KeyPair randomGenerate(int len) {
        KeyPair keys = null;
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(len);
            keys = keyGen.genKeyPair();
        } catch (Exception ex) {
            System.err.println("Generador no disponible.");
        }
        return keys;
    }

    public static byte[] encryptData(byte[] data, PublicKey pub) {
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.ENCRYPT_MODE, pub);
            encryptedData =  cipher.doFinal(data);
        } catch (Exception  ex) {
            System.err.println("Error xifrant: " + ex);
        }
        return encryptedData;
    }

    public static byte[] dencryptData(byte[] data, PrivateKey pub) {
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.DECRYPT_MODE, pub);
            encryptedData =  cipher.doFinal(data);
        } catch (Exception  ex) {
            System.err.println("Error xifrant: " + ex);
        }
        return encryptedData;
    }
}
