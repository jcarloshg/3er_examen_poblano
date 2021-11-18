package com.example.a3er_examen_poblano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a3er_examen_poblano.pages.AgregarPage;
import com.example.a3er_examen_poblano.pages.BuscarPage;
import com.example.a3er_examen_poblano.pages.EliminarPage;
import com.example.a3er_examen_poblano.pages.ModificarPage;
import com.example.a3er_examen_poblano.pages.MostrarPage;

public class MainActivity extends AppCompatActivity {

    Button btn_agregar, btn_mostrar, btn_eliminar, btn_modificar, btn_buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_cmponents();
        init_btn_agregar();
        init_btn_mostrar();
        init_btn_eliminar(); 
        init_btn_modificar(); 
        init_btn_buscar();
    }

    // init components ===================================================

    private void init_btn_buscar() {
        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BuscarPage.class);
                startActivity(intent);
            }
        });
    }

    private void init_btn_modificar() {
        btn_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModificarPage.class);
                startActivity(intent);
            }
        });
    }

    private void init_btn_eliminar() {
        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EliminarPage.class);
                startActivity(intent);
            }
        });
    }

    private void init_btn_mostrar() {
        btn_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MostrarPage.class);
                startActivity(intent);
            }
        });
    }

    private void init_btn_agregar() {
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AgregarPage.class);
                startActivity(intent);
            }
        });
    }

    private void init_cmponents() {
        this.btn_agregar = findViewById(R.id.btn_agregar);
        this.btn_mostrar = findViewById(R.id.btn_mostrar);
        this.btn_buscar = findViewById(R.id.btn_buscar);
        this.btn_eliminar = findViewById(R.id.btn_eliminar);
        this.btn_modificar = findViewById(R.id.btn_modificar);
    }
}