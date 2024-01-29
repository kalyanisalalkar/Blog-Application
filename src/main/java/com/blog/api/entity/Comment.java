package com.blog.api.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="comments")
@Getter
@Setter
public class Comment {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	private int id;
	
	private String comment;
	
	@ManyToOne
	private Post post;

}
