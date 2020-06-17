package io.github.xudaojie.springframework.beans;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileNotFoundException;
import java.util.Map;

import io.github.xudaojie.springframework.common.AccountBean;

public class BeanFactoryTests {

    private BeanFactory beanFactory;

    @Before
    public void before() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("mybeans.xml");
        // 解析xml，并将解析后的定义存入map
        this.beanFactory = new XmlBeanFactory(resource);
    }

    /**
     * first依赖注入
     * @throws FileNotFoundException
     */
    @Test
    public void m1() throws FileNotFoundException {
//        XmlWebApplicationContext
        // 先从缓存中获取bean，如果缓存中不存在，则新建bean
        AccountBean testBean1 = (AccountBean) beanFactory.getBean("testBean");
        System.out.println(testBean1);
//        TestAccountBean testBean2 = (TestAccountBean) beanFactory.getBean("testBean");
//        System.out.println(testBean1 == testBean2);
//        System.out.println(testBean1.getTestGroupBean().getName());
    }

    /**
     * 循环依赖
     */
    public void m2() {
    }

    /**
     * BeanPostProcessor init-method 执行前后的扩展
     */
    @Test
    public void beanPostProcessorTest() {
        ConfigurableListableBeanFactory beanFactory = (ConfigurableListableBeanFactory) this.beanFactory;

        Map<String, BeanPostProcessor> beanPostProcessorInstances = beanFactory.getBeansOfType(BeanPostProcessor.class, false, false);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorInstances.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
        AccountBean testBean1 = (AccountBean) beanFactory.getBean("testBean");
        System.out.println(testBean1);
    }

    @Test
    public void autowireTest() {
        AccountBean testBean1 = (AccountBean) this.beanFactory.getBean("autowireAccountBean");
        System.out.println(testBean1);
    }
}
