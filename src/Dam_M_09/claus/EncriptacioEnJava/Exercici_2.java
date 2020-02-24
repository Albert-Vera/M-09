package Dam_M_09.claus.EncriptacioEnJava;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.cert.CertificateException;

public class Exercici_2 {




    public static void main(String[] args) throws CertificateException, NoSuchAlgorithmException, IOException, KeyStoreException, UnrecoverableKeyException {
                    // DECLARAR VARIABLE KEYSTORE
        KeyStore keyStore = null;
                    // DECLARAR FITXER ON ESTA EL KEYSTORE
        File ksFile = new File("/home/albert/Documents/M-09/keystore_albert.jks");
                    // DONAR-LI UN TEXT PLA
        String text= "Que embolicat esta tot aixó";
                    // PASAR EL TEXT A BYTES
        byte[] textABytes= text.getBytes("UTF8");  // Text en bytes
                    //ANAR AL METODE QUE RETORNA DUES CLAUS PRIVADA I PUBLICA
        KeyPair keyPair = generarDadesiKlaus(keyStore);
                    // OBTENIR CLAU PUBLICA DEL PARELLS DE CLAUS
        PublicKey publicKey = keyPair.getPublic();
                    // OBTENIR CLALU PRIVADA DEL PARELL DE CLAUS
        PrivateKey privateKey = keyPair.getPrivate();
                    // DECLARA DUES VARIABLE DE BYTES
        byte[] encMsg = new byte[0], encKey = new byte[0];
        try {
                    // GENERA LA CLAU SECRETA EN FORMA AES
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
                    // ES GENERAR AMB TAMANY DE 128 BYTES
            kgen.init(128);
                    // ES GUARDA EN UNA VARIABLE SECRET KEY
            SecretKey sKey = kgen.generateKey();
                    // DONAR FORMAT AES7ECB/PKCS5Padding AL ENCRIPTADOR
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    // INICIAR ENCRIPTADOR AMB LA SECRET KEY
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
                    // ENCRIPTA EL TEXT  DEIXAN-LO A UNA VARIABLE ENCMSG
            encMsg = cipher.doFinal(textABytes);
                    // SE LI DON FORMAT PER ENCRIPTA LA CLAU SECRETA
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    // ENCRIPTAR AMB LA PUBLIC KEY
            cipher.init(Cipher.WRAP_MODE, publicKey);
                    // GUARDA EN UNA VARIABLE LA CLAU ENCRIPTADA
            encKey = cipher.wrap(sKey);
                    // PRINT
            System.out.println("\n\n           ################     EXERCICI 2.0    #########################\n");
            System.out.println("                              CLAU EMBOLCALLADA");
            System.out.println("\nEncriptat: " + new String(encMsg));
        } catch (Exception  ex) {
            System.err.println("Ha succeït un error xifrant: " + ex);
        }
                    // CRIDO AL METODE PER DESENCRIPTAR
        desencryptWrappedData(encMsg, privateKey, encKey);


    }



    static void desencryptWrappedData(byte[] encMsg, PrivateKey data, byte[] encKey) {

        try {
                        // DECLARO VARIABLE CIPHER
            Cipher cipher2 ;
                        // DECLARO FORMAT PER DESENCRIPTAR
            cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                        // INICIO I LI PASO LA CLAU PRIVADA
            cipher2.init(Cipher.UNWRAP_MODE, data);
                        // DESENCRIPTO LA CLAU PUBLICA CODIFICADA
            Key clauDesenvolta = cipher2.unwrap(encKey,"AES", Cipher.SECRET_KEY);

                        // FORMAT PER DESENCRIPTAR EL MISATGER
            cipher2 = Cipher.getInstance("AES/ECB/PKCS5Padding");
                        // LI PASO LA CLAU DESENCRIPTADA PER DESENCRIPTA
            cipher2.init(Cipher.DECRYPT_MODE, clauDesenvolta);
                        // AGAFO EL MISATGE ENCRIPTAR I EL DESENCRIPTO
            byte desencriptado[] = cipher2.doFinal(encMsg);
                        // PRINT
            System.out.println("\n\n           ################     EXERCICI 2.1    #########################\n");
            System.out.println("                              CLAU DESEMBOLCALLADA");
            System.out.println("\nDesenCriptado:" + new String(desencriptado));

        } catch (Exception  ex) {
            System.err.println("Ha succeït un error xifrant: " + ex);
        }

    }

    static KeyPair generarDadesiKlaus(KeyStore keyStore) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, UnsupportedEncodingException {

        KeyPair keys = null;
                                // METODE QUE GENERAR CLAUS SIMETRIQUES
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(1024);
            keys = keyGen.genKeyPair();
        } catch (Exception ex) {
            System.err.println("Generador no disponible.");
        }

        return keys;
    }
}

