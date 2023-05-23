package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("SELECT g FROM Genre g")
    List<Genre> find();
}
