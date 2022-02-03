package com.example.bibliotecanacional.model.restapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdaptador {

    public RestApiBiblioteca establecerConexionRestApiBiblioteca(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.itbook.store/1.0/")
                .addConverterFactory(GsonConverterFactory.create())
                // Si se desea utilizar el deserializador personalizdo:
                //.addConverterFactory(GsonConverterFactory.create(new Deserializador().construirGsonDeserializador()))
                .build();

        return retrofit.create(RestApiBiblioteca.class);
    }
}
