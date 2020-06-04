package io.github.xudaojie.springframework.aop;

import org.aopalliance.aop.Advice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.interceptor.DebugInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import io.github.xudaojie.springframework.common.AccountBean;

import static org.junit.Assert.assertEquals;

public class SpringAopTests {

    private PrintWriter console;
    private ByteArrayOutputStream bytes = null;

    private ProxyFactory proxyFactory;
    private ProxyFactoryBean proxyFactoryBean;
    private BeanFactory beanFactory;

    @Before
    public void before() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("aop/aop-beans.xml");
        this.beanFactory = new XmlBeanFactory(resource);

        this.proxyFactory = new ProxyFactory();

        this.beanFactory.getBean("printArgsAdvice");
        this.proxyFactoryBean = new ProxyFactoryBean();
    }

    @After
    public void after() {
    }

    /**
     * 使用Spring实现最基本的代理功能，
     * 无需依赖spring-beans
     */
    @Test
    public void proxyFactoryTest() {
        AccountBean account = new AccountBean();
        MethodBeforeAdvice beforeAdvice = new PrintArgsAdvice();

        this.proxyFactory.setTarget(account);
        this.proxyFactory.addBeforeAdvice(beforeAdvice);

        AccountBean accountProxy = (AccountBean) proxyFactory.getProxy();
        accountProxy.setName("在通知（Advice）中打印参数");
    }

    /**
     * 使用ProxyFactoryBeans实现AOP代理
     * 需依赖spring-beans
     */
    @Test
    public void proxyFactoryBeanTest() {
        AccountBean account = new AccountBean();
        MethodBeforeAdvice beforeAdvice = new PrintArgsAdvice();

        this.proxyFactoryBean.setTarget(account);
        this.proxyFactoryBean.addBeforeAdvice(beforeAdvice);
//        this.proxyFactoryBean.setProxyTargetClass(true);
        // 必须在已添加advice之后再执行
        this.proxyFactoryBean.setBeanFactory(beanFactory);

        AccountBean accountProxy = (AccountBean) this.proxyFactoryBean.getObject();

        // 使用原类执行
        account.setName("在通知（Advice）中打印参数");
        assertEquals(null, account.getTag());

        // 使用代理类执行
        accountProxy.setName("在通知（Advice）中打印参数");
        assertEquals("aop", account.getTag());
    }

    /**
     * 使用Interceptor实现增强
     */
    @Test
    public void proxyFactoryBeanInterceptorTest() {
        AccountBean account = new AccountBean();
        MethodBeforeAdvice beforeAdvice = new PrintArgsAdvice();

        this.proxyFactoryBean.setTarget(account);
//        this.proxyFactoryBean.addBeforeAdvice(beforeAdvice);
        this.proxyFactoryBean.addInterceptor(new DebugInterceptor());
//        this.proxyFactoryBean.setProxyTargetClass(true);
        // 必须在已添加advice之后再执行
        this.proxyFactoryBean.setBeanFactory(beanFactory);

        AccountBean accountProxy = (AccountBean) this.proxyFactoryBean.getObject();

        // 使用代理类执行
        accountProxy.setName("在通知（Advice）中打印参数");
    }

    @Test
    public void proxyFactoryBeanGlobalTest() {
        AccountBean account = new AccountBean();

        this.proxyFactoryBean.setTarget(account);
        // 全局interceptor不能为最后一个
        this.proxyFactoryBean.setInterceptorNames(new String[] {"debug*", "printArgsAdvice"});
        // 必须在已添加advice之后再执行
        this.proxyFactoryBean.setBeanFactory(beanFactory);

        AccountBean accountProxy = (AccountBean) this.proxyFactoryBean.getObject();

        // 使用代理类执行
        accountProxy.setName("在通知（Advice）中打印参数");
    }

    /**
     * 使用Pointcut过滤AOP
     */
    @Test
    public void pointCutTest() {
        AccountBean account = new AccountBean();

        Pointcut pointcut = new SimpleStaticMethodMatcherPointcut();
        Advice advice = new PrintArgsAdvice();
        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(pointcutAdvisor);
        proxyFactory.setTarget(account);

        AccountBean accountProxy = (AccountBean) proxyFactory.getProxy();
        accountProxy.setName("在通知（Advice）中打印参数");
    }
}
