package com.example.bibliotecanacional.model.restapi;

import com.example.bibliotecanacional.model.LibrosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApiBiblioteca {

    @GET("search/{query}")
    Call<LibrosResponse> obtenerLibros(@Path("query") String query);
    // Si se desea utilizar el deserializador personalizdo:
    // Call<ArrayList<Libro>> obtenerLibros(@Path("query") String query);
}
