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

public class EliminarPage extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    EditText editText_delete;
    Button btn_delete;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_page);

        init_coponents();
        init_btn_delete();
    }

    private void init_btn_delete() {
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ID = editText_delete.getText().toString();
                final String URL = "https://serviciosdigitalesplus.com/catalogo.php?tipo=4&id="+ID;

                Log.i("[init_btn_delete]", "onClick: "+ URL);

                delete_object(URL);
            }
        });
    }

    private void delete_object(String url) {
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    private void init_coponents() {
        editText_delete = findViewById(R.id.editText_delete);
        btn_delete = findViewById(R.id.btn_delete);

        request = Volley.newRequestQueue(getApplicationContext());

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,""+error.toString(), Toast.LENGTH_SHORT).show();
        Log.e("[onErrorResponse]" , "onErrorResponse: " + error.toString() );
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this,""+response.toString(), Toast.LENGTH_SHORT).show();
        Log.e("[onErrorResponse]" , "onErrorResponse: " + response.toString() );

    }
}