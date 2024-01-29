package com.blog.api.service;

import com.blog.api.payloads.CommentDto;

public interface CommentService {
	
	
	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer commentId);

}
