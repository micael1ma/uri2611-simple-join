package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projection.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name "
            + "FROM movies "
            + "INNER JOIN genres ON movies.id_genres = genres.id "
            + "WHERE description = :genreName;")
    List<MovieMinProjection> serach1(String genreName);
}
