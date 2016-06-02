package com.mvc.moduel1.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm1 implements Realm {

	@Override
	public String getName() {
		return "myrealm1";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
//		String password = (String) token.getCredentials();
		String password = new String((char[])token.getCredentials());
		if(!"daishenglei".equals(username) ){
			throw new UnknownAccountException();
		}
		if(!"123456".equals(password)){
			throw new IncorrectCredentialsException();
		}
		System.out.println("realm1认证成功！");
		return new SimpleAuthenticationInfo(username, password, getName());
	}

}
