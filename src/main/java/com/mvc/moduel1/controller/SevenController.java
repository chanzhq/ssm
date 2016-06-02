package com.mvc.moduel1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SevenController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("amour")
	public String toIndex(){
		logger.info("{}hahaha","haha");
		return "index";
	}
}
