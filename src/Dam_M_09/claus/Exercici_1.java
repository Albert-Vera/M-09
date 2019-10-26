package Dam_M_09.claus;

import javax.crypto.BadPaddingException;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Scanner;


public class Exercici_1 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String textClau ="Benvingut a casa";
        String paraulaClau= "Disabte";
        ambClau(textClau);
        System.out.println("######################################");
        ambParaulaPass(paraulaClau, textClau);
    }

    static void ambClau(String textClau) throws UnsupportedEncodingException {
        SecretKey clauSecreta = CodisClaus.encrytingData(128);
        byte[] textABytes= textClau.getBytes("UTF8");
        byte[] encriptat = CodisClaus.encryptData(clauSecreta,textABytes);
        byte[] decodificat = CodisClaus.decryptData(clauSecreta,encriptat);
        String textDecodificat = new String(decodificat,"UTF8");
        System.out.println(textDecodificat);
    }

    static void ambParaulaPass(String paraulaClau, String textClau) throws UnsupportedEncodingException{

        Scanner in = new Scanner(System.in);
        byte[] textABytes= textClau.getBytes("UTF8");
        SecretKey passtext = CodisClaus.passwordKeyGeneration(paraulaClau, 128);
        byte[] encriptat = CodisClaus.encryptData(passtext,textABytes);
        System.out.print("\n   Introdueix la clau per poder desincriptar :   " );
        String acceso = in.nextLine();
        SecretKey pass = CodisClaus.passwordKeyGeneration(acceso, 128);
        byte[] decodificat = CodisClaus.decryptData(pass,encriptat);
        String textDecodificat = new String(decodificat,"UTF8");
        System.out.println("   " + textDecodificat);

        String dsad= passtext.getAlgorithm();
        String dsa = passtext.getFormat();
        System.out.println("\n  Codificat amb : " + dsad + "   Format:  " +dsa);
    }
}
