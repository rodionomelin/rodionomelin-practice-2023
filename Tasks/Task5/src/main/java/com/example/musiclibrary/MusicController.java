package com.example.musiclibrary;

import com.example.musiclibrary.dto.Album;
import com.example.musiclibrary.dto.Artist;
import com.example.musiclibrary.dto.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MusicController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/home")
    public Collection<Artist> getAllArtists() {
        return catalogService.getAllArtists();
    }

    @GetMapping("/artist/{artistId}")
    public Artist getArtist(@PathVariable String artistId) {
        return catalogService.getArtist(artistId);
    }

    @PostMapping("/artist")
    public Artist createArtist(@RequestBody Artist artist) {
        return catalogService.createArtist(artist);
    }

    @DeleteMapping("/artist/{artistId}")
    public void deleteArtist(@PathVariable String artistId) {
        catalogService.deleteArtist(artistId);
    }

    @PostMapping("/artist/{artistId}/album")
    public Album createAlbum(@PathVariable String artistId, @RequestBody Album album) {
        return catalogService.createAlbum(artistId, album);
    }

    @GetMapping("/artist/{artistId}/album/{albumId}")
    public Album getAlbum(@PathVariable String artistId, @PathVariable String albumId) {
        return catalogService.getAlbum(artistId, albumId);
    }

    @DeleteMapping("/artist/{artistId}/album/{albumId}")
    public void deleteAlbum(@PathVariable String artistId, @PathVariable String albumId) {
        catalogService.deleteAlbum(artistId, albumId);
    }

    @PostMapping("/artist/{artistId}/album/{albumId}/song")
    public Song createSong(@PathVariable String artistId,
                           @PathVariable String albumId,
                           @RequestBody Song song) {
        return catalogService.createSong(artistId, albumId, song);
    }

    @GetMapping("/artist/{artistId}/album/{albumId}/song/{songId}")
    public Song getSong(@PathVariable String artistId,
                        @PathVariable String albumId,
                        @PathVariable String songId) {
        return catalogService.getSong(artistId, albumId, songId);
    }

    @DeleteMapping("/artist/{artistId}/album/{albumId}/song/{songId}")
    public void deleteSong(@PathVariable String artistId,
                           @PathVariable String albumId,
                           @PathVariable String songId) {
        catalogService.deleteSong(artistId, albumId, songId);
    }
}