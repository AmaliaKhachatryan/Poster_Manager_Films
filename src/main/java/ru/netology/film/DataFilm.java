package ru.netology.film;

public class DataFilm {
    private String titleFilm;
    private String mainActor;
    private int dateOfIssue;
    private int idOfFilm;

    public DataFilm(String titleFilm, String mainActor, int dateOfIssue, int idOfFilm) {
        this.titleFilm = titleFilm;
        this.mainActor = mainActor;
        this.dateOfIssue = dateOfIssue;
        this.idOfFilm = idOfFilm;
    }

    public String getTitleFilm() {
        return titleFilm;
    }

    public String getMainActor() {
        return mainActor;
    }

    public int getDateOfIssue() {
        return dateOfIssue;
    }

    public int getIdOfFilm() {
        return idOfFilm;
    }

    public void setTitleFilm(String titleFilm) {
        this.titleFilm = titleFilm;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public void setDateOfIssue(int dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public void setIdOfFilm(int idOfFilm) {
        this.idOfFilm = idOfFilm;
    }
}

