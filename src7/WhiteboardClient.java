/**
 * Created by Андрей on 28.05.2015.
 */
import java.io.*;
import java.net.*;

public class WhiteboardClient {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("get")) {
            URL url = new URL("http://localhost:8080/get");
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String content = URLDecoder.decode(reader.readLine(), "Unicode");
            reader.close();
            System.out.println(content);
        } else {
            URL url = new URL("http://localhost:8080/post?message=" + URLEncoder.encode(args[1], "UTF-8"));
            url.openConnection().getInputStream();
        }
    }
}