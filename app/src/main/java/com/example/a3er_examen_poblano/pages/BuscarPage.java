package com.example.a3er_examen_poblano.pages;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.a3er_examen_poblano.R;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class BuscarPage extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    EditText editText_search, editText_search_id, editText_search_nombre, editText_search_costo, editText_search_foto;
    Button btn_search_buscar;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_page);

        init_components();
        init_btn_search_buscar();
    }

    private void init_btn_search_buscar() {
        btn_search_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ID = editText_search.getText().toString();
                String url = "http://serviciosdigitalesplus.com/catalogo.php?tipo=3&id="+ID;
                get_object(url);
            }
        });
    }

    private void get_object(String url) {
        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    private void init_components() {
        btn_search_buscar = findViewById(R.id.btn_search_buscar);

        editText_search = findViewById(R.id.editText_search);
        editText_search_id = findViewById(R.id.editText_search_id);
        editText_search_nombre = findViewById(R.id.editText_search_nombre);
        editText_search_costo = findViewById(R.id.editText_search_costo);
        editText_search_foto = findViewById(R.id.editText_search_foto);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,""+error.toString(), Toast.LENGTH_SHORT).show();
        Log.e("[onErrorResponse]" , "onErrorResponse: " + error.toString() );
    }

    @Override
    public void onResponse(JSONObject response) {
        JSONObject jsonObject2 = response.optJSONObject("dato");

        try {
            editText_search_id.setText(jsonObject2.optString("id"));
            editText_search_nombre.setText(jsonObject2.optString("nom"));
            editText_search_costo.setText(jsonObject2.optString("costo"));
            editText_search_foto.setText(jsonObject2.optString("foto"));
        }catch (Exception error){
            Toast.makeText(this,""+error.toString(), Toast.LENGTH_SHORT).show();
            Log.e("[onErrorResponse]" , "onErrorResponse: " + error.toString() );
        }
    }
}