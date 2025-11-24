package me.theowm.edufyvideo2.Services;

import me.theowm.edufyvideo2.Entities.Genre;
import me.theowm.edufyvideo2.Repositories.GenreRepository;
import me.theowm.edufyvideo2.Repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GenreService implements GenreServiceInterface{

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public List<Genre> fetchAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre addNewGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre updateGenre(UUID id, Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(UUID id) {
        genreRepository.deleteById(id);
    }
}
