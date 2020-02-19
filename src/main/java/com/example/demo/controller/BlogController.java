package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.BlogItem;
import com.example.demo.service.BlogService;

@Controller
@RequestMapping("/")
public class BlogController {
	@Autowired
	private BlogService blogService;

	public BlogController(BlogService blogService) {
		this.blogService = blogService;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getBlog() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getBlogById() {
		List<BlogItem> blogItems = blogService.getAllBlogItems();
		Map<String, List<BlogItem>> modelMap = new HashMap();
		modelMap.put("items", blogItems);
		return new ModelAndView("index", modelMap);
	}
}