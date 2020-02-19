package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.BlogItem;
import com.example.demo.repo.BlogRepo;
import com.example.demo.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepo repo;

	public BlogServiceImpl(BlogRepo repo) {
		this.repo = repo;
	}

	public BlogItem getBlog(String id) {
		return repo.findById(id).get();
	}

	public List<BlogItem> getAllBlogItems() {
		return repo.findAll();
	};
}