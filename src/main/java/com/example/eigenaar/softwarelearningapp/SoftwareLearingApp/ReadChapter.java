package com.example.eigenaar.softwarelearningapp.SoftwareLearingApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

/**
 * Activity to collect players' names and save the completed game.
 */
public class ReadChapter extends AppCompatActivity {

    /** The map of existing players retrieved from the server <name/id>. */
    private Map<String, Integer> chapterMap;

    // Retrieve the list of existing players from the server
    //chapterMap = getChapters();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the list of existing players from the server
        chapterMap = getChapters();

    }
    
    /**
     * Send an HTTP request to the server to get the list of player's names.
     */
    private Map<String, Integer> getChapters() {
        // Instantiate new instance of HttpRequest
        HttpRequest request = new HttpRequest();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        try {
            // Send the HTTP request, passing the endpoint and the method (GET)
            String result = request.execute("/chapters", "GET").get();

            // Convert the result into a JSON object
            JSONObject json = new JSONObject(result);
            if (json.has("chapters")) {
                JSONArray chapters = json.getJSONArray("chapters");
                for (int index = 0; index < chapters.length(); index++) {
                    JSONObject chapter = chapters.getJSONObject(index);
                    chapterMap.put(chapter.getString("name"),
                            chapter.getInt("id"));
                }
                return chapterMap;
            }
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return treeMap;
    }

}
