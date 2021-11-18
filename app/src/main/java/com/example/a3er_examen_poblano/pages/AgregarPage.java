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
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
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
        init_btn_agregar();
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,""+error.toString(), Toast.LENGTH_SHORT).show();
        Log.e("[onErrorResponse]" , "onErrorResponse: " + error.toString() );
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this,""+response.toString(), Toast.LENGTH_SHORT).show();
    }

    private void init_btn_agregar() {
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editText_id.getText().toString();
                String nombre = editText_nombre.getText().toString();
                String cost = editText_costo.getText().toString();
                String foto = editText_foto.getText().toString() + ".jpg";
                final String URL = "http://serviciosdigitalesplus.com/catalogo.php?tipo=3&id="+id+"&nom="+nombre+"&costo="+cost+"&foto="+foto;
                // final String url = "http://serviciosdigitalesplus.com/catalogo.php?tipo=3&id=123&nom=jfjf&costo=123&foto=jff.jpg";

                Log.i("[init_btn_agregar]", "onClick: " + URL);

                upload_obj(URL);
            }
        });
    }

    public void upload_obj(String url) {
        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    private void init_components() {
        editText_id = findViewById(R.id.editText_id);
        editText_nombre = findViewById(R.id.editText_nombre);
        editText_costo = findViewById(R.id.editText_costo);
        editText_foto = findViewById(R.id.editText_foto);

        btn_agregar = findViewById(R.id.btn_agregar);
    }
}