package yncrea.lab06.core.service;

import org.springframework.stereotype.Service;
import yncrea.lab06.core.dao.ReviewDAO;
import yncrea.lab06.core.entity.Review;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReviewService {

    private ReviewDAO reviewDAO;


    public ReviewService(final ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }


    public void save(final Review review) {
        reviewDAO.save(review);
    }


    public void delete(final long reviewId) {
        reviewDAO.deleteById(reviewId);
    }
}
