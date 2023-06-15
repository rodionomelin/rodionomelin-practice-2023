# Music Catalog API Documentation
Below is a guide on how to use the API:   
### Create a Group   
Send a POST request to http://localhost:8080/api/group with the following JSON structure:
```json
{
   "id": "<group_id>",
   "name": "<group_name>"
}
```
### Create an Album:
To create an album for a particular group, send a POST request to http://localhost:8080/api/group/<group_id>/album with the following JSON structure:
```json
{
   "id": "<album_id>",
   "name": "<album_name>",
   "year": <year_of_release>
}
```

### Add a Track to an Album
To add a track to a particular album of a group, send a POST request to http://localhost:8080/api/group/<group_id>/album/<album_id>/track with the following JSON structure:
```json
{
  "id": "<track_id>",
  "name": "<track_name>",
  "duration": "<track_duration>"
}
```
example:   
```json
{
  "id": "1",
  "name": "track_aria1",
  "duration": "PT551S" // duration is 551 sec
}
```

### Retrieve an Album

To get the details of an album of a particular group, send a GET request to http://localhost:8080/api/group/<group_id>/album/<album_id>

### Retrieve all Groups
To get the details of all groups, send a GET request to http://localhost:8080/api/groups

### Retrieve all Albums of a Group
To get the details of all albums of a group, send a GET request to http://localhost:8080/api/group/<group_id>/albums

### Retrieve all Tracks of an Album
To get the details of all tracks of an album of a group, send a GET request to http://localhost:8080/api/group/<group_id>/album/<album_id>/tracks
