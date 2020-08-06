package org.dibyendu.jsfspring.repository;

import java.util.List;

import org.dibyendu.jsfspring.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("reviewRepository")
public interface ReviewRepository extends JpaRepository<Review, Long>{

	@Query(value = "SELECT * FROM review_details where title = :title", nativeQuery = true)
	List<Review> getReviewDetails(@Param("title") String title);
}
