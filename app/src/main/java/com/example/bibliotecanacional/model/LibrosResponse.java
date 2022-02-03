package com.example.bibliotecanacional.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LibrosResponse {

    @SerializedName("error")
    @Expose
    String error;

    @SerializedName("total")
    @Expose
    String total;

    @SerializedName("page")
    @Expose
    String page;

    @SerializedName("books")
    @Expose
    List<Libro> books ;


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Libro> getBooks() {
        return books;
    }

    public void setBooks(List<Libro> books) {
        this.books = books;
    }
}
