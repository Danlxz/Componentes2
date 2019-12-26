package com.example.componentes2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    // Dataset que son los datos que se pretende mostrar en RecyclerView
    private List<Item> dataset;

    public CustomAdapter(List dataset) {
        this.dataset = dataset;
    }

    // Clase interna que permite obtener referencias de los componentes visuales de cada elemento de la lista
    // ejemplo textview, edittext, etc.
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imguser;
        TextView titulo, fecha, contenido;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imguser = itemView.findViewById(R.id.imgUser);
            titulo = itemView.findViewById(R.id.title);
            fecha = itemView.findViewById(R.id.date);
            contenido = itemView.findViewById(R.id.contenido);
        }
    }

    // El layout manager invoca este método para renderizar cada elemento del RecyclerView
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // creamos una nueva vista
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(v);
    }

    // Enlaza nuestra data con cada ViewHolder, en otras palabras
    // Este método reemplaza el contenido de cada view, para cada elemento de la lista
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido de los views según tales datos
        holder.imguser.setImageResource(dataset.get(position).getUserPhoto());
        holder.titulo.setText(dataset.get(position).getTitle());
        holder.fecha.setText(dataset.get(position).getDate());
        holder.contenido.setText(dataset.get(position).getContent());
    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejemplo si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return dataset.size();
    }

}
