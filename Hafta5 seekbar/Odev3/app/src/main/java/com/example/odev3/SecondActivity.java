package com.example.odev3;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private TextView tvCountdown;
    private ConstraintLayout mainLayout;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvCountdown = findViewById(R.id.tvCountdown);
        mainLayout = findViewById(R.id.secondMain);

        int timeInSeconds = getIntent().getIntExtra("TIME_VALUE", 0);

        new CountDownTimer(timeInSeconds * 1000L, 1000) {

            public void onTick(long millisUntilFinished) {
                tvCountdown.setText(String.valueOf(millisUntilFinished / 1000));
                changeBackgroundColor();
            }

            public void onFinish() {
                tvCountdown.setText("Uygulama bitmiştir");
                changeBackgroundColor();
                Toast.makeText(SecondActivity.this, "Uygulama bitmiştir", Toast.LENGTH_LONG).show();
            }
        }.start();
    }

    private void changeBackgroundColor() {
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        mainLayout.setBackgroundColor(color);
    }
}
