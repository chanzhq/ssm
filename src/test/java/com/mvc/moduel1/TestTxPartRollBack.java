package com.mvc.moduel1;

import javax.annotation.Resource;

import org.junit.Test;

import com.mvc.moduel1.service.impl.TestTxPartRollBackServiceImpl;

public class TestTxPartRollBack extends BaseJunit4Test {
	@Resource
	private TestTxPartRollBackServiceImpl testTxPartRollBackService;
	
	@Test
	public void test() throws Exception{
		testTxPartRollBackService.testTxPartRollBack();
	}
}
