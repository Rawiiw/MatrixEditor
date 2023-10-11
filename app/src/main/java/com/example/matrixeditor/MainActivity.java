package com.example.matrixeditor;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openMatrixButton = findViewById(R.id.openMatrixButton);
        Button createMatrixButton = findViewById(R.id.createMatrixButton);
        Button editMatrixButton = findViewById(R.id.editMatrixButton);
        Button settingsButton = findViewById(R.id.settingsButton);

        openMatrixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MatrixDisplayActivity.class);
                startActivity(intent);
            }
        });

        createMatrixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CreateMatrixActivity.class);
                startActivity(intent);
            }
        });

        editMatrixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, EditMatrixActivity.class);
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
