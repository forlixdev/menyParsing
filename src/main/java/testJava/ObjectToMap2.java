package testJava;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ObjectToMap2 {

	@JsonInclude(Include.NON_NULL)
	private String field1;
	@JsonInclude(Include.NON_NULL)
	private String field2;
	@JsonInclude(Include.NON_NULL)
	private String[] array;

	
	//private ObjectToMap() {}
	
	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}
	
	public String[] getArray() {
		return array;
	}

	public void setArray(String... array) {
		this.array = array;
	}



	public static class Builder {
		 
		 private ObjectToMap2 _temp = new ObjectToMap2();
		 
		 public Builder field1(String s) {
			 _temp.setField1(s);
			 return this;
		 }
		 
		 public Builder field2(String i) {
			 _temp.setField2(i);
			 return this;
		 }
		 
		 public Builder array(String... i) {
			 _temp.setArray(i);
			 return this;
		 }
		 
		 public ObjectToMap2 build() {
			 return _temp;
		 }
		
		 
		 
	 }
	 
	 
	 

}
