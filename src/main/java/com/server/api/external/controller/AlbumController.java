package com.server.api.external.controller;

import com.server.api.external.model.Album;
import com.server.api.external.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    public ResponseEntity<Object> getAllAlbums() {
        try {
            Object result = this.albumService.getAllAlbums();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/albums")
    public ResponseEntity<Object> createAlbum(@RequestBody Album body) {
        try {
            Object result = this.albumService.createAlbum(body);
            return new ResponseEntity<>( result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
