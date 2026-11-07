import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;

public class Main {
    static void getInfoOfGithubApi(String username) throws Exception {
        try {
            URL url = new URL("https://api.github.com/users/" + username + "/events");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() == 404) {
                throw new RuntimeException("User \"" + username + "\" not found.");
            }
            if (connection.getResponseCode() == 403 || connection.getResponseCode() == 429) {
                throw new RuntimeException("Too many requests, please try again later.");
            }
            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
            }

            BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseJson = new StringBuilder();
            String line;
            while((line = response.readLine()) != null) {
                responseJson.append(line);
            }

            JsonArray events = JsonParser.parseString(responseJson.toString()).getAsJsonArray();

            for (JsonElement elements : events) {
                JsonObject event = elements.getAsJsonObject();

                String type = event.get("type").getAsString();
                String repository = event.getAsJsonObject("repo").get("name").getAsString();
                String date = event.get("created_at").getAsString();

                System.out.println(type + " em " + repository + " (" + date + ")");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter username: ");
            String username = scanner.next();
            getInfoOfGithubApi(username);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}