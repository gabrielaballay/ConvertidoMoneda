package com.example.convertidomoneda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbDolar;
    private RadioButton rbEuro;
    private EditText etDolar;
    private EditText etEuro;
    private TextView cambio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDolar=findViewById(R.id.etDolar);
        etEuro=findViewById(R.id.etEuro);
        rbDolar=findViewById(R.id.rbDolar);
        rbEuro=findViewById(R.id.rbEuro);
        cambio=findViewById(R.id.tvCambio);
    }

    public void activarDolar(View v){
        etDolar.setEnabled(false);
        etEuro.setEnabled(true);
        etEuro.setFocusable(true);
        etEuro.requestFocus();
        etDolar.setText("");
        cambio.setText("");
    }

    public void activarEuros(View v){
        etDolar.setEnabled(true);
        etEuro.setEnabled(false);
        etDolar.setFocusable(true);
        etDolar.requestFocus();
        etEuro.setText("");
        cambio.setText("");
    }

    public void convertirMoneda(View v){
        if(rbDolar.isChecked()){
            if(!etEuro.getText().toString().isEmpty()) {
                double valor=Integer.parseInt(etEuro.getText().toString())*1.4;
                cambio.setText(valor+"");
            }else{
                Toast.makeText(this, "Debe ingresar valor a convertir", Toast.LENGTH_SHORT).show();
            }
        }
        if(rbEuro.isChecked()){
            if(!etDolar.getText().toString().isEmpty()) {
                double valor=Integer.parseInt(etDolar.getText().toString())/1.4;
                cambio.setText(valor+"");
            }else{
                Toast.makeText(this, "Debe ingresar valor a convertir", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
