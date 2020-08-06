package org.dibyendu.jsfspring.service;

import java.util.ArrayList;
import java.util.List;

import org.dibyendu.jsfspring.entity.Movie;
import org.dibyendu.jsfspring.entity.User;
import org.dibyendu.jsfspring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("movieService")
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public List<org.dibyendu.jsfspring.view.Movie> getMovieDetails() {
		List<Movie> movie = movieRepository.getMovieDetails();
		System.out.println("movieeeee "+movie);
		List<org.dibyendu.jsfspring.view.Movie> movieList = new ArrayList<org.dibyendu.jsfspring.view.Movie>();
		
		if(movie.size() > 0){
			for(Movie m : movie){
			org.dibyendu.jsfspring.view.Movie movieView = new org.dibyendu.jsfspring.view.Movie();
			movieView.setDirector(m.getDirector());
			movieView.setTitle(m.getTitle());
			movieView.setYearOfRelease(m.getYearOfRelease());
			movieList.add(movieView);
			}
		}
		return movieList;
	}
	
	public Movie createMovie(String title,String director, String yearOfRelease) {
		System.out.println("um = "+title);
		//String uId = getUniqueUserId();
		Movie movie = new Movie();
		movie.setDirector(director);
		movie.setTitle(title);
		movie.setYearOfRelease(yearOfRelease);
		Movie res = movieRepository.save(movie);
		if(res != null) {
			return res;
		}else {
			return res;
		}
	}

}
