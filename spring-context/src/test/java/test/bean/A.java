package test.bean;

public class A {
	private String aName = "A";
	private B b;

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	@Override
	public String toString() {
		return "A{" +
				"aName='" + aName + '\'' +
				", b=" + b +
				'}';
	}
}
