package ru.netology.film;

public class ManagerOfFilms {
    private FilmsRepository repo;

    public ManagerOfFilms(FilmsRepository repo) {
        this.repo = repo;
    }

    public void saveFilms(DataFilm film) {
        repo.save(film);
    }

    public DataFilm[] findAllFilms() {
        DataFilm[] allFilms = repo.findAll();
        return allFilms;
    }

    public DataFilm[] reversedAllFilms() {
        DataFilm[] reversAllFilms = repo.reversAll();
        return reversAllFilms;
    }

    public DataFilm findFilmById(int id) {
        DataFilm findById = repo.findById(id);
        return findById;
    }

    public void removeAllFilms() {
        repo.removeAll();
    }

    public void removeFilmById(int id) {
        repo.removeById(id);
    }

    public DataFilm[] listOfLastFilms(){
        DataFilm[] listOfLastFilms= repo.listOfLastFilms();
        return listOfLastFilms;
    }
}
