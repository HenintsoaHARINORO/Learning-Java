import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebSiteReaderStream {
    public static void main(String [] args){
        String nextLine;
        URL url= null;
        URLConnection urlConn= null;
        try
        {
            url= new URL("http://www.google.com");
            urlConn= url.openConnection();
        }catch (IOException e){
            System.out.println("Can't connect to the provided URL: "+e.toString());
        }
        try(InputStreamReader inStream= new InputStreamReader(urlConn.getInputStream(),"UTF8");
        BufferedReader buff= new BufferedReader(inStream);){
    buff.lines().forEach(System.out::println);
        }catch(IOException e1){
        System.out.println("Can't read from the Internet:"+e1.toString() );
        }
    }
}
