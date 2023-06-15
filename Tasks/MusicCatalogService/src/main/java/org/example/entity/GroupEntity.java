package org.example.entity;

import java.util.HashMap;
import java.util.Map;

public class GroupEntity {
    private String id;
    private String name;
    private Map<String, AlbumEntity> albums = new HashMap<>();

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

    public void setAlbums(Map<String, AlbumEntity> albums) {
        this.albums = albums;
    }

    public Map<String, AlbumEntity> getAlbums() {
        return albums;
    }
}
