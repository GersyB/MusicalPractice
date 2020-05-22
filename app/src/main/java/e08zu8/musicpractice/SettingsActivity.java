package e08zu8.musicpractice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button clear;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        sharedPref = getDefaultSharedPreferences(this);
        clear = findViewById(R.id.btnClear);
        Spinner spinner = (Spinner) findViewById(R.id.notes_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.notes_array, R.layout.spinneritem);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("good", 1);
                editor.putInt("bad", 1);
                editor.commit();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("base", position);
        editor.commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
