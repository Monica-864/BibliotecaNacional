package com.example.bibliotecanacional.view;

import android.app.SearchManager;
import android.content.ComponentName;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.splashscreen.SplashScreen;

import com.example.bibliotecanacional.R;

public class MainActivity extends AppCompatActivity {

    SearchView buscadorLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buscadorLibros = findViewById(R.id.buscadorLibros);

        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        ComponentName componentName = new ComponentName(this,SearchableActivity.class);
        buscadorLibros.setSearchableInfo(searchManager.getSearchableInfo(componentName));
        buscadorLibros.setIconifiedByDefault(false);

    }
}