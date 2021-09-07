package test.bean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryTest {
	@Test
	public void beanFactoryTest() {
		//BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("test-bean.xml"));
		/**
		 * 这个操作完成：
		 * 1.读取配置文件，验证合法性
		 * 2.通过工厂模式反射创建Bean实例
		 */
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"classpath:test/bean/test-bean.xml");
		MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
		Assert.assertEquals("testStr", myTestBean.getTestStr());
	}
}
