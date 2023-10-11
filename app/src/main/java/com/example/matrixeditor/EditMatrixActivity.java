package com.example.matrixeditor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EditMatrixActivity extends AppCompatActivity {
    private EditText[][] matrixEditText;
    private Button saveChangesButton;
    private Button backButton;
    private int rows = 3;
    private int cols = 3;
    private int[][] matrixData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_matrix);


        matrixEditText = new EditText[rows][cols];
        saveChangesButton = findViewById(R.id.saveChangesButton);
        backButton = findViewById(R.id.backButton);


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int editTextId = getResources().getIdentifier("matrixEditText_" + i + "_" + j, "id", getPackageName());
                matrixEditText[i][j] = findViewById(editTextId);
            }
        }


        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveMatrixChanges();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }


    private void saveMatrixChanges() {
        matrixData = new int[rows][cols];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                try {
                    matrixData[i][j] = Integer.parseInt(matrixEditText[i][j].getText().toString());
                } catch (NumberFormatException e) {

                    matrixData[i][j] = 0;
                }
            }
        }


    }
}
