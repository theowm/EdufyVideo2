package me.theowm.edufyvideo2.Controllers;

import me.theowm.edufyvideo2.Entities.Genre;
import me.theowm.edufyvideo2.Entities.Video;
import me.theowm.edufyvideo2.Services.GenreService;
import me.theowm.edufyvideo2.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/video/genres")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/allgenres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok(genreService.fetchAllGenres());
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/addgenre")
    public ResponseEntity<Genre> addNewGenre(@RequestBody Genre genre) {
        return new ResponseEntity<>(genreService.addNewGenre(genre), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/deletegenre/{genreiId}")
    public ResponseEntity<String> deleteGenreById(@PathVariable UUID genreId){
        genreService.deleteGenre(genreId);
        return ResponseEntity.ok("Genre with id " + genreId + " was deleted");
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/updategenre/{genreId}")
    public ResponseEntity<Genre> updateGenre(@PathVariable UUID genreId, @RequestBody Genre genre){
        return ResponseEntity.ok(genreService.updateGenre(genreId, genre));
    }

}
