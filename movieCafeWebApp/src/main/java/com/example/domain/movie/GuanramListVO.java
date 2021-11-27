package com.example.domain.movie;

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
public class GuanramListVO {
	private String userId;
	private String photoOrigin;
	private String photoSys;
	private String nickName;
	private String guanramReview;
	private String guanramWdate;
	private int guanramLike;
	private int guanramRating;
}
