package com.example.a3lab2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyThread.MyInterface {

    TextView textView;
    Button startButton;
    Button stopButton;
    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        startButton = findViewById(R.id.start_button);
        stopButton = findViewById(R.id.stop_button);
        myThread = new MyThread(this);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myThread.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myThread.interrupt();
                myThread = new MyThread(MainActivity.this);

            }
        });

    }

    @Override
    public void updateText() {
        textView.append("\nTiisu, We want more!");
    }
}
