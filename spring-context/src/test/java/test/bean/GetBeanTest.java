package test.bean;

public abstract class GetBeanTest {
	public void show(){
		getBean().show();
	}
	public abstract User getBean();
}
