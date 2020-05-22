package e08zu8.musicpractice;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

public class ChartActivity extends AppCompatActivity {
    private PieChart chartAnswer;
    SharedPreferences sharedPref;
    final int[] COLORS = {Color.rgb(255,255,255), Color.rgb(200,200,200)};
    Legend legend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        sharedPref = getDefaultSharedPreferences(this);
        chartAnswer = findViewById(R.id.chartAnswers);
        legend = chartAnswer.getLegend();
        loadChart();
    }

    private void loadChart() {
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(sharedPref.getInt("good", 0), "helyes válaszok"));
        entries.add(new PieEntry(sharedPref.getInt("bad", 0), "helytelen válaszok"));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(COLORS);
        chartAnswer.setDrawHoleEnabled(false);
        legend.setTextColor(Color.WHITE);
        chartAnswer.setEntryLabelColor(Color.BLACK);

        PieData data = new PieData(dataSet);
        chartAnswer.setData(data);
        chartAnswer.invalidate();
    }
}
