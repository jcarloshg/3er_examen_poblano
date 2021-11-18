package com.example.a3er_examen_poblano.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.a3er_examen_poblano.R;

import org.json.JSONArray;
import org.json.JSONObject;
import com.android.volley.Response;

public class MostrarPage extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    EditText editText_info;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    final String URL = "http://serviciosdigitalesplus.com/catalogo.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_page);

        init_components();
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,""+error.toString(), Toast.LENGTH_SHORT).show();
        Log.e("[onErrorResponse]" , "onErrorResponse: " + error.toString() );

    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this,""+response.toString(), Toast.LENGTH_SHORT).show();
        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObject = null;
        String line = "";

        try {
            jsonObject = jsonArray.getJSONObject(0);
            line += "id: " + jsonObject.optString("id") + "\n";
            line += "nombre: " + jsonObject.optString("nom") + "\n";
            line += "cost: " + jsonObject.optString("costo") + "\n";
            line += "foto: " + jsonObject.optString("foto") + "\n";

            line += jsonArray.toString();

            editText_info.setText(line);

        }catch (Exception ex){
            Log.e("[onResponse ] ", "onResponse: " + ex.toString() );
        }

        // editText_info.setText( jsonArray.toString() );
    }

    // ==============================================================
    // ==============================================================
    // ==============================================================
    private void init_components() {
        editText_info = findViewById(R.id.editText_info);

        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, this, this);
        request.add(jsonObjectRequest);
    }
}