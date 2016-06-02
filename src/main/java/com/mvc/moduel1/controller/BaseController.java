package com.mvc.moduel1.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@ExceptionHandler
	public void exceptionHandler(){
		
	}
}
