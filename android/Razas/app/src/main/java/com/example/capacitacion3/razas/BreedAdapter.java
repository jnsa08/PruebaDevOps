package com.example.capacitacion3.razas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * Created by capacitacion3 on 16-03-18.
 */

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.ViewHolder>{

    // Datasource de razas
    private String[] breeds;

    private AdapterView.OnItemClickListener onItemClickListener;

    // Construimos el adaptador con un array de cities
    public BreedAdapter(AdapterView.OnItemClickListener onItemClickListener, String[] breeds) {
        this.onItemClickListener = onItemClickListener;
        this.breeds = breeds;
    }



    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Obtenemos el layout que utilizaremos como celda
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_breed, parent, false);

        return new ViewHolder(view);
    }

    // Pintamos los datos en la vista
    @Override public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.textViewBreed.setText(breeds[position]);
        holder.textViewBreed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(null,view,position, view.getId());
            }
        });



    }

    // Retornamos el número de elementos
    @Override public int getItemCount() {
        return breeds.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewBreed;

        public ViewHolder(View itemView) {
            super(itemView);

            // Referenciamos el elemento de la vista textViewBreed
            textViewBreed = itemView.findViewById(R.id.textViewBreed);
        }
    }

}
