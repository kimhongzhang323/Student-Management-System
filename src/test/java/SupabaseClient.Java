import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class SupabaseClient {
    private static final String SUPABASE_URL = "https://ogriugirghsryuvsfdcg.supabase.co";
    private static final String SUPABASE_API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9ncml1Z2lyZ2hzcnl1dnNmZGNnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mjg0ODEyODgsImV4cCI6MjA0NDA1NzI4OH0.PKw8GU2sYI_Dp27ulCBnNB7cdoshE8iIZp6u1hYvFjE";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Define the request URL
        String url = SUPABASE_URL + "/rest/v1/your_table_name?select=*";

        // Build the HTTP request
        Request request = new Request.Builder()
                .url(url)
                .addHeader("apikey", SUPABASE_API_KEY)
                .addHeader("Authorization", "Bearer " + SUPABASE_API_KEY)
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println(response.body().string()); // Print response data
            } else {
                System.out.println("Request failed: " + response.message());
            }
        }
    }
}
