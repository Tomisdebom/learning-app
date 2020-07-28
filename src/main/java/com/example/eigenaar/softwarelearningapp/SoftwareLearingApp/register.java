package com.example.eigenaar.softwarelearningapp.SoftwareLearingApp;

import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class register extends AppCompatActivity {
    /**
     * Send an HTTP request to the server to create a new user.
     */
    public boolean createUser(String email, String name, String password) {
        // Instantiate new instance of HttpRequest
        HttpRequest request = new HttpRequest();
        try {
            // Prepare a JSON with info of the players and the winner
            JSONObject data = new JSONObject();
            data.put("email", email);
            data.put("name", name);
            data.put("password", password);

            // Send the HTTP request, passing the endpoint,
            // the method (POST) and the data
            String result = request.execute("/users", "POST",
                    data.toString()).get();

            // Convert the result into a JSON object
            JSONObject json = new JSONObject(result);
            // if the result contains an property 'error' or gameId is not
            // a positive number, create a log and return false.

            // Otherwise, return true.
            if (json.has("error")) {
//                Log.e(LOG_TAG, "Error: " + json.get("error").toString());
                return false;
            }
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

// end test
}


