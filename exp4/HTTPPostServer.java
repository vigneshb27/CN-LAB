import java.util.*;
import java.net.*;
import java.io.*;

class HTTPPostServer {
    
    private static final String USER_AGENT = "Google Chrome";

    public static String sendPost(String url) throws Exception 
    {
        URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int code = con.getResponseCode();
        if(code == HttpURLConnection.HTTP_OK)
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = br.readLine()) != null)
            {
                response.append(inputLine);
            }
            return response.toString();
        }
        else
        {
            return "Error";
        }
    }

    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(6789);
        Socket s = ss.accept();
        DataInputStream is = new DataInputStream(s.getInputStream());
        DataOutputStream os = new DataOutputStream(s.getOutputStream());

        String url;
        url = is.readUTF();
        os.writeUTF(sendPost(url));
        s.close();
        ss.close();
    }
}