package com.example.musiclibrary;

import com.example.musiclibrary.dto.Album;
import com.example.musiclibrary.dto.Artist;
import com.example.musiclibrary.dto.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MusicController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/home")
    public String getArtists(Model model) {
        model.addAttribute("artists", catalogService.getAllArtists());
        model.addAttribute("artist", new Artist());
        return "artists";
    }

    @PostMapping("/artist")
    public String createArtist(@ModelAttribute Artist artist) {
        catalogService.createArtist(artist);
        return "redirect:/home";
    }

    @GetMapping("/artist/{artistId}")
    public String getArtist(@PathVariable String artistId, Model model) {
        model.addAttribute("artist", catalogService.getArtist(artistId));
        model.addAttribute("album", new Album());
        return "artist";
    }

    @PostMapping("/artist/{artistId}/album")
    public String createAlbum(@PathVariable String artistId, @ModelAttribute Album album) {
        catalogService.createAlbum(artistId, album);
        return "redirect:/artist/" + artistId;
    }

    @GetMapping("/artist/{artistId}/album/{albumId}")
    public String getAlbum(Model model, @PathVariable String artistId, @PathVariable String albumId) {
        Artist artist = catalogService.getArtist(artistId);
        Album album = catalogService.getAlbum(artistId, albumId);
        Song song = new Song();

        model.addAttribute("artist", artist);
        model.addAttribute("album", album);
        model.addAttribute("song", song);

        return "album";
    }

    @PostMapping("/artist/{artistId}/album/{albumId}/song")
    public String createSong(@PathVariable String artistId, @PathVariable String albumId, @ModelAttribute Song song) {
        catalogService.createSong(artistId, albumId, song);
        return "redirect:/artist/" + artistId + "/album/" + albumId;
    }

    @GetMapping("/artist/{artistId}/album/{albumId}/song/{songId}")
    public String getSong(@PathVariable String artistId,
                          @PathVariable String albumId,
                          @PathVariable String songId,
                          Model model) {
        Artist artist = catalogService.getArtist(artistId);
        Album album = catalogService.getAlbum(artistId, albumId);
        Song song = catalogService.getSong(artistId, albumId, songId);
        model.addAttribute("artist", artist);
        model.addAttribute("album", album);
        model.addAttribute("song", song);
        return "song";
    }

    @PostMapping("/artist/{artistId}")
    public String deleteArtist(@PathVariable String artistId) {
        catalogService.deleteArtist(artistId);
        return "redirect:/home";
    }

    @PostMapping("/artist/{artistId}/album/{albumId}")
    public String deleteAlbum(@PathVariable String artistId, @PathVariable String albumId) {
        catalogService.deleteAlbum(artistId, albumId);
        return "redirect:/artist/" + artistId;
    }

    @PostMapping("/artist/{artistId}/album/{albumId}/song/{songId}")
    public String deleteSong(@PathVariable String artistId, @PathVariable String albumId, @PathVariable String songId) {
        catalogService.deleteSong(artistId, albumId, songId);
        return "redirect:/artist/" + artistId + "/album/" + albumId;
    }
}
