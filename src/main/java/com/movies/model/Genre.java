package com.movies.model;


public class Genre {

    private Long genreId;
    private String description;

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (genreId != null ? !genreId.equals(genre.genreId) : genre.genreId != null) return false;
        return description != null ? description.equals(genre.description) : genre.description == null;

    }

    @Override
    public int hashCode() {
        int result = genreId != null ? genreId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", description='" + description + '\'' +
                '}';
    }
}
