package de.danielschwenk.restaurant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class BenutzerDaten extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benutzer_daten);

        // Spinner Bezahlung
        setupSpinnerBezahlung();


        final EditText vorname = (EditText)findViewById(R.id.benutzerdaten_text_vorname);
        final EditText nachname = (EditText)findViewById(R.id.benutzerdaten_text_nachname);
        final EditText tischnummer = (EditText)findViewById(R.id.tischnummer);
        final Spinner spinner= (Spinner)findViewById(R.id.spinner_bezahlm);

        Button button_karte = (Button)findViewById(R.id.benutzerdaten_button_karte);
        button_karte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(vorname.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), R.string.benutzerdaten_insert_vorname, Toast.LENGTH_SHORT).show();
                } else if(nachname.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), R.string.benutzerdaten_insert_nachname, Toast.LENGTH_SHORT).show();
                } else if(tischnummer.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), R.string.benutzerdaten_insert_tischnummer, Toast.LENGTH_SHORT).show();
                } else {
                    savaUserData(vorname.getText().toString(),
                            nachname.getText().toString(),
                            tischnummer.getText().toString(),
                            spinner.getSelectedItem().toString());
                    Intent intent = new Intent(BenutzerDaten.this, AuswahlEssenTrinken.class);
                    startActivity(intent);
                }
            }
        });



    }

    private  void savaUserData(String vorname, String nachname, String tischnummer, String bezahlmethode){
        SharedPreferences settings = getApplicationContext().getSharedPreferences("prefs", 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("vorname",vorname);
        editor.putString("nachname", nachname);
        // editor.putInt("tischnummer", Integer.parseInt(tischnummer));
        editor.putString("tischnummer", tischnummer);
        editor.putString("bezahlmethode", bezahlmethode);

        // apply the edits
        editor.apply();
    }


    private void setupSpinnerBezahlung(){
        Spinner spinner = (Spinner)findViewById(R.id.spinner_bezahlm);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.strarray_bezahlm, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
}
