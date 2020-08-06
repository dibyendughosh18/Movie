package org.dibyendu.jsfspring.service;


import java.util.ArrayList;
import java.util.List;

import org.dibyendu.jsfspring.entity.Movie;
import org.dibyendu.jsfspring.entity.Review;
import org.dibyendu.jsfspring.entity.User;
import org.dibyendu.jsfspring.repository.MovieRepository;
import org.dibyendu.jsfspring.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("reviewService")
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	public List<org.dibyendu.jsfspring.view.Review> getReviewDetails(String title) {
		List<Review> review = reviewRepository.getReviewDetails(title);
		System.out.println("movieeeee "+review);
		List<org.dibyendu.jsfspring.view.Review> reviewList = new ArrayList<org.dibyendu.jsfspring.view.Review>();
		
		if(review.size() > 0){
			for(Review r : review){
			org.dibyendu.jsfspring.view.Review reviewView = new org.dibyendu.jsfspring.view.Review();
			reviewView.setText(r.getText());
			reviewView.setTime(r.getTime());
			reviewView.setStar(r.getStar());
			reviewList.add(reviewView);
			}
		}
		return reviewList;
	}
	
	public Review createReview(String title,String text,String time,String star) {
		System.out.println("um = "+title);
		//String uId = getUniqueUserId();
		Review review = new Review();
		review.setTitle(title);
		review.setText(text);
		review.setTime(time);
		review.setStar(star);
		
		Review res = reviewRepository.save(review);
		if(res != null) {
			return res;
		}else {
			return res;
		}
	}

}
