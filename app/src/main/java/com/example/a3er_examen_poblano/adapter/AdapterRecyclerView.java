package com.example.a3er_examen_poblano.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3er_examen_poblano.R;
import com.example.a3er_examen_poblano.models.Mochila;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewItem> {

    private ArrayList<Mochila> arrayList;

    public AdapterRecyclerView(ArrayList<Mochila> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_list_mochila, null, false
        );
        return new ViewItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewItem holder, int position) {
        Mochila mochila = this.arrayList.get(position);
        holder.set_data(mochila);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewItem extends RecyclerView.ViewHolder{

        TextView textView_item_id, textView_item_nombre, textView_item_costo, textView_item_foto;

        public ViewItem(@NonNull View itemView) {
            super(itemView);
            init_components(itemView);
        }

        private void init_components(View itemView) {
            textView_item_id = itemView.findViewById(R.id.textView_item_id);
            textView_item_nombre = itemView.findViewById(R.id.textView_item_nombre);
            textView_item_costo = itemView.findViewById(R.id.textView_item_costo);
            textView_item_foto = itemView.findViewById(R.id.textView_item_foto);
        }

        public void set_data(Mochila mochila) {
            textView_item_id.setText(mochila.getId());
            textView_item_nombre.setText(mochila.getNombre());
            textView_item_costo.setText("$ "+mochila.getCost());
            textView_item_foto.setText(mochila.getFoto());
        }
    }
}
