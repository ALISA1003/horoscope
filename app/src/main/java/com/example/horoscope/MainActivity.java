package com.example.horoscope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText sign;
    private EditText day;
    private TextView tv1;
    private Button bt_G;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign = findViewById(R.id.editText1);
        day = findViewById(R.id.editText2);
        tv1 = findViewById(R.id.textView1);
        bt_G = findViewById(R.id.button);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        bt_G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoroApi HA = new HoroApi(sign.getText().toString(), day.getText().toString());
                ModelAnswer Ans = null;
                try {
                    Ans = HA.getHoro();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv1.setText(Ans.getColor());
            }
        });

    }
}