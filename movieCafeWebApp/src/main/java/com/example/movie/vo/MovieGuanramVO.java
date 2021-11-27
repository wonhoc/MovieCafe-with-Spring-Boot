package com.example.movie.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieGuanramVO {
	private String userId;
	private int movieNo;
	private String guanramReview;
	private int guanramRating;
	private String guanramWdate;
	private int guanramLike;
	
	public MovieGuanramVO(String userId, int movieNo, String guanramReview, int guanramRating) {
		super();
		this.userId = userId;
		this.movieNo = movieNo;
		this.guanramReview = guanramReview;
		this.guanramRating = guanramRating;
	}

	public MovieGuanramVO(String userId, int movieNo, String guanramReview, int guanramRating, String guanramWdate,
			int guanramLike) {
		super();
		this.userId = userId;
		this.movieNo = movieNo;
		this.guanramReview = guanramReview;
		this.guanramRating = guanramRating;
		this.guanramWdate = guanramWdate;
		this.guanramLike = guanramLike;
	}
}
