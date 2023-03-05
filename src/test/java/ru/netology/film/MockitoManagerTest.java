package ru.netology.film;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doReturn;

public class MockitoManagerTest {

    FilmsRepository repo = Mockito.mock(FilmsRepository.class);
    ManagerOfFilms manager = new ManagerOfFilms(repo);
    DataFilm film1 = new DataFilm("John Wick", "Keanu Reeves", 2014, 1);
    DataFilm film2 = new DataFilm("John Wick: Chapter 2 John Wick", "Keanu Reeves", 2017, 2);
    DataFilm film3 = new DataFilm("John Wick: Chapter 3", "Keanu Reeves", 2019, 3);
    DataFilm film4 = new DataFilm("The Matrix Reloaded", "Keanu Reeves", 2003, 4);
    DataFilm film5 = new DataFilm("The Matrix Revolutions", "Keanu Reeves", 2003, 5);

    @Test
    public void ManagerOfFilmsTest() {
        DataFilm[] expected = {film1, film2, film3, film4, film5};
        doReturn(expected).when(repo).findAll();
        Assertions.assertArrayEquals(expected, manager.findAllFilms());
    }

    @Test
    public void reversedAllFilmsTest() {
        DataFilm[] films = {film5, film4, film3, film2, film1};
        Mockito.when(repo.reversAll()).thenReturn(films);
        Assertions.assertArrayEquals(films, manager.reversedAllFilms());
    }

    @Test
    public void findFilmByIdTest() {
        DataFilm[] films = {film1, film2, film3, film4, film5};
        DataFilm expected = film3;
        Mockito.when(repo.findById(3)).thenReturn(expected);
        Assertions.assertEquals(expected, manager.findFilmById(3));
    }

    @Test
    public void removeAllFilmsTest() {
        DataFilm[] films = {film1, film2, film3, film4, film5};
        DataFilm[] expected = new DataFilm[0];
        repo.removeAll();
        Mockito.when(repo.findAll()).thenReturn(expected);
        Assertions.assertArrayEquals(expected, manager.findAllFilms());
    }

    @Test
    public void removeFilmByIdTest() {
        DataFilm[] films = {film1, film2, film3, film4, film5};
        repo.removeById(3);
        DataFilm[] expected = {film1, film3, film4, film5};
        Mockito.when(repo.findAll()).thenReturn(expected);
        Assertions.assertArrayEquals(expected, manager.findAllFilms());
    }

}

