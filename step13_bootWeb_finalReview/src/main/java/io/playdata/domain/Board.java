package io.playdata.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@ApiModel(value="게시판", description="게시판 정보")
@Entity
public class Board {
	@Id
	@GeneratedValue
	@ApiModelProperty(example="1")
	private Long seq;
	
	@ApiModelProperty(example="제목")
	private String title;

	@Column
	@ApiModelProperty(example="작성자")
	private String writer;
	
	@ApiModelProperty(example="내용")
	private String content;

}
