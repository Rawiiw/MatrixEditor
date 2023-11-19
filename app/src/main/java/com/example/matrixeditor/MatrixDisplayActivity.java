package com.example.matrixeditor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MatrixDisplayActivity extends AppCompatActivity {
    private TableLayout matrixTableLayout;
    private Button setDefaultButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_display);

        matrixTableLayout = findViewById(R.id.matrixTableLayout);
        setDefaultButton = findViewById(R.id.setDefaultButton);
        backButton = findViewById(R.id.backButton);

        setDefaultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDefaultMatrix();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatrixDisplayActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private void displayDefaultMatrix() {
        MatrixDatabaseHelper dbHelper = new MatrixDatabaseHelper(this);


        dbHelper.insertDefaultMatrix();

        List<Matrix> matrices = dbHelper.getAllMatrices();

        if (!matrices.isEmpty()) {
            Matrix defaultMatrix = matrices.get(0);

            matrixTableLayout.removeAllViews();

            String[] rows = defaultMatrix.getData().split(";");

            for (String row : rows) {
                TableRow tableRow = new TableRow(this);

                String[] elements = row.split(",");

                for (String element : elements) {
                    TextView textView = new TextView(this);
                    textView.setText(element);
                    textView.setPadding(8, 8, 8, 8);

                    tableRow.addView(textView);
                }

                matrixTableLayout.addView(tableRow);
            }
        }
    }
}



