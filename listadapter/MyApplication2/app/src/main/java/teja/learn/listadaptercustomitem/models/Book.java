package teja.learn.listadaptercustomitem.models;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by SERAGUD on 2016-12-06.
 */

public class Book implements Serializable {
    @NonNull
    private String name;

    @NonNull
    private String author;

    public Book() {
        name = "";
        author = "";
    }

    public Book(@NonNull String name, @NonNull String author) {
        this.name = name;
        this.author = author;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    public void setAuthor(@NonNull String author) {
        this.author = author;
    }

    public String toString() {
        return "Book named " + name + " is written by " + author + ".";
    }
}
