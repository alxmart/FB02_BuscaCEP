package com.luizafmartinez.fb02_buscacep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    Button btnBuscaCep;
    EditText txtCep;
    TextView lblResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCep      = findViewById (R.id.txtCep);
        lblResposta = findViewById (R.id.lblResposta);
        btnBuscaCep = findViewById (R.id.btnBuscaCEP);
    }

        //btnBuscaCep.setOnClickListener(new View.onClickListener() {
        //btnBuscaCep.setOnClickListener(new View.OnClickListener() {

        public void onClick(View view) throws ExecutionException, InterruptedException {
            try {
                CEP retorno = new HttpService(txtCep.getText().toString().trim()).execute().get();
                lblResposta.setText(retorno.toString());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

