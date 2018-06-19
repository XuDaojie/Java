package io.github.xudaojie.boot.example2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest {

    /**
     * 登录
     */
    @Test
    public void testHelloWorld() {
        //1.或SecurityManager工厂，初始化ini文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:example2/shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("darkhelmet", "ludicrousspeed");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                //if no exception, that's it, we're done!
            } catch (UnknownAccountException uae) {
                //username wasn't in the system, show them an error message?
                uae.printStackTrace();
            } catch (IncorrectCredentialsException ice) {
                //password didn't match, try again?
                ice.printStackTrace();
            } catch (LockedAccountException lae) {
                //account for that username is locked - can't login.  Show them a message?
                lae.printStackTrace();
            } catch (AuthenticationException ae) {
                //unexpected condition - error?
                ae.printStackTrace();
            }
        }
        Assert.assertEquals(true, currentUser.isAuthenticated()); //断言用户已经登录

        currentUser.logout();
    }

    @Test
    public void testCustomRealm() {
        //1.或SecurityManager工厂，初始化ini文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("!guest", "guest");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                //if no exception, that's it, we're done!
            } catch (UnknownAccountException uae) {
                //username wasn't in the system, show them an error message?
                uae.printStackTrace();
            } catch (IncorrectCredentialsException ice) {
                //password didn't match, try again?
                ice.printStackTrace();
            } catch (LockedAccountException lae) {
                //account for that username is locked - can't login.  Show them a message?
                lae.printStackTrace();
            } catch (AuthenticationException ae) {
                //unexpected condition - error?
                ae.printStackTrace();
            }
        }
        Assert.assertEquals(true, currentUser.isAuthenticated()); //断言用户已经登录

        currentUser.logout();

    }

    @Test
    public void testCustomMultiRealm() {
        //1.或SecurityManager工厂，初始化ini文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("root", "root");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                //if no exception, that's it, we're done!
            } catch (UnknownAccountException uae) {
                //username wasn't in the system, show them an error message?
                uae.printStackTrace();
            } catch (IncorrectCredentialsException ice) {
                //password didn't match, try again?
                ice.printStackTrace();
            } catch (LockedAccountException lae) {
                //account for that username is locked - can't login.  Show them a message?
                lae.printStackTrace();
            } catch (AuthenticationException ae) {
                //unexpected condition - error?
                ae.printStackTrace();
            }
        }
        Assert.assertEquals(true, currentUser.isAuthenticated()); //断言用户已经登录

        currentUser.logout();

    }

    @Test
    public void testCustomJDBCRealm() {
        //1.或SecurityManager工厂，初始化ini文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("root", "root");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                //if no exception, that's it, we're done!
            } catch (UnknownAccountException uae) {
                //username wasn't in the system, show them an error message?
                uae.printStackTrace();
            } catch (IncorrectCredentialsException ice) {
                //password didn't match, try again?
                ice.printStackTrace();
            } catch (LockedAccountException lae) {
                //account for that username is locked - can't login.  Show them a message?
                lae.printStackTrace();
            } catch (AuthenticationException ae) {
                //unexpected condition - error?
                ae.printStackTrace();
            }
        }
        Assert.assertEquals(true, currentUser.isAuthenticated()); //断言用户已经登录

        currentUser.logout();

    }

    @Test
    public void authorizations() {

    }
}
