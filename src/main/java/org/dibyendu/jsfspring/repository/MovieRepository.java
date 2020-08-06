package org.dibyendu.jsfspring.repository;

import java.util.List;

import org.dibyendu.jsfspring.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query(value = "SELECT * FROM movie_details", nativeQuery = true)
	List<Movie> getMovieDetails();
}
