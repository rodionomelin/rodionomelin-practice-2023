package org.example.controller;

import org.example.entity.AlbumEntity;
import org.example.entity.GroupEntity;
import org.example.entity.TrackEntity;
import org.example.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }


    @GetMapping("/group/{groupId}")
    public GroupEntity getGroup(@PathVariable String groupId) {
        return catalogService.getGroup(groupId);
    }

    @GetMapping("/groups")
    public List<GroupEntity> getAllGroups() {
        return catalogService.getAllGroups();
    }

    @PostMapping("/group")
    public void addGroup(@RequestBody GroupEntity group) {
        catalogService.addGroup(group);
    }

    @GetMapping("/group/{groupId}/album/{albumId}")
    public AlbumEntity getAlbum(@PathVariable String groupId, @PathVariable String albumId) {
        return catalogService.getAlbum(groupId, albumId);
    }

    @GetMapping("/group/{groupId}/albums")
    public List<AlbumEntity> getAllAlbums(@PathVariable String groupId) {
        return catalogService.getAllAlbums(groupId);
    }

    @PostMapping("/group/{groupId}/album")
    public void addAlbum(@PathVariable String groupId, @RequestBody AlbumEntity album) {
        catalogService.addAlbum(groupId, album);
    }

    @GetMapping("/group/{groupId}/album/{albumId}/track/{trackId}")
    public TrackEntity getTrack(@PathVariable String groupId, @PathVariable String albumId, @PathVariable String trackId) {
        return catalogService.getTrack(groupId, albumId, trackId);
    }

    @GetMapping("/group/{groupId}/album/{albumId}/tracks")
    public List<TrackEntity> getAllTracks(@PathVariable String groupId, @PathVariable String albumId) {
        return catalogService.getAllTracks(groupId, albumId);
    }

    @PostMapping("/group/{groupId}/album/{albumId}/track")
    public void addTrack(@PathVariable String groupId, @PathVariable String albumId, @RequestBody TrackEntity track) {
        catalogService.addTrack(groupId, albumId, track);
    }
}