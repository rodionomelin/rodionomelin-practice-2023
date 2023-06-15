package com.example.musiclibrary;


import com.example.musiclibrary.dto.Album;
import com.example.musiclibrary.dto.Artist;
import com.example.musiclibrary.dto.Song;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatalogService {

    private final Map<String, Artist> artistMap = new HashMap<>();

    public Collection<Artist> getAllArtists() {
        return artistMap.values();
    }

    public Artist getArtist(String id) {
        return artistMap.get(id);
    }

    public Artist createArtist(Artist artist) {
        artistMap.put(artist.getId(), artist);
        return artist;
    }

    public void deleteArtist(String id) {
        artistMap.remove(id);
    }

    public Album createAlbum(String artistId, Album album) {
        Artist artist = artistMap.get(artistId);
        if (artist != null) {
            artist.getAlbums().add(album);
            return album;
        }
        return null;
    }

    public Album getAlbum(String artistId, String albumId) {
        Artist artist = artistMap.get(artistId);
        if (artist != null) {
            return artist.getAlbums().stream()
                    .filter(album -> album.getId().equals(albumId))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public void deleteAlbum(String artistId, String albumId) {
        Artist artist = artistMap.get(artistId);
        if (artist != null) {
            artist.getAlbums().removeIf(album -> album.getId().equals(albumId));
        }
    }

    public Song createSong(String artistId, String albumId, Song song) {
        Album album = getAlbum(artistId, albumId);
        if (album != null) {
            album.getSongs().add(song);
            return song;
        }
        return null;
    }

    public Song getSong(String artistId, String albumId, String songId) {
        Album album = getAlbum(artistId, albumId);
        if (album != null) {
            return album.getSongs().stream()
                    .filter(song -> song.getId().equals(songId))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public void deleteSong(String artistId, String albumId, String songId) {
        Album album = getAlbum(artistId, albumId);
        if (album != null) {
            album.getSongs().removeIf(song -> song.getId().equals(songId));
        }
    }
}
