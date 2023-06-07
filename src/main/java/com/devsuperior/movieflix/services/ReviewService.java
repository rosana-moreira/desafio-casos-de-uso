package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;

    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {
        User user = authService.authenticated();
        Review entity = new Review();
        copyDtoToEntity(user, dto, entity);
        entity = reviewRepository.save(entity);
        return new ReviewDTO(entity);
    }

    private void copyDtoToEntity(User user, ReviewDTO dto, Review entity) {
        entity.setUser(user);
        entity.setMovie(movieRepository.getOne(dto.getMovieId()));
        entity.setText(dto.getText());
    }
}