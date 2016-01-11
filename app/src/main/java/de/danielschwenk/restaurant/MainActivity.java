package de.danielschwenk.restaurant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reset Menuwahl vom Vorgaenger
        SharedPreferences settings = getApplicationContext().getSharedPreferences("prefs", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("gericht", "");
        editor.putString("getraenk", "");
        // apply the edits
        editor.apply();


        Button button_bestellen = (Button)findViewById(R.id.main_button_bestellen);

        button_bestellen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BenutzerDaten.class);
                startActivity(intent);
            }
        });
    }
}
