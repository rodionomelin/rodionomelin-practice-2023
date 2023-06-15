package org.example.service;

import org.example.entity.AlbumEntity;
import org.example.entity.GroupEntity;
import org.example.entity.TrackEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatalogService {

    private Map<String, GroupEntity> groups = new HashMap<>();

    public GroupEntity getGroup(String id) {
        return groups.get(id);
    }

    public List<GroupEntity> getAllGroups() {
        return new ArrayList<>(groups.values());
    }

    public void addGroup(GroupEntity group) {
        groups.put(group.getId(), group);
    }

    // Для альбомов
    public AlbumEntity getAlbum(String groupId, String albumId) {
        GroupEntity group = getGroup(groupId);
        if (group == null) return null;
        return group.getAlbums().get(albumId);
    }

    public List<AlbumEntity> getAllAlbums(String groupId) {
        GroupEntity group = getGroup(groupId);
        return group != null ? new ArrayList<>(group.getAlbums().values()) : new ArrayList<>();
    }

/* OR

    public List<AlbumEntity> getAllAlbums(String groupId) {
        GroupEntity group = getGroup(groupId);
        if (group != null) {
            return new ArrayList<>(group.getAlbums().values());
        } else {
            return new ArrayList<>();
        }
    }
*/

    public void addAlbum(String groupId, AlbumEntity album) {
        GroupEntity group = getGroup(groupId);
        if (group != null) {
            group.getAlbums().put(album.getId(), album);
        }
    }

    // Для треков
    public TrackEntity getTrack(String groupId, String albumId, String trackId) {
        AlbumEntity album = getAlbum(groupId, albumId);
        if (album == null) return null;
        return album.getTracks().get(trackId);
    }

    public List<TrackEntity> getAllTracks(String groupId, String albumId) {
        AlbumEntity album = getAlbum(groupId, albumId);
        return album != null ? new ArrayList<>(album.getTracks().values()) : new ArrayList<>();
    }

/* OR

    public List<TrackEntity> getAllTracks(String groupId, String albumId) {
        AlbumEntity album = getAlbum(groupId, albumId);
        if (album != null) {
            return new ArrayList<>(album.getTracks().values());
        } else {
            return new ArrayList<>();
        }
    }
*/

    public void addTrack(String groupId, String albumId, TrackEntity track) {
        AlbumEntity album = getAlbum(groupId, albumId);
        if (album != null) {
            album.getTracks().put(track.getId(), track);
        }
    }
}