package com.example.eigenaar.softwarelearningapp.SoftwareLearingApp;

import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Activity to collect user' names and save the completed game.
 */
public class AddUserActivity extends AppCompatActivity {

    /**
     * Send an HTTP request to the server to create a user.
     *
     * @param userEmail the player's name
     * @return user id of the newly created user, 0 otherwise.
     */
    private int createUser(String userEmail) {
        // Instantiate new instance of HttpRequest
        HttpRequest request = new HttpRequest();
        try {
            // Prepare a JSON with info of the player
            JSONObject data = new JSONObject();
            data.put("email", userEmail);

            // Send the HTTP request, passing the endpoint,
            // the method (POST) and the data
            String result = request.execute("/users", "POST",
                    data.toString()).get();

            // Convert the result into a JSON object
            JSONObject json = new JSONObject(result);
            if (json.has("userId")) {
                return json.getInt("userId");
            }
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
