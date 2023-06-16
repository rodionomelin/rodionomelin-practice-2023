package com.example.musiclibrary;


import com.example.musiclibrary.dto.Album;
import com.example.musiclibrary.dto.Artist;
import com.example.musiclibrary.dto.Song;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatalogService {

    private Map<String, Artist> artists = new HashMap<>();

    public Collection<Artist> getAllArtists() {
        return artists.values();
    }

    public Artist getArtist(String artistId) {
        return artists.get(artistId);
    }

    public Artist createArtist(Artist artist) {
        artists.put(artist.getId(), artist);
        return artist;
    }

    public void deleteArtist(String artistId) {
        artists.remove(artistId);
    }

    public Album createAlbum(String artistId, Album album) {
        Artist artist = artists.get(artistId);
        if (artist != null) {
            List<Album> albums = artist.getAlbums();
            if (albums == null) {
                albums = new ArrayList<>();
                artist.setAlbums(albums);
            }
            albums.add(album);
            return album;
        }
        return null;
    }

    public Album getAlbum(String artistId, String albumId) {
        Artist artist = artists.get(artistId);
        if (artist != null) {
            for (Album album : artist.getAlbums()) {
                if (album.getId().equals(albumId)) {
                    return album;
                }
            }
        }
        return null;
    }

    public void deleteAlbum(String artistId, String albumId) {
        Artist artist = artists.get(artistId);
        if (artist != null) {
            artist.getAlbums().removeIf(album -> album.getId().equals(albumId));
        }
    }

    public Song createSong(String artistId, String albumId, Song song) {
        Album album = getAlbum(artistId, albumId);
        if (album != null) {
            List<Song> songs = album.getSongs();
            if (songs == null) {
                songs = new ArrayList<>();
                album.setSongs(songs);
            }
            songs.add(song);
            return song;
        }
        return null;
    }

    public Song getSong(String artistId, String albumId, String songId) {
        Album album = getAlbum(artistId, albumId);
        if (album != null) {
            for (Song song : album.getSongs()) {
                if (song.getId().equals(songId)) {
                    return song;
                }
            }
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
