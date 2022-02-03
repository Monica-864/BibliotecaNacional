package com.example.bibliotecanacional.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Libro {

    @SerializedName("title")
    @Expose
    String title;

    @SerializedName("subtitle")
    @Expose
    String subtitle;

    @SerializedName("isbn13")
    @Expose
    String isbn13;

    @SerializedName("price")
    @Expose
    String price;

    @SerializedName("image")
    @Expose
    String image;

    @SerializedName("url")
    @Expose
    String url;

    public Libro(String title, String subtitle, String isbn13, String price, String image, String url) {
        this.title = title;
        this.subtitle = subtitle;
        this.isbn13 = isbn13;
        this.price = price;
        this.image = image;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
