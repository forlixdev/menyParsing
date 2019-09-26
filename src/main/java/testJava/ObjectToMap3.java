package testJava;

public class ObjectToMap3 {

	private String field1;
	private int field2;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public int getField2() {
		return field2;
	}

	public void setField2(int field2) {
		this.field2 = field2;
	}

	public static class Builder {

		private ObjectToMap3 _temp = new ObjectToMap3();

		public Builder field1(String s) {
			_temp.setField1(s);
			return this;
		}

		public Builder field2(int i) {
			_temp.setField2(i);
			return this;
		}

		public ObjectToMap3 build() {
			return _temp;
		}

	}

}
