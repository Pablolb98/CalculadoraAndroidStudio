package com.example.calculadora;

import android.content.Intent;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.pm.PackageManager;
import android.content.Context;
import android.provider.Settings;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    String numero1="";
    String op = "+";
    boolean isNewOP = true;
    EditText ed1;



    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editText);
    }


    public void numberEvent(View view) {
        if(isNewOP)
            ed1.setText("");
        isNewOP = false;
        String number = ed1.getText().toString();
        switch (view.getId()){
            case R.id.btnUno:
                number += "1";
                break;

            case R.id.btnDos:
                number += "2";
                break;
            case R.id.btnTres:
                number += "3";
                break;
            case R.id.btnCuatro:
                number += "4";
                break;
            case R.id.btnCinco:
                number += "5";
                break;
            case R.id.btnSeis:
                number += "6";
                break;
            case R.id.btnSiete:
            number += "7";
            break;
            case R.id.btnOcho:
                number += "8";
                break;
            case R.id.btnNueve:
                number += "9";
                break;
            case R.id.btnCero:
                number += "0";
                break;
            case R.id.btnComa:
                number += ".";
                break;
        }
        ed1.setText(number);
    }


    public void operatorEvent(View view) {
        isNewOP = true;
        numero1 = ed1.getText().toString();
        switch (view.getId()){
            case R.id.btnDividir: op="/"; break;
            case R.id.btnmultiplicar: op="*"; break;
            case R.id.btnSuma: op="+"; break;
            case R.id.btnResta: op="-"; break;
        }
    }

    public void igualEvent(View view) {
        String numero2 = ed1.getText().toString();
        double result = 0.0;
        switch (op){
            case "+": result = Double.parseDouble(numero1) + Double.parseDouble(numero2); break;
            case "-": result = Double.parseDouble(numero1) - Double.parseDouble(numero2); break;
            case "/": result = Double.parseDouble(numero1) / Double.parseDouble(numero2); break;
            case "*": result = Double.parseDouble(numero1) * Double.parseDouble(numero2); break;
        }
        ed1.setText(result+"");
    }

    public void limpiarEvent(View view) {
        ed1.setText("0");
        isNewOP = true;
    }

    public void porcentajeEvent(View view) {
        double num = Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(num+"");
        isNewOP = true;
    }

    public void borrarEvent (View view){
        EditText tv = findViewById(R.id.editText);
        String str = tv.getText().toString();
        str = str.substring(0, str.length()-1);
        tv.setText(str.toString());
    }
}