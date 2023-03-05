package ru.netology.film;

public class FilmsRepository {

    private DataFilm[] films = new DataFilm[0];

    private int amountLastFilms = 10;

    public FilmsRepository() {
    }

    public FilmsRepository(int amountLastFilms) {
        this.amountLastFilms = amountLastFilms;
    }

    public DataFilm[] findAll() {
        return films;
    }
    public void save(DataFilm film) {
        DataFilm[] newFilm = new DataFilm[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            newFilm[i] = films[i];
        }
        newFilm[newFilm.length - 1] = film;
        films = newFilm;
    }

    public DataFilm findById(int id) {
        for (DataFilm film : films) {
            if (film.getIdOfFilm() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {
        DataFilm[] newListFilms = new DataFilm[films.length - 1];
        int copyToIndex = 0;
        for (DataFilm film : films) {
            if (film.getIdOfFilm() != id) {
                newListFilms[copyToIndex] = film;
                copyToIndex++;
            }
        }
        films = newListFilms;
    }

    public void removeAll() {
        films = new DataFilm[0];
    }

    public DataFilm[] reversAll() {
        DataFilm[] reversedListFilms = new DataFilm[films.length];
        for (int i = 0; i < films.length; i++) {
            reversedListFilms[i] = films[films.length - 1 - i];
        }
        return reversedListFilms;
    }

    public DataFilm[] listOfLastFilms() {
        DataFilm[] listOfLastFilms = new DataFilm[amountLastFilms];
        for (int i = 0; i < listOfLastFilms.length; i++) {
            listOfLastFilms[i] = films[films.length - 1 - i];
        }
        return listOfLastFilms;
    }

}
