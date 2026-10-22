package com.example.myptojectmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvCounter;
    private Button btnIncrement;

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        btnIncrement = findViewById(R.id.btnIncrement);

        mainViewModel = new ViewModelProvider(this)
                .get(MainViewModel.class);

        btnIncrement.setOnClickListener(view -> {
            mainViewModel.increment();
        });

        mainViewModel.getCounter().observe(this, counter -> {
            tvCounter.setText(String.valueOf(counter));
        });
    }
}