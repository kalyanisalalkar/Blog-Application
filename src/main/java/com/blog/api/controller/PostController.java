package com.blog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.config.AppConstant;
import com.blog.api.entity.Post;
import com.blog.api.payloads.ApiResponse;
import com.blog.api.payloads.CategoryDto;
import com.blog.api.payloads.PostDto;
import com.blog.api.payloads.PostResponse;
import com.blog.api.service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	@Autowired
	private PostService postService;
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost
	      (@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId){
			PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
			
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
		
	}
	
	
	//Update Post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId)
	{
	PostDto updatePost = this.postService.updatePost(postDto,postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
	
	
	
	//Delete Post
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId)
	{
		this.postService.deletePost(postId);
		return new ApiResponse("Post is Deleted SuccessFully !!",true);
	}
	
	
	//get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		List<PostDto> posts = this.postService.getPostsByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
	}
	
	//get by Category
		@GetMapping("/category/{categoryId}/posts")
		public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
			List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
			
			return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
			
		}
		
		//get all posts
		@GetMapping("/posts")
		public ResponseEntity<PostResponse> getAllPost
		        (@RequestParam(value="pageNumber",defaultValue = AppConstant.PAGE_NUMBER,required = false)Integer pageNumber,
				@RequestParam(value="pageSize",defaultValue = AppConstant.PAGE_SIZE,required = false)Integer pageSize,
		         @RequestParam(value = "sortBy",defaultValue = AppConstant.SORT_BY,required = false)String sortBy,
		         @RequestParam(value = "sortDir",defaultValue = AppConstant.SORT_DIR,required = false)String sortDir
		         
		         )
		{
			PostResponse postResponse = this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
			return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
			
		}
		
		//get post details by Id
		
		@GetMapping("/posts/{postId}")
		public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
			PostDto postDto = this.postService.getPostById(postId);
			return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
			
		}
		
		@GetMapping("/posts/search/{keywords}")
		public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords")String keywords){
			
			List<PostDto> result = this.postService.searchPosts(keywords);
			return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
			
			
		}

}
