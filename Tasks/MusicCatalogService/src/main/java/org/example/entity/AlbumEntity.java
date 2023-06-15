package org.example.entity;

import java.util.HashMap;
import java.util.Map;

public class AlbumEntity {
    private String id;
    private String name;
    private int year;
    private Map<String, TrackEntity> tracks = new HashMap<>();

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public Map<String, TrackEntity> getTracks() {
        return tracks;
    }

    public void setTracks(Map<String, TrackEntity> tracks) {
        this.tracks = tracks;
    }
}
