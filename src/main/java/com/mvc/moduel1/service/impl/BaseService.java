package com.mvc.moduel1.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

public class BaseService {
	@Resource
	private SqlSessionFactory sqlSessionFactory;
}
