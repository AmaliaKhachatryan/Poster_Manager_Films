package ru.netology.film;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ManagerOfFilmsTest {
    FilmsRepository repo = new FilmsRepository();
    ManagerOfFilms manager=new ManagerOfFilms(repo);
    DataFilm film1 = new DataFilm("John Wick", "Keanu Reeves", 2014, 1);
    DataFilm film2 = new DataFilm("John Wick: Chapter 2 John Wick", "Keanu Reeves", 2017, 2);
    DataFilm film3 = new DataFilm("John Wick: Chapter 3", "Keanu Reeves", 2019, 3);
    DataFilm film4 = new DataFilm("The Matrix Reloaded", "Keanu Reeves", 2003, 4);
    DataFilm film5 = new DataFilm("The Matrix Revolutions", "Keanu Reeves", 2003, 5);

@BeforeEach
    public void setUp(){
    manager.saveFilms(film1);
    manager.saveFilms(film2);
    manager.saveFilms(film3);
    manager.saveFilms(film4);
    manager.saveFilms(film5);
}
   @Test
   public void ManagerOfFilmsTest(){
    DataFilm[] expected={film1, film2, film3, film4, film5};
    Assertions.assertArrayEquals(expected,manager.findAllFilms());
}
    @Test
    public void reversedAllFilmsTest(){
        manager.reversedAllFilms();
        DataFilm[]expected= {film5, film4, film3, film2, film1};
        Assertions.assertArrayEquals(expected,manager.reversedAllFilms());
    }
    @Test
    public void findFilmByIdTest(){
        DataFilm expected= film4;
        DataFilm actual=manager.findFilmById(4);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void removeAllFilmsTest(){
        manager.removeAllFilms();
        DataFilm[]expected=new DataFilm[0];
        Assertions.assertArrayEquals(expected,manager.findAllFilms());
    }
    @Test
    public void removeFilmByIdTest(){
        manager.removeFilmById(2);
        DataFilm[]expected={film1, film3, film4, film5};
        Assertions.assertArrayEquals(expected,manager.findAllFilms());
    }
    @Test
    public void listOfLastFilmsTest(){
        manager.saveFilms(film1);
        manager.saveFilms(film2);
        manager.saveFilms(film3);
        manager.saveFilms(film4);
        manager.saveFilms(film5);
        manager.saveFilms(film1);
        manager.saveFilms(film2);
        manager.saveFilms(film3);
        manager.saveFilms(film4);
        manager.saveFilms(film5);
        DataFilm[]expected={film5, film4, film3, film2,film1,film5, film4, film3, film2,film1,};
        Assertions.assertArrayEquals(expected, manager.listOfLastFilms());
    }
    @Test
    public void listOfLastFilmsConstrictorTest(){
        FilmsRepository repo = new FilmsRepository(5);
        ManagerOfFilms manager=new ManagerOfFilms(repo);
        manager.saveFilms(film1);
        manager.saveFilms(film2);
        manager.saveFilms(film3);
        manager.saveFilms(film4);
        manager.saveFilms(film5);
        DataFilm[]expected={film5, film4, film3, film2,film1};
        Assertions.assertArrayEquals(expected, manager.listOfLastFilms());
    }

}