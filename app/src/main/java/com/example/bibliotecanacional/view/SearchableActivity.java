package com.example.bibliotecanacional.view;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bibliotecanacional.R;
import com.example.bibliotecanacional.model.Libro;
import com.example.bibliotecanacional.presenter.ISearchableActivityPresenter;
import com.example.bibliotecanacional.presenter.SearchableActivityPresenter;

import java.util.List;

public class SearchableActivity extends AppCompatActivity implements ISearchableActivity {

    TextView tvLibros;
    RecyclerView rvLibros;
    ProgressBar progressBar;

    ISearchableActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.libros_busqueda);

        tvLibros    = findViewById(R.id.tvLibros);
        rvLibros    = findViewById(R.id.rvLibros);
        progressBar = findViewById(R.id.progressBar);

        Intent intent = getIntent();
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            presenter = new SearchableActivityPresenter(this,query,getBaseContext());
        }
    }

    @Override
    public void inicializarRv(List<Libro> libros) {
        progressBar.setVisibility(View.INVISIBLE);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rvLibros.setLayoutManager(linearLayoutManager);

        RvLibrosAdaptador rvLibrosAdaptador = new RvLibrosAdaptador(this, libros);
        rvLibros.setAdapter(rvLibrosAdaptador);
    }

    @Override
    public void mostrarMensajeSinResultados() {
        progressBar.setVisibility(View.INVISIBLE);
        tvLibros.setText(R.string.sin_resultados);
    }
}
