package me.theowm.edufyvideo2.Services;

import me.theowm.edufyvideo2.Entities.Genre;
import me.theowm.edufyvideo2.Repositories.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenreServiceTest {

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreService genreService;

    private Genre genre;
    private UUID genreId;

    @BeforeEach
    void setUp() {
        genre = new Genre();
        genre.setName("Educational");

        genreId = UUID.randomUUID();
    }

    @Test
    void fetchAllGenres_shouldReturnList() {
        when(genreRepository.findAll()).thenReturn(List.of(genre));

        List<Genre> result = genreService.fetchAllGenres();

        assertEquals(1, result.size());
        assertEquals("Educational", result.get(0).getName());
        verify(genreRepository).findAll();
    }

    @Test
    void addNewGenre_shouldSaveGenre() {
        when(genreRepository.save(genre)).thenReturn(genre);

        Genre result = genreService.addNewGenre(genre);

        assertNotNull(result);
        assertEquals("Educational", result.getName());
        verify(genreRepository).save(genre);
    }

    @Test
    void updateGenre_shouldSaveGenre() {
        when(genreRepository.save(genre)).thenReturn(genre);

        Genre result = genreService.updateGenre(genreId, genre);

        assertEquals("Educational", result.getName());
        verify(genreRepository).save(genre);
    }

    @Test
    void deleteGenre_shouldInvokeDeleteById() {
        doNothing().when(genreRepository).deleteById(genreId);

        genreService.deleteGenre(genreId);

        verify(genreRepository).deleteById(genreId);
    }
}