package com.example.matrixeditor;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CreateMatrixActivity extends AppCompatActivity {
    private EditText widthEditText;
    private EditText heightEditText;
    private Button createMatrixButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_matrix);

        widthEditText = findViewById(R.id.widthEditText);
        heightEditText = findViewById(R.id.heightEditText);
        createMatrixButton = findViewById(R.id.createMatrixButton);
        backButton = findViewById(R.id.backButton);

        createMatrixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int width = Integer.parseInt(widthEditText.getText().toString());
                int height = Integer.parseInt(heightEditText.getText().toString());


                createNewMatrix(width, height);


            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Возврат в главное меню (Окно 1)
                finish();
            }
        });
    }

    private void createNewMatrix(int width, int height) {
        com.example.matrixeditor.Matrix matrix = new com.example.matrixeditor.Matrix();
        matrix.setWidth(width);
        matrix.setHeight(height);

        MatrixDatabaseHelper dbHelper = new MatrixDatabaseHelper(this);
        long matrixId = dbHelper.insertMatrix(matrix);
    }
}
