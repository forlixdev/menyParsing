package testJava;

public class ObjectToMap {

	private String field1;
	private int field2;
	private ObjectToMap2 objectToMap2;

	// private ObjectToMap() {}

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

	public ObjectToMap2 getObjectToMap2() {
		return objectToMap2;
	}

	public void setObjectToMap2(ObjectToMap2 objectToMap2) {
		this.objectToMap2 = objectToMap2;
	}

	public static class Builder {

		private ObjectToMap _temp = new ObjectToMap();

		public Builder field1(String s) {
			_temp.setField1(s);
			return this;
		}

		public Builder field2(int i) {
			_temp.setField2(i);
			return this;
		}

		public Builder objectToMap2(ObjectToMap2 objectToMap2) {
			_temp.setObjectToMap2(objectToMap2);
			return this;
		}

		public ObjectToMap build() {
			return _temp;
		}

	}

}
