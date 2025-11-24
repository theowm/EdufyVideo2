package me.theowm.edufyvideo2.Services;

import me.theowm.edufyvideo2.Entities.Genre;
import me.theowm.edufyvideo2.Entities.Video;

import java.util.List;
import java.util.UUID;

public interface GenreServiceInterface {
    List<Genre> fetchAllGenres();
    Genre addNewGenre(Genre genre);
    Genre updateGenre(UUID id, Genre genre);
    void deleteGenre(UUID id);
}
