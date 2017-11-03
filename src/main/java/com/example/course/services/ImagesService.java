package com.example.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.course.dao.impl.ImageImpl;
import com.example.course.dao.impl.PostImpl;
import com.example.course.entities.Images;

@Service
@Transactional
public class ImagesService {
	
	@Autowired
	private Images images;
	
	@Autowired
	private PostImpl postImpl;
	
	@Autowired
	private ImageImpl imageImpl;

	public void save(int postid, MultipartFile file) {
		
		images.setPost(postImpl.loadById(postid));
		images.setImage(convertFileToBiteArray(file));
		
		imageImpl.insert(images);
		
	}
	
	public byte[] selectByPostId(String postid) {
		
		List<Images> listOfImages = imageImpl.selectByPostId(Integer.parseInt(postid));
		
		if (! listOfImages.isEmpty()) {
			return listOfImages.get(0).getImage();
		} else {
			return null;
		}
		
	}
	
	public boolean existImageByPostId(int postid) {
		
		return (imageImpl.selectByPostId(postid).isEmpty() ? false : true);
		
	}
	
	private byte[] convertFileToBiteArray(MultipartFile file) {
		
		try {
			return file.getBytes();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
