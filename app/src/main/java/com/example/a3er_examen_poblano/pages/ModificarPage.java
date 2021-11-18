package com.example.a3er_examen_poblano.pages;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.a3er_examen_poblano.R;

import org.json.JSONObject;

public class ModificarPage extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    EditText editText_search, editText_search_id, editText_search_nombre, editText_search_costo, editText_search_foto;
    Button btn_search_buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_page);
     }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}