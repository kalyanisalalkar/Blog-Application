package com.blog.api.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.api.entity.Category;
import com.blog.api.entity.Comment;
import com.blog.api.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
public class PostDto {
	private Integer postId;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UserDto user;
	private Set<CommentDto> comments = new HashSet<>();
	
	

}
