package com.example.musiclibrary;

import com.example.musiclibrary.dto.Album;
import com.example.musiclibrary.dto.Artist;
import com.example.musiclibrary.dto.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ApiController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/api/artists")
    public Collection<Artist> getAllArtists() {
        return catalogService.getAllArtists();
    }

    @PostMapping("/api/artist")
    public Artist createArtist(@RequestBody Artist artist) {
        return catalogService.createArtist(artist);
    }

    @DeleteMapping("/api/artist/{artistId}")
    public void deleteArtist(@PathVariable String artistId) {
        catalogService.deleteArtist(artistId);
    }

    @PostMapping("/api/artist/{artistId}/album")
    public Album createAlbum(@PathVariable String artistId, @RequestBody Album album) {
        return catalogService.createAlbum(artistId, album);
    }

    @DeleteMapping("/api/artist/{artistId}/album/{albumId}")
    public void deleteAlbum(@PathVariable String artistId, @PathVariable String albumId) {
        catalogService.deleteAlbum(artistId, albumId);
    }

    @PostMapping("/api/artist/{artistId}/album/{albumId}/song")
    public Song createSong(@PathVariable String artistId, @PathVariable String albumId, @RequestBody Song song) {
        return catalogService.createSong(artistId, albumId, song);
    }

    @DeleteMapping("/api/artist/{artistId}/album/{albumId}/song/{songId}")
    public void deleteSong(@PathVariable String artistId, @PathVariable String albumId, @PathVariable String songId) {
        catalogService.deleteSong(artistId, albumId, songId);
    }
}
