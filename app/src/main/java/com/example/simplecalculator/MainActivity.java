package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnTentang;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnTentang = findViewById(R.id.btnTentang);
        result = findViewById(R.id.result);

        btnAdd.setOnClickListener(v -> hitung('+'));
        btnSubtract.setOnClickListener(v -> hitung('-'));
        btnMultiply.setOnClickListener(v -> hitung('*'));
        btnDivide.setOnClickListener(v -> hitung('/'));

        btnTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke DetailActivity
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void hitung(char operator) {
        String val1 = input1.getText().toString();
        String val2 = input2.getText().toString();

        if (val1.isEmpty() || val2.isEmpty()) {
            result.setText("Hasil: Masukkan kedua angka!");
            return;
        }

        double angka1 = Double.parseDouble(val1);
        double angka2 = Double.parseDouble(val2);
        double hasil = 0;

        switch (operator) {
            case '+':
                hasil = angka1 + angka2;
                break;
            case '-':
                hasil = angka1 - angka2;
                break;
            case '*':
                hasil = angka1 * angka2;
                break;
            case '/':
                if (angka2 == 0) {
                    result.setText("Hasil: Tidak bisa bagi 0");
                    return;
                }
                hasil = angka1 / angka2;
                break;
        }

        result.setText("Hasil: " + hasil);
    }
}
