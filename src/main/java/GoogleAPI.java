import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class GoogleAPI {

    // https://stackoverflow.com/questions/8147284/how-to-use-google-translate-api-in-my-java-application
    private String translate(String langFrom, String langTo, String text) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbxUZOYmiFQOzLbOenMOJcVAbQMVpvJLFIJLnn4n2OLWmWP4-TIYXjI7xLvka4CRIAwFBA/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String s1 = response.toString();
        String s2 = s1.replaceAll("&#39;", "'");
        return s2;
    }

    public String EtoV(String text) throws IOException {
        return translate("en", "vi", text);
    }

    public String VtoE(String text) throws IOException {
        return translate("vi", "en", text);
    }

}