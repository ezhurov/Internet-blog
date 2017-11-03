package com.example.course.controllers;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.course.beans.PostsBean;
import com.example.course.entities.Comments;
import com.example.course.services.CommentService;
import com.example.course.services.ImagesService;
import com.example.course.services.LikesPostService;
import com.example.course.services.PostService;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@SessionAttributes("sessionIdPost")
public class SelectedPost {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ImagesService imageService;
	
	@Autowired
	private LikesPostService likesPostService;

	@RequestMapping("/selectedpost.html")
	public String selectedpost(@RequestParam("postid") String postid, Model model) {
		
		Set<String> roles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		
		PostsBean post = postService.getPostById(Integer.parseInt(postid));

		model.addAttribute("sessionIdPost", postid);
		model.addAttribute("visibleDel", (roles.contains("ROLE_ADMIN") ? "visible" : "hidden"));
		model.addAttribute("selected", post);
		model.addAttribute("comments", commentService.getComments(postid));
		model.addAttribute("existImage", imageService.existImageByPostId(post.getId()));
		
		return "WEB-INF/pages/selectedpost.jsp";
		
	}
	
	@RequestMapping(value="/savecomment.html", method=RequestMethod.POST)
	public String savecomment(@Valid Comments comments, BindingResult bindingResult, @ModelAttribute("sessionIdPost") String sessionIdPost, 
			@RequestParam("comment") String comment, Model model, SessionStatus status) {
		
		status.setComplete();
		
		if (bindingResult.hasErrors()) {
			return ("redirect:/selectedpost.html?postid=" + sessionIdPost);
		}
		
		commentService.save(SecurityContextHolder.getContext().getAuthentication().getName(), comment, sessionIdPost);
		
		return ("redirect:/selectedpost.html?postid=" + sessionIdPost);
		
	}
	
	@RequestMapping("/deletecomment.html")
	public String deletecomment(@RequestParam("commentid") String commentid, @RequestParam("postid") String postid, Model model) {
	
		commentService.delete(commentid);
		
		return ("redirect:/selectedpost.html?postid=" + postid);
		
	}
	
	@RequestMapping("/addlike.html")
	@ResponseBody
	public String addLike(@RequestParam("postid") String postid) {
		
		return String.valueOf(likesPostService.addLikes(postid, SecurityContextHolder.getContext().getAuthentication().getName()));
		
	}
	
	@RequestMapping("/getlike.html")
	@ResponseBody
	public String getLike(@RequestParam("postid") String postid) {
		
		return String.valueOf(likesPostService.getLikes(postid));
		
	}
	
	@RequestMapping("/getimage.html")
	@ResponseBody
	public byte[] getImage(@RequestParam("postid") String postid) {
		
		return imageService.selectByPostId(postid);
		
	}
	
}
