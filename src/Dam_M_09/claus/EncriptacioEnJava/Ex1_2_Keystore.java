package Dam_M_09.claus.EncriptacioEnJava;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.Files;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Scanner;

import static java.security.cert.CertificateFactory.getInstance;


public class Ex1_2_Keystore {
    public static void main(String[] args) throws Exception {

        File fitxer = new File("/home/albert/Documents/M-09/keystore_albert.jks");
        KeyStore keyStore = loadKeyStore(fitxer, "123456");
        Scanner sc = new Scanner(System.in);
        File fitxerCert = new File("/home/albert/Documents/M-09/jordi.cer");


        while (true) {
            System.out.println("Exercicis de DAM-MP9-UF1 A5");
            System.out.println("Opcions: ");

            System.out.println(" 1. Exercici 1.2. 1");
            System.out.println(" 2. Exercici 1.2. 2");
            System.out.println(" 3. Exercici 1.3");
            System.out.println(" 4. Exercici 1.4");
            System.out.println(" 5. Exercici 1.5");
            System.out.println(" 6. Exercici 1.6");
            System.out.println();
            System.out.print("Triar una opció: ");

            int opcio = sc.nextInt();

            switch (opcio) {
                case 1: //
                    exercici1_2_1(keyStore);
                    break;
                case 2:
                    exercici_1_2_2(keyStore);
                    break;
                case 3:
                    exercici_1_3_4(fitxerCert, "jordi", "EXERCICI 1.3");
                    break;
                case 4:
                    getPublicKey(fitxer);
                    break;
                case 5:
                    exercici_2_5 (keyStore, "EXERCICI 2.5 ");
                    break;
                case 6:

                    exercici_2_6(keyStore, " EXERCICI 2.6 ");
                    break;
                default:
                    System.out.println("Ese valor no es válido");
                    break;
            }
        }

        //
        //


//        System.out.println("           ################     EXERCICI  2.3    #########################\n");
//        PublicKey publicKey = (PublicKey) obtenirPubKeydelCert(keyStore);
//        System.out.println("Aixo es la publikey de jordi: "+ publicKey);
    }

    static void exercici1_2_1(KeyStore keyStore) throws KeyStoreException {

        System.out.println("\n\n           ################     EXERCICI  1.2.1    #########################\n");
        System.out.println("Tipus de Keystore:   " +  keyStore.getType());
        System.out.println(" Nombre de claus al magatzem:   " + keyStore.size());
        Enumeration<String> enumerar = keyStore.aliases();
        while(enumerar.hasMoreElements()) {
            String alias = enumerar.nextElement();
            System.out.println("alias name: " + alias);
        }
        System.out.println(keyStore.getCertificate("laclaum9"));
        System.out.println("Aixo es el algoritme de xifrat: " );
        System.out.println("           ################     FINAL  EXERCICI  1.2.1    #########################");
        System.out.println("           ######################################################################\n");
    }

    static void exercici_1_2_2(KeyStore keyStore){

        SecretKey novaKey = keygenKeyGenerati(256);   //APARTAT 2.2
        KeyStore.SecretKeyEntry ske = new KeyStore.SecretKeyEntry(novaKey);// s'ha anomena Secretkey a la clau Simetrica

        char[] password = ("123456").toCharArray();
        KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(password);
        File pathKeyStore = new File("/home/albert/Documents/M-09/keystore_albert.key");

        try {
            KeyStore ks = loadKeyStore(pathKeyStore,"123456");
            ks.setEntry("nouAlias", ske, protParam);
            FileOutputStream fos = new FileOutputStream("/home/albert/Documents/M-09/keystore_albert.key");
            ks.store(fos, "123456".toCharArray());
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("\n\n           ################       1.2.2      #########################\n");
        System.out.println("                                   CLAU SIMETRICA NOUALIAS CREADA ");
        System.out.println("\n\n           ###########################################################\n");

    }

    static void exercici_1_3_4(File fitxer, String alias, String nom) throws KeyStoreException, IOException, CertificateException {


        System.out.println("\n\n           ################     "+ nom +"    #########################\n");

        FileInputStream fis = new FileInputStream(fitxer);

        CertificateFactory cf = getInstance("X.509");

        Certificate cert = cf.generateCertificate(fis);

        System.out.println(cert.toString());

        System.out.println("\n\n           ###########################################################\n");
    }


    public static void getPublicKey(File filename){


         try {

        FileInputStream is = new FileInputStream(filename);  // RUTA DEL MEU KEYSTORE
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        String password = "123456";
        char[] passwd = password.toCharArray();
        keystore.load(is, passwd);
        String alias = "laclaum9";
        Key key = keystore.getKey(alias, passwd);

        if (key instanceof PrivateKey) {
            //Get certificate of public key
            Certificate cert = keystore.getCertificate(alias);
            //Get public key
            PublicKey publicKey = cert.getPublicKey();
            //String publicKeyString = Base64.encodeBase64String(publicKey.getEncoded());
            System.out.println(publicKey);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    }

    public static void exercici_2_5(KeyStore keyStore, String nom) throws UnsupportedEncodingException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        // genero clau privade i publica
        KeyPair keys = null;
        String text= "Que embolicat esta tot aixó";
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(1024);
            keys = keyGen.genKeyPair();

        } catch (Exception ex) {
            System.err.println("Generador no disponible.");
        }

        PrivateKey priv_key = keys.getPrivate();            // clau privade


        byte[] signature = null;
        byte[] textABytes= text.getBytes("UTF8");  // Text en bytes
        try {
            Signature signer = Signature.getInstance("SHA256withRSA");
            signer.initSign(priv_key);
            signer.update(textABytes);
            signature = signer.sign();


            System.out.println("\n\n           ################     "+ nom +"    #########################\n");
            System.out.println("Signatura privada: \n\n" + signature);
            System.out.println("\n\n           ###########################################################\n");
        } catch (Exception ex) {
            System.err.println("Error signant les dades: " + ex);
        }

//        byte[] dadesBytes = signData(textABytes,priv_key);
    }


    static void exercici_2_6(KeyStore keyStore, String nom) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, UnsupportedEncodingException {

        KeyPair keys = null;
        String text= "Que embolicat esta tot aixó";
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(1024);
            keys = keyGen.genKeyPair();
        } catch (Exception ex) {
            System.err.println("Generador no disponible.");
        }
        PrivateKey priv_key = keys.getPrivate();            // clau privade
        byte[] signature = null;
        byte[] textABytes= text.getBytes("UTF8");  // Text en bytes
        try {
            Signature signer = Signature.getInstance("SHA256withRSA");
            signer.initSign(priv_key);
            signer.update(textABytes);
            signature = signer.sign();

            System.out.println("\n\n           ################     "+ nom + "    #########################");
            System.out.println("           ###############################################################");
            signer.initVerify(keys.getPublic());

            // Pasar los datos que fueron firmados
            signer.update(textABytes);

            // Verificar
            boolean verificado ;
            try {
                verificado = signer.verify(signature);
            } catch (SignatureException se) {
                verificado = false;
            }

            if (verificado) {
                System.out.println("\n                    Firma verificada.");
            } else {
                System.out.println("\nFirma incorrecta.");
            }
            System.out.println("\n\n           ###########################################################\n");
        } catch (Exception ex) {
            System.err.println("Error signant les dades: " + ex);
        }


    }

    public static KeyStore loadKeyStore(File ksFile, String ksPwd) throws Exception {
        KeyStore ks = KeyStore.getInstance("JKS");

        if (ksFile.isFile()) {
            FileInputStream in = new FileInputStream(ksFile);
            ks.load(in, ksPwd.toCharArray());
            //ks.load(null, pwdArray); SI POSAS NULL CREA KEYSTORE DE CERO
        }


        return ks;
    }

    public static SecretKey keygenKeyGenerati(int keySize) {
        SecretKey sKey = null;
        if ((keySize == 128)||(keySize == 192)||(keySize == 256)) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                kgen.init(keySize);
                sKey = kgen.generateKey();

            } catch (NoSuchAlgorithmException ex) {
                System.err.println("Generador no disponible.");
            }
        }
        return sKey;
    }

    public static byte[] signData(byte[] data, PrivateKey priv) {
        byte[] signature = null;

        try {
            Signature signer = Signature.getInstance("SHA1withRSA");
            signer.initSign(priv);
            signer.update(data);
            signature = signer.sign();
        } catch (Exception ex) {
            System.err.println("Error signant les dades: " + ex);
        }
        return signature;
    }


}
