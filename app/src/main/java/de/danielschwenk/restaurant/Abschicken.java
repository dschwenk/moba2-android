package de.danielschwenk.restaurant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Abschicken extends AppCompatActivity {

    private String gericht = "";
    private String getraenk = "";

    String[] Essen_String_Array;
    String[] Trinken_String_Array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abschicken);

        Essen_String_Array = getResources().getStringArray(R.array.essen);
        Trinken_String_Array = getResources().getStringArray(R.array.trinken);

        SharedPreferences settings = getApplicationContext().getSharedPreferences("prefs", 0);

        TextView tv_vorname = (TextView)findViewById(R.id.abschicken_vorname);
        TextView tv_nachname = (TextView)findViewById(R.id.abschicken_nachname);
        TextView tv_tischnummer = (TextView)findViewById(R.id.abschicken_tischennummer);
        TextView tv_bezahlmethode = (TextView)findViewById(R.id.abschicken_bezahlmethode);
        TextView tv_gericht = (TextView)findViewById(R.id.abschicken_gericht);
        TextView tv_getreank = (TextView)findViewById(R.id.abschicken_getraenk);

        String vorname = settings.getString("vorname", "bla");
        tv_vorname.setText(vorname);

        String nachname = settings.getString("nachname", "bla");
        tv_nachname.setText(nachname);

        String tischnummer = settings.getString("tischnummer", "bla");
        // int tischnummer = settings.getInt("tischnummer", 0);
        tv_tischnummer.setText(tischnummer);

        String bezahlmethode = settings.getString("bezahlmethode", "bla");
        tv_bezahlmethode.setText(bezahlmethode);

        //gericht = settings.getString("gericht", "");
        if((settings.getString("gericht", "")).toString() == ""){
            gericht = "nicht gewählt";
        }
        else {
            int gericht_number = Integer.parseInt((settings.getString("gericht", "")).toString());
            gericht = Essen_String_Array[gericht_number-1];
        }
        tv_gericht.setText(gericht);



        if((settings.getString("getraenk", "")).toString() == ""){
            getraenk = "nicht gewählt";
        }
        else {
            int getraenk_number = Integer.parseInt((settings.getString("getraenk", "")).toString());
            getraenk = Trinken_String_Array[getraenk_number-1];
        }
        tv_getreank.setText(getraenk);


        Button button_abschicken = (Button)findViewById(R.id.button_abschicken);
        button_abschicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(gericht == "nicht gewählt" && getraenk == "nicht gewählt"){
                Toast.makeText(getApplicationContext(), R.string.keine_bestellungt, Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(Abschicken.this, Danke.class);
                startActivity(intent);
            }
                }
        });

    }
}
