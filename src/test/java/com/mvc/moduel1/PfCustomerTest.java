package com.mvc.moduel1;

import javax.annotation.Resource;

import org.junit.Test;

import com.mvc.moduel1.service.UserService;

public class PfCustomerTest extends BaseJunit4Test {
	@Resource
	private UserService userService;
	@Test
	public void testSelect(){
		userService.selectByUsername("starzhou");
	}
}
