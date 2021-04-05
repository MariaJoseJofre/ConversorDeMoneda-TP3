package com.example.conversordemoneda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
private MainActivityViewModel vm;
private Button btConvertir;
private EditText etDolares, etEuros;
private EditText etResultado;
private RadioGroup radioGroup;
private RadioButton rbEuroADolar, rbDolarAEuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        inicializarVistas();

        vm.getResultadoMultable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etResultado.setText(s);
            }
        });

    }


    private void inicializarVistas(){
    btConvertir = findViewById(R.id.btConvertir);
    etDolares = findViewById(R.id.etDolares);
    etEuros = findViewById(R.id.etEuros);
    etResultado = findViewById(R.id.etResultado);
    radioGroup = findViewById(R.id.radioGroup);
    rbDolarAEuro = findViewById(R.id.rbDolarAEuro);
    rbEuroADolar = findViewById(R.id.rbEuroADolar);

    btConvertir.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (rbDolarAEuro.isChecked())
                vm.DolarAEuro(etDolares.getText().toString());
            if (rbEuroADolar.isChecked())
                vm.EuroADolar(etEuros.getText().toString());

            etDolares.setText("");
            etEuros.setText("");

        }

    });

    rbEuroADolar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            etDolares.setEnabled(false);
            etEuros.setEnabled(true);
        }
    });

    rbDolarAEuro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            etEuros.setEnabled(false);
            etDolares.setEnabled(true);
        }
    });



    }
}