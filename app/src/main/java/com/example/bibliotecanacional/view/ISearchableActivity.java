package com.example.bibliotecanacional.view;

import com.example.bibliotecanacional.model.Libro;

import java.util.List;

public interface ISearchableActivity {
    
    void inicializarRv(List<Libro> libros);
    void mostrarMensajeSinResultados();
}
