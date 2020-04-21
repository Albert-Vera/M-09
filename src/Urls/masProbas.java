package Urls;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class masProbas {
    public static void main(String[] args) {

        String text="";
        String h1Mostrar="";
        try {
         //   String nombreurl = request.getParameter("url");
            URL url = new URL("https://docs.google.com/a/elpuig.xeill.net/forms/d/e/1FAIpQLScE6sxLFb3BmCmT2TKHQH5ormS0qvjHwO-uTAR8MXaagBvSSQ/viewform");
            URLConnection uc = url.openConnection();
            uc.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));

            StringBuilder builder = new StringBuilder();
            String aux = "";
            List<String> lis = new ArrayList<>();
            while ((aux = in.readLine()) != null) {
              //  if (aux.contains("title")) {
                 //   System.out.println(aux);
                 //   lis.add(aux);
              //  }

                builder.append(aux);
            }
//            List<String> a = (List<String>) lis.stream().filter(x -> x.contains("body")).collect(Collectors.toList());
//
//            for ( String as: a){
//                System.out.println("as... " + as);
//            }

            text = builder.toString();
            StringBuffer sText = new StringBuffer(text);

            int h1Cuantos=0;
            int h1Donde=1;

            while (sText.indexOf("<title>")!=-1 || h1Cuantos<2){
                h1Donde=sText.indexOf("<title>");
                sText = new StringBuffer (sText.substring(h1Donde+1));
                h1Cuantos++;
            }
            System.out.println(sText);

        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println("ERROR: "+ex.getMessage());
        }
    }
}
