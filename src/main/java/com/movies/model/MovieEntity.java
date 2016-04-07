package com.movies.model;



import javax.persistence.*;

@Entity
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movieid")
    private Long movieId;

    private String name;

    private String description;

    private Double price;

    public Long getMovieId() {

        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieEntity movie = (MovieEntity) o;

        if (!movieId.equals(movie.movieId)) return false;
        if (!name.equals(movie.name)) return false;
        if (!description.equals(movie.description)) return false;
        return price.equals(movie.price);

    }

    @Override
    public int hashCode() {
        int result = movieId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
