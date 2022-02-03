package com.example.bibliotecanacional.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.bibliotecanacional.model.Libro;
import com.example.bibliotecanacional.model.LibrosResponse;
import com.example.bibliotecanacional.model.restapi.RestApiAdaptador;
import com.example.bibliotecanacional.model.restapi.RestApiBiblioteca;
import com.example.bibliotecanacional.view.ISearchableActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchableActivityPresenter implements ISearchableActivityPresenter {

    private final ISearchableActivity iSearchableActivity;

    LibrosResponse librosResponse;
    List<Libro> libros;
    Context context;

    public SearchableActivityPresenter(ISearchableActivity iSearchableActivity, String query, Context context) {

        this.iSearchableActivity = iSearchableActivity;
        this.context = context;
        obtenerLibros(query);
    }

    @Override
    public void obtenerLibros(String query) {
        RestApiBiblioteca service   = new RestApiAdaptador().establecerConexionRestApiBiblioteca();
        Call<LibrosResponse> call   = service.obtenerLibros(query);

        call.enqueue(new Callback<LibrosResponse>() {
            @Override
            public void onResponse(Call<LibrosResponse> call, Response<LibrosResponse> response) {
                //Toast.makeText(context, "Solicitud exitosa " +response.body(),Toast.LENGTH_SHORT).show();
                librosResponse  = response.body();
                assert librosResponse != null;
                libros          = librosResponse.getBooks();

                if (libros.isEmpty()){sinResultados();}
                else{mostrarLibrosRV();}
            }

            @Override
            public void onFailure(Call<LibrosResponse> call, Throwable t) {
                Toast.makeText(context, "Error",Toast.LENGTH_SHORT).show();
                Log.d("ERROR SOLICITUD API","",t);
            }
        });
    }

    @Override
    public void mostrarLibrosRV() {
        iSearchableActivity.inicializarRv(libros);
    }

    @Override
    public void sinResultados() {
        iSearchableActivity.mostrarMensajeSinResultados();
    }
}
