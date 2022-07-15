package io.playdata.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@ApiModel(value="멤버 정보", description="id, pw, name, role(역할) 정보를 보유한 Domain class")
@Entity
public class Member {
	
	@Id
	@ApiModelProperty(example="user1")
	private String id; 
	
	@ApiModelProperty(example="11")
	private String password;
	
	@ApiModelProperty(example="유재석")
	private String name;
	
	@ApiModelProperty(example="감성지킴이")
	private String role;
	
} 
