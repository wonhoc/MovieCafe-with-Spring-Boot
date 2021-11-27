package com.example.movie.vo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieInfoVO {
	private int movieNo;
	private String movieTitle;
	private String movieDir;
	private String movieActor;
	private String movieGenre;
	private int movieRuntime;
	private String movieLink;
	private String movieAge;
	private String movieRelease;
	private String posterOrigin;
	private String posterSys;
	private int movieAvg;
	private ArrayList<GuanramListVO> guanramList = new ArrayList<GuanramListVO>();
	
	public MovieInfoVO(int movieNo, String movieTitle, String posterSys) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.posterSys = posterSys;
	}

	public MovieInfoVO(String movieTitle, String movieDir, String movieActor, String movieGenre, int movieRuntime,
			String movieLink, String movieAge, String movieRelease, String posterOrigin, String posterSys) {
		super();
		this.movieTitle = movieTitle;
		this.movieDir = movieDir;
		this.movieActor = movieActor;
		this.movieGenre = movieGenre;
		this.movieRuntime = movieRuntime;
		this.movieLink = movieLink;
		this.movieAge = movieAge;
		this.movieRelease = movieRelease;
		this.posterOrigin = posterOrigin;
		this.posterSys = posterSys;
	}

	public MovieInfoVO(int movieNo, String movieTitle, String movieDir, String movieActor, String movieGenre,
			int movieRuntime, String movieLink, String movieAge, String movieRelease, String posterOrigin,
			String posterSys, int movieAvg) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.movieDir = movieDir;
		this.movieActor = movieActor;
		this.movieGenre = movieGenre;
		this.movieRuntime = movieRuntime;
		this.movieLink = movieLink;
		this.movieAge = movieAge;
		this.movieRelease = movieRelease;
		this.posterOrigin = posterOrigin;
		this.posterSys = posterSys;
		this.movieAvg = movieAvg;
	}
}
