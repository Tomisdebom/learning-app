package com.example.eigenaar.softwarelearningapp.SoftwareLearingApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.example.eigenaar.softwarelearningapp.R;


public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    EditText ed1, ed2;

    /** The map of existing players retrieved from the server <name/id>. */
    private Map<String, Integer> playerMap;
    //TextView tx1;
    int counter = 3;

    Boolean status = false;

    // get the data from the server
    String[] userArray;
    String[] passwordArray;

    private void getUser() {
        // Instantiate new instance of HttpRequest
        HttpRequest request = new HttpRequest();
        try {
            // Send the HTTP request, passing the endpoint and the method (GET)
            String result = request.execute("/users", "GET").get();
            // Parse the result into a JSON object
            JSONObject json = new JSONObject(result);
            // if it contains a property 'players'
            // Then instantiate an array of Strings
            // and loop through all players to add strings <name> (<score>)
            if (json.has("user")) {
                JSONArray jsonArray = json.getJSONArray("user");
                this.userArray = new String[jsonArray.length()];
                this.passwordArray = new String[jsonArray.length()];
                for (int index = 0; index < jsonArray.length(); index++) {
                    JSONObject jsonPlayer = jsonArray.getJSONObject(index);
                    userArray[index] = jsonPlayer.getString("email");
                    passwordArray[index] = jsonPlayer.getString("password");
                }
            }
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);

        b1 = findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                status = false;
                getUser();

                String userName = ed2.getText().toString();
                String passWord = ed1.getText().toString();

                    for(int index = 0; index < userArray.length; index++){
                        if (userArray[index].equals(userName) && passwordArray[index].equals(passWord)) {
                            status = true;
                        }
                    }
                    if(status == true){
                        openChapterSelect();
                    }
                    else{Toast.makeText(getApplicationContext(),"Wrong credentials",Toast.LENGTH_SHORT).show();}


                }

        });

        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });
    }



    public void openSignUp() {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void openChapterSelect() {
        Intent intent = new Intent(this, ChapterSelect.class);
        startActivity(intent);
    }
    /**
     * Send an HTTP request to the server to get the list of player's names.
     */
    private Map<String, Integer> getPlayers() {
        // Instantiate new instance of HttpRequest
        HttpRequest request = new HttpRequest();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        try {
            // Send the HTTP request, passing the endpoint and the method (GET)
            String result = request.execute("/players", "GET").get();

            // Convert the result into a JSON object
            JSONObject json = new JSONObject(result);
            if (json.has("players")) {
                JSONArray players = json.getJSONArray("players");
                for (int index = 0; index < players.length(); index++) {
                    JSONObject player = players.getJSONObject(index);
                    playerMap.put(player.getString("name"),
                            player.getInt("id"));
                }
                return playerMap;
            }
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return treeMap;
    }



}







