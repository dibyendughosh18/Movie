package org.dibyendu.jsfspring.entity;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dibyendu.jsfspring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "movie_details")
public class Movie {

	@Id
	@GeneratedValue
	@Column
	private long userId ;
	
	@Column
	private String title;
	@Column
	 private String director;
	@Column
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
	
	
}
