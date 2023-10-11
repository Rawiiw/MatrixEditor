package com.example.matrixeditor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private Spinner matrixTypeSpinner;
    private Spinner dimensionNumberSpinner;
    private Spinner measurementTypeSpinner;
    private Button saveSettingsButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        matrixTypeSpinner = findViewById(R.id.matrixTypeSpinner);
        dimensionNumberSpinner = findViewById(R.id.dimensionNumberSpinner);
        measurementTypeSpinner = findViewById(R.id.measurementTypeSpinner);
        saveSettingsButton = findViewById(R.id.saveSettingsButton);
        backButton = findViewById(R.id.backButton);

        saveSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Сохранение выбранных настроек в приложении
                saveSettings();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void saveSettings() {

        String selectedMatrixType = matrixTypeSpinner.getSelectedItem().toString();
        int selectedDimensionNumber = Integer.parseInt(dimensionNumberSpinner.getSelectedItem().toString());
        String selectedMeasurementType = measurementTypeSpinner.getSelectedItem().toString();

    }
}
