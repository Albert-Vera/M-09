package Urls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusquedaURL {  // Extreu link HREF de WEB

    public static void main(String[] args) throws Exception {
        String content = extractContent("https://docs.google.com/forms/d/e/1FAIpQLScE6sxLFb3BmCmT2TKHQH5ormS0qvjHwO-uTAR8MXaagBvSSQ/viewform");
        showLinks(content);
    }

    private static String extractContent(String urlString)
            throws MalformedURLException, IOException, MalformedURLException {
        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();

        Authenticator au = new Authenticator() {
            @Override
            protected PasswordAuthentication
            getPasswordAuthentication() {
                return new PasswordAuthentication
                        ("usuario", "clave".toCharArray());
            }
        };
        Authenticator.setDefault(au);

        InputStream is = urlConnection.getInputStream();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String content = "";
        String linea ;
        while ((linea = br.readLine()) != null) {
            content += linea;
        }
        return content;
    }

    private static void showLinks(String content) {
        Pattern pattern = Pattern.compile("(?i)input\\s*=\\s*\"(.*?)\"");
       // Pattern pattern = Pattern.compile("name");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
