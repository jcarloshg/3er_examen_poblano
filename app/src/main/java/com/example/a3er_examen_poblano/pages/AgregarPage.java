package com.example.a3er_examen_poblano.pages;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.a3er_examen_poblano.R;

import org.json.JSONObject;

public class AgregarPage extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    EditText editText_id, editText_nombre, editText_costo, editText_foto;
    Button btn_agregar;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_page);

        init_components();
    }

    private void init_components() {
        editText_id = findViewById(R.id.editText_id);
        editText_nombre = findViewById(R.id.editText_nombre);
        editText_costo = findViewById(R.id.editText_costo);
        editText_foto = findViewById(R.id.editText_foto);

        btn_agregar = findViewById(R.id.btn_agregar);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}