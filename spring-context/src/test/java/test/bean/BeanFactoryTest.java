package test.bean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BeanFactoryTest {
	private Class<?> clazz;
	private ClassLoader classLoader;
	private final String path = "path";
	@Test
	public void beanFactoryTest() {
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("test/bean/test-bean.xml"));
		/**
		 * 这个操作完成：
		 * 1.读取配置文件，验证合法性
		 * 2.通过工厂模式反射创建Bean实例
		 */
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
//				"classpath:test/bean/test-bean.xml");
//		MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
//		Assert.assertEquals("testStr", myTestBean.getTestStr());
		A a = (A) beanFactory.getBean("a");
		System.err.println(a);
		Assert.assertEquals("A", a.getaName());
	}

	@Test
	public void resourceTest() throws IOException {
		Resource resource = new ClassPathResource("test/bean/test-bean.xml");
		System.out.println(resource);
		InputStream inputStream = resource.getInputStream();
		System.out.println(inputStream);
	}

	public InputStream getInputStream() throws IOException {
		InputStream is;
		if (this.clazz != null) {
			is = this.clazz.getResourceAsStream(this.path);
		}
		else if (this.classLoader != null) {
			is = this.classLoader.getResourceAsStream(this.path);
		}
		else {
			is = ClassLoader.getSystemResourceAsStream(this.path);
		}
		return is;
	}
}
