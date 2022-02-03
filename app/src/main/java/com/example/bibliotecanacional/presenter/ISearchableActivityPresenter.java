package com.example.bibliotecanacional.presenter;

public interface ISearchableActivityPresenter {

    void obtenerLibros(String query);
    void mostrarLibrosRV();
    void sinResultados();
}
