package edu.cvtc.web.model;

/**
 * @author Project Skeleton
 *
 */
public class Star {
	
	private String name;
	private Integer age;
	
	public Star(final String name, final Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public Star(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(final int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		if (null != name){
			return name;
		} else {
			return "";
		}
	}
	
}
