package e08zu8.musicpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import generator.NoteGenerator;
import generator.NotePlayer;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

public class PracticeActivity extends AppCompatActivity {

    Button[] buttons;
    Button btnPrim;
    Button btnKSec;
    Button btnNSec;
    Button btnKTerc;
    Button btnNTerc;
    Button btnKvart;
    Button btnSzKvint;
    Button btnKvint;
    Button btnKSzext;
    Button btnNSzext;
    Button btnKSept;
    Button btnNSept;
    Button btnOkt;
    Button btnStats;
    Button btnReplay;
    NoteGenerator generator;
    NotePlayer player;
    int good;
    int bad;
    int generated;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        sharedPref = getDefaultSharedPreferences(this);
        buttons = new Button[13];
        buttons[0] = btnPrim = findViewById(R.id.BtnPrim);
        buttons[1] = btnKSec = findViewById(R.id.BtnKSec);
        buttons[2] = btnNSec = findViewById(R.id.BtnNSec);
        buttons[3] = btnKTerc = findViewById(R.id.BtnKTerc);
        buttons[4] = btnNTerc = findViewById(R.id.BtnNTerc);
        buttons[5] = btnKvart = findViewById(R.id.BtnKvart);
        buttons[6] = btnSzKvint = findViewById(R.id.BtnSZKvint);
        buttons[7] = btnKvint = findViewById(R.id.BtnKvint);
        buttons[8] = btnKSzext = findViewById(R.id.BtnKSzext);
        buttons[9] = btnNSzext = findViewById(R.id.BtnNSzext);
        buttons[10] = btnKSept = findViewById(R.id.BtnKSept);
        buttons[11] = btnNSept = findViewById(R.id.BtnNSept);
        buttons[12] = btnOkt = findViewById(R.id.BtnOkt);
        btnStats = findViewById(R.id.BtnStats);
        btnReplay = findViewById(R.id.BtnReplay);
        good = 0;
        bad = 0;
        generator = new NoteGenerator(sharedPref.getInt("base", 0));
        player = new NotePlayer(this);
        this.Init();
        for(int i=0;i<13;i++){
            buttons[i].setEnabled(false);
        }

        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                player.Stop();
                if(generator.GetDist() == 0){
                    for(int i = 0;i<13;i++){
                        buttons[i].setEnabled(true);
                        buttons[i].setBackgroundResource(R.drawable.buttonsback);
                    }
                    generated = generator.Generate();
                    player.Play(generated);
                }
                else{
                    player.Play(generated);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.Stop();
        SharedPreferences.Editor editor = sharedPref.edit();
        good += sharedPref.getInt("good", 0);
        bad += sharedPref.getInt("bad", 0);
        editor.putInt("good", good);
        editor.putInt("bad", bad);
        editor.commit();
    }

    @Override
    protected void onResume(){
        super.onResume();
        good = 0;
        bad = 0;
    }

    private void Init(){
        btnPrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 1) {
                    good++;
                    btnPrim.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnPrim.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnKSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 2) {
                    good++;
                    btnKSec.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnKSec.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnNSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 3) {
                    good++;
                    btnNSec.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnNSec.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnKTerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 4) {
                    good++;
                    btnKTerc.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnKTerc.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnNTerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 5) {
                    good++;
                    btnNTerc.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnNTerc.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });

        btnKvart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 6) {
                    good++;
                    btnKvart.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnKvart.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnSzKvint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 7) {
                    good++;
                    btnSzKvint.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnSzKvint.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnKvint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 8) {
                    good++;
                    btnKvint.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnKvint.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnKSzext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 9) {
                    good++;
                    btnKSzext.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnKSzext.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnNSzext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 10) {
                    good++;
                    btnNSzext.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnNSzext.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnKSept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 11) {
                    good++;
                    btnKSept.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnKSept.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnNSept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 12) {
                    good++;
                    btnNSept.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnNSept.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnOkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(generator.GetDist() == 13) {
                    good++;
                    btnOkt.setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
                else{
                    bad++;
                    btnOkt.setBackgroundResource(R.drawable.buttonsbackfalse);
                    buttons[generator.GetDist() - 1].setBackgroundResource(R.drawable.buttonsbacktrue);
                    for(int i=0;i<13;i++){
                        buttons[i].setEnabled(false);
                    }
                    generator.SetDist();
                }
            }
        });
        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Intent intent = new Intent(PracticeActivity.this, ChartActivity.class);
                startActivity(intent);
            }
        });
    }
}
