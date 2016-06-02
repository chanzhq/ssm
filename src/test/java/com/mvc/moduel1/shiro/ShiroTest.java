package com.mvc.moduel1.shiro;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class ShiroTest {
	public void login(String initConfigFile) {
//		String iniConfigPath = ShiroLoginLogoutTest.class.getClassLoader()
//				.getResource(initConfigName).getPath();
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(initConfigFile);
		//2、得到SecurityManager实例 并绑定给SecurityUtils  
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		subject.login(new UsernamePasswordToken("daishenglei", "123456"));
	}

	@Test
	public void testAllSuccessfulStrategySuccess() {
		login("classpath:shiro-authenticator-all-success.ini");
		Subject subject = SecurityUtils.getSubject();
		//得到一个身份集合，其包含了Realm验证成功的身份信息  
		PrincipalCollection principals  = subject.getPrincipals();
		Assert.assertEquals(2, principals.asList().size());
//		principals.
	}
	
	@Test(expected=UnknownAccountException.class)
	public void testAllSuccessfulStrategyFail(){
		login("classpath:shiro-authenticator-all-success.ini");
		SecurityUtils.getSubject();
	}
	
	@Test
	public void testHasRoles(){
		login("classpath:shiro-role.ini");
		Assert.assertTrue(subject().hasRole("role1"));
		//判断拥有角色：role1 and role2  
		Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1","role2")));
		//判断拥有角色：role1 and role2 and !role3  
		boolean[] result=subject().hasRoles(Arrays.asList("role1","role2","role3"));
		Assert.assertTrue(result[0]);
		Assert.assertTrue(result[1]);
		Assert.assertTrue(result[2]);
	}
	
	//基於角色的訪問控制
	@Test(expected = UnauthorizedException.class)
	public void testCheckRole(){
		login("classpath:shiro-role.ini");
		subject().checkRole("role1");
		subject().checkRoles(Arrays.asList("role1","role2"));
		subject().checkRoles("role1","role2","role3","role4");
	}
	
	//基于资源的访问控制
	@Test
	public void testIsPermitted(){
		login("classpath:shiro-permission.ini");
		Assert.assertTrue(subject().isPermitted("user:create"));
		Assert.assertTrue(subject().isPermittedAll("user:create","user:update","user:delete"));
		Assert.assertFalse(subject().isPermitted("user:view"));
	}
	
	@Test(expected=UnauthorizedException.class)
	public void testCheckPermissions(){
		login("classpath:shiro-permission.ini");
		subject().checkPermissions("user:create","user:update","user:view");
	}
	
	private Subject subject(){
		return SecurityUtils.getSubject();
	}
}
