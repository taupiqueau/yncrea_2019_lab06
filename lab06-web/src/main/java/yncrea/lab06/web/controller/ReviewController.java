package yncrea.lab06.web.controller;

import yncrea.lab06.core.entity.Review;
import yncrea.lab06.core.service.ReviewService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Named
@Path("/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewController implements RestController{

    @Inject
    private ReviewService reviewService;

    @POST
    @Path("")
    public void saveReview(Review review){
        reviewService.save(review);

    }

    @DELETE
    @Path("/{reviewId}")
    public void deleteReview(@PathParam("reviewId") long reviewId){
        reviewService.delete(reviewId);
    }


}
