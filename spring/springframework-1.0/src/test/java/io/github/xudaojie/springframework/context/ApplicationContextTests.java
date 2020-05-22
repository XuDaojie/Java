package io.github.xudaojie.springframework;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.xudaojie.springframework.bean.AccountBean;

public class ApplicationContextTests {

    /**
     * @see BeanFactoryTests#beanPostProcessorTest() 效果一致
     */
    @Test
    public void getBeanTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mybeans.xml");
        AccountBean testBean = (AccountBean) context.getBean("testBean");
        System.out.println(testBean);

    }

    @Test
    public void m1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mybeans.xml");
        AccountBean testBean = (AccountBean) context.getBean("testBean");
        System.out.println(testBean);
    }

    /**
     * 需要将listener注册到容器中
     */
    @Test
    public void applicationListenerTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mybeans.xml");
    }
}
