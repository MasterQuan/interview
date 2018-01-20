package com.qqmaster.com.reflect;

public class Person {
	public String name;
	private int age;
	protected double weight;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(String name, int age, double weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public Person(){
		this.name = "MasterQuan";
		this.age = 28;
		this.weight = 55.5;
	}
	
	protected String getFullName(){
		return "full : " + name;
	}
	
	private int getRealAge(){
		return age + 3;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
}
