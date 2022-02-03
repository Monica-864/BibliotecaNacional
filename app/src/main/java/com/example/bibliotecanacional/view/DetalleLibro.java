package com.example.bibliotecanacional.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bibliotecanacional.R;
import com.squareup.picasso.Picasso;

public class DetalleLibro extends AppCompatActivity {

    TextView tvNombre,tvDescripcion,tvIsbn13,tvPrecio,tvUrlLibro;
    ImageView ivImagen;
    String nombre,descripcion,isbn13,precio,urlImagen,urlLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_libro);

        tvNombre        = findViewById(R.id.tvNombre);
        tvDescripcion   = findViewById(R.id.tvDescripcion);
        tvIsbn13        = findViewById(R.id.tvIsbn13);
        tvPrecio        = findViewById(R.id.tvPrecio);
        tvUrlLibro      = findViewById(R.id.tvUrlLibro);
        ivImagen        = findViewById(R.id.ivLibro);

        Intent intent   = getIntent();
        nombre          = intent.getStringExtra("nombre");
        descripcion     = intent.getStringExtra("descripcion");
        isbn13          = intent.getStringExtra("isbn13");
        precio          = intent.getStringExtra("precio");
        urlImagen       = intent.getStringExtra("url imagen");
        urlLibro        = intent.getStringExtra("url libro");

        tvNombre.setText(nombre);
        tvDescripcion.setText(descripcion);
        tvIsbn13.setText(getString(R.string.isbn,isbn13));
        tvPrecio.setText(getString(R.string.precio,precio));
        tvUrlLibro.setText(urlLibro);

        Picasso.get().load(urlImagen).into(ivImagen);

    }
}