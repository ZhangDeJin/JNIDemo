package com.zdj.jnidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.zdj.jnidemo.cpp.HelloNDK;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("hellondk");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, HelloNDK.stringFromNDK(), Toast.LENGTH_SHORT).show();
    }
}