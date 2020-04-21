package Urls;

import java.io.IOException;
import java.net.*;

public class Proba {
    public static void main(String[] args) throws IOException {

        InetAddress[] addresses = new InetAddress[2];

        addresses[0] = InetAddress.getLocalHost();
        addresses[1] = InetAddress.getByName("ioc.xtec.cat");

        for(
                InetAddress adress: addresses){
            if(adress.isLoopbackAddress()){
                System.out.println(adress.getHostName() + " té una adreça loopback");
            }else{
                System.out.println(adress.getHostName() + " no té una adreça loopback");
            }
        }
    }
}
