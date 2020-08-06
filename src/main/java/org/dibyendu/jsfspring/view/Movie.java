package org.dibyendu.jsfspring.view;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.dibyendu.jsfspring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
@SessionScoped
public class Movie {

	@Autowired
	MovieService movieService;
	
	private String title;
	 private String director;   
	 private String yearOfRelease;
	 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getYearOfRelease() {
		return yearOfRelease;
	}
	public void setYearOfRelease(String yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	
	public List<Movie> fetchMovieDetails() {

		return movieService.getMovieDetails();
		
	}
	
      public String createMovie() {
        
		//String userId = null;
		//UserRegistrationService userRegistrationService = new UserRegistrationService();
		org.dibyendu.jsfspring.entity.Movie userId = movieService.createMovie(title,director,yearOfRelease);
        if (userId != null) {
            return "home";
        } else
            return "error";
    }
      
      public void callReview() throws IOException{
    	  
    	  System.out.println("tiiiiii ");
    	  Review review = new Review();
    	  review.fetchReviewDetails(title);
    	  
    	  FacesContext.getCurrentInstance().getExternalContext().dispatch("/movie.xhtml");
      }
	
}
