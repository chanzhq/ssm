package com.mvc.moduel1.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm3 implements Realm {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "myRealm3";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		if("daishenglei".equals(username)&&"123456".equals(password)){
			System.out.println("小七>>>>>>>>");
		}else{
			System.out.println("小七exception>>>>>>");
			throw new AuthenticationException("用户名或密码错误!");
		}
		return new SimpleAuthenticationInfo("xiaoqi", "123",getName());
	}

}
