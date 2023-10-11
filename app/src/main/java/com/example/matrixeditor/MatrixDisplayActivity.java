package com.example.matrixeditor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MatrixDisplayActivity extends AppCompatActivity {
    private RecyclerView matrixRecyclerView;
    private MatrixAdapter matrixAdapter;
    private Button editMatrixButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_display);


        matrixRecyclerView = findViewById(R.id.matrixRecyclerView);
        editMatrixButton = findViewById(R.id.editMatrixButton);
        backButton = findViewById(R.id.backButton);


        editMatrixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MatrixDisplayActivity.this, EditMatrixActivity.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
