package org.dibyendu.jsfspring.view;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dibyendu.jsfspring.service.MovieService;
import org.dibyendu.jsfspring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@ManagedBean
@SessionScoped
public class Review {

	@Autowired
	ReviewService reviewService;
	
	private String title;
	private String text;
	 private String time;
	 private String star;
	 
	 
	 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	 
	public List<Review> fetchReviewDetails(String ti) {

		return reviewService.getReviewDetails(ti);
		
	}
	
      public String createReview() {
        
		//String userId = null;
		//UserRegistrationService userRegistrationService = new UserRegistrationService();
		org.dibyendu.jsfspring.entity.Review userId = reviewService.createReview(title,text,time,star);
        if (userId != null) {
            return "home";
        } else
            return "error";
    }
	
}

