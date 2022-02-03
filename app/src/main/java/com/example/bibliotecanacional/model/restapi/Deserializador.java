package com.example.bibliotecanacional.model.restapi;

import com.example.bibliotecanacional.model.Libro;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Deserializador implements JsonDeserializer<ArrayList<Libro>>{

    //Deserializador personalizado par obtener únicamente el arreglo de libros de la respuesta json
        @Override
        public ArrayList<Libro> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        return deserializarLibrosDeJson(jsonObject);
    }

    private ArrayList<Libro> deserializarLibrosDeJson(JsonObject jsonObject) {

        ArrayList<Libro> libros = new ArrayList<>();
        JsonArray books = jsonObject.getAsJsonArray("books");

        for (int i=0;i<books.size();i++) {

            JsonObject numeroLibro = books.get(i).getAsJsonObject(); //0-9

            String title    = numeroLibro.get("title").getAsString();
            String subtitle = numeroLibro.get("subtitle").getAsString();
            String isbn13   = numeroLibro.get("isbn13").getAsString();
            String price    = numeroLibro.get("price").getAsString();
            String image    = numeroLibro.get("image").getAsString();
            String url      = numeroLibro.get("url").getAsString();

            Libro libro = new Libro(title,subtitle,isbn13,price,image,url);
            libros.add(libro);
        }
        return libros;
    }

    public Gson construirGsonDeserializador(){

        Type arrayListType = new TypeToken<ArrayList<Libro>>() {}.getType();
        return new GsonBuilder().registerTypeAdapter(arrayListType, new Deserializador()).create();
    }
}
