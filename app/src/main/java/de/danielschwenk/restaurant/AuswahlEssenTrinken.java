package de.danielschwenk.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuswahlEssenTrinken extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auswahl_essen_trinken);


        Button button_essen = (Button)findViewById(R.id.auswahlessentrinken_essen);
        button_essen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuswahlEssenTrinken.this, EssenListActivity.class);
                startActivity(intent);
            }
        });

        Button button_trinken = (Button)findViewById(R.id.auswahlessentrinken_trinken);
        button_trinken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuswahlEssenTrinken.this, GetraenkListActivity.class);
                startActivity(intent);
            }
        });

        Button button_bestellen = (Button)findViewById(R.id.auswahlessentrinken_bestellen);
        button_bestellen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuswahlEssenTrinken.this, Abschicken.class);
                startActivity(intent);
            }
        });

    }
}
