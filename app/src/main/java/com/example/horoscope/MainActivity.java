package com.example.horoscope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Change (View v) {
        Fragment f = null;

        switch (v.getId()){
            case R.id.button1:
                f = new info();
                break;
            case R.id.button2:
                f = new output();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fr_poly,f);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}