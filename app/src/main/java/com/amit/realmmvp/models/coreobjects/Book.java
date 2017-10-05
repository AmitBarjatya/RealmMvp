package com.amit.realmmvp.models.coreobjects;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Amit Barjatya on 10/4/17.
 */

public class Book extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    private String author;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
