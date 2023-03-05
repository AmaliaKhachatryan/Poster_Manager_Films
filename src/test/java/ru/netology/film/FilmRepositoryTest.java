package ru.netology.film;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilmRepositoryTest {
    DataFilm film1 = new DataFilm("John Wick", "Keanu Reeves", 2014, 1);
    DataFilm film2 = new DataFilm("John Wick: Chapter 2 John Wick", "Keanu Reeves", 2017, 2);
    DataFilm film3 = new DataFilm("John Wick: Chapter 3", "Keanu Reeves", 2019, 3);
    DataFilm film4 = new DataFilm("The Matrix Reloaded", "Keanu Reeves", 2003, 4);
    DataFilm film5 = new DataFilm("The Matrix Revolutions", "Keanu Reeves", 2003, 5);
    DataFilm film6 = new DataFilm("The Matrix Resurrections", "Keanu Reeves", 2021, 6);
    DataFilm film7 = new DataFilm("The Devil's Advocate", "Keanu Reeves", 1997, 7);
    DataFilm film8 = new DataFilm("The Matrix", "Keanu Reeves", 1999, 8);
    DataFilm film9 = new DataFilm("Sweet November", "Keanu Reeves", 2001, 9);
    DataFilm film10 = new DataFilm("Parenthood", "Keanu Reeves", 1989, 10);
    DataFilm film11 = new DataFilm("The Matrix: Reloaded", "Keanu Reeves", 2003, 11);
    DataFilm film12 = new DataFilm("Constantine", "Keanu Reeves", 2005, 12);
    FilmsRepository repo = new FilmsRepository();

    @Test
    public void getSaveTest() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);
        repo.save(film6);
        repo.save(film7);
        repo.save(film8);
        repo.save(film9);
        repo.save(film10);
        repo.save(film11);
        repo.save(film12);
        DataFilm[] expected = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void getRemoveTest() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);
        repo.save(film6);
        repo.save(film7);
        repo.save(film8);
        repo.save(film9);
        repo.save(film10);
        repo.save(film11);
        repo.save(film12);
        repo.removeById(12);
        DataFilm[] expected = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void reversListOfFilmsTest() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        DataFilm[] expected = {film3, film2, film1};
        Assertions.assertArrayEquals(expected, repo.reversAll());

    }

    @Test
    public void listOfLastFilmsTest() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);
        repo.save(film6);
        repo.save(film7);
        repo.save(film8);
        repo.save(film9);
        repo.save(film10);
        repo.save(film11);
        repo.save(film12);
        DataFilm[] expected = {film12, film11, film10, film9, film8, film7, film6, film5, film4, film3};
        Assertions.assertArrayEquals(expected, repo.listOfLastFilms());
    }

    @Test
    public void removeListFilmsTest() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);
        repo.save(film6);
        DataFilm[] expected = new DataFilm[0];
        repo.removeAll();
        Assertions.assertArrayEquals(expected, repo.findAll());

    }

    @Test
    public void findById() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);
        repo.save(film6);
        DataFilm expected = film3;
        DataFilm actual=repo.findById(3);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void findByIdNull() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);
        repo.save(film6);
        DataFilm actual=repo.findById(7);
        Assertions.assertEquals(null, actual);
    }
    @Test
    public void getRemoveCenterTest() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);
        repo.save(film6);
        repo.save(film7);
        repo.removeById(5);
        DataFilm[] expected = {film1, film2, film3, film4,film6, film7};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }
}