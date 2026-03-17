package com.example.odev3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarMin, seekBarMax;
    private TextView tvMinLabel, tvMaxLabel;
    private Button btnStart;

    private int minValue = 0;
    private int maxValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarMin = findViewById(R.id.seekBarMin);
        seekBarMax = findViewById(R.id.seekBarMax);
        tvMinLabel = findViewById(R.id.tvMinLabel);
        tvMaxLabel = findViewById(R.id.tvMaxLabel);
        btnStart = findViewById(R.id.btnStart);

        seekBarMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                minValue = progress;
                tvMinLabel.setText("Min: " + minValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                maxValue = progress;
                tvMaxLabel.setText("Max: " + maxValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btnStart.setOnClickListener(v -> {
            if (maxValue <= minValue) {
                Toast.makeText(this, "Maksimum değer minimumdan büyük olmalıdır!", Toast.LENGTH_SHORT).show();
                return;
            }

            int randomTime = new Random().nextInt((maxValue - minValue) + 1) + minValue;
            
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("TIME_VALUE", randomTime);
            startActivity(intent);
        });
    }
}
