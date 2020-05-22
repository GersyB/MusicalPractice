package e08zu8.musicpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class LaunchActivity extends AppCompatActivity {

    ImageButton btnStart;
    ImageButton btnOpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_launch);


        btnStart = findViewById(R.id.btnStart);
        btnOpt = findViewById(R.id.btnOpt);

        btnOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = new Intent(LaunchActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = new Intent(LaunchActivity.this, PracticeActivity.class);
                startActivity(intent);
            }
        });

    }
}
