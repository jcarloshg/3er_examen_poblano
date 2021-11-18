package com.example.a3er_examen_poblano.pages;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.VolleyError;
import com.example.a3er_examen_poblano.R;

import org.json.JSONObject;
import com.android.volley.Response;

public class MostrarPage extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_page);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        
    }

    @Override
    public void onResponse(JSONObject response) {

    }
}