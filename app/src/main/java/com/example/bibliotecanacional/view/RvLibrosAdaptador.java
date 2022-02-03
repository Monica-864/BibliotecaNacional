package com.example.bibliotecanacional.view;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bibliotecanacional.R;
import com.example.bibliotecanacional.model.Libro;

import java.util.List;

public class RvLibrosAdaptador extends RecyclerView.Adapter<RvLibrosAdaptador.ViewHolderLibro> {

    Activity activity;
    List<Libro> libros;

    public RvLibrosAdaptador(Activity activity, List<Libro> libros) {

        this.activity    = activity;
        this.libros      = libros;
    }

    @NonNull
    @Override
    public ViewHolderLibro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.tv_libro,parent,false);
        return new ViewHolderLibro(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLibro holder, int position) {

        Libro libro = libros.get(position);
        
        holder.tvNombreLibro.setText(libro.getTitle());
        holder.tvNombreLibro.setOnClickListener(v -> {
            Intent intent = new Intent(activity,DetalleLibro.class);
            intent.putExtra("nombre",       libro.getTitle());
            intent.putExtra("descripcion",  libro.getSubtitle());
            intent.putExtra("isbn13",       libro.getIsbn13());
            intent.putExtra("precio",       libro.getPrice());
            intent.putExtra("url imagen",   libro.getImage());
            intent.putExtra("url libro",    libro.getUrl());
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    protected static class ViewHolderLibro extends RecyclerView.ViewHolder {

        private final TextView tvNombreLibro;

        public ViewHolderLibro(@NonNull View itemView) {
            super(itemView);

            tvNombreLibro = itemView.findViewById(R.id.tvNombreLibro);
        }
    }
}
