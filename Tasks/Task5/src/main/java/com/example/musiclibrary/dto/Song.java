package com.example.musiclibrary.dto;

public class Song {
    private String id;
    private String name;
    private String length;

    // getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }
    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}
