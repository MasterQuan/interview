package com.qqmaster.com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemos {
	public static void main(String[] args) {
		Person person = new Person("Yue", 2, 21.3);
		System.out.println("person:-> " + person);
		Class clazz1 = null;
		Class clazz2 = null;
		Class clazz3 = Person.class;
		try {
			System.out.println("------------Get Class Object for class Person------------");
			clazz1 = person.getClass();
			clazz2 = Class.forName("com.qqmaster.com.reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Classes of Person are equal ? ->  " + clazz1.equals(clazz2));
		System.out.println("Classes of Person are equal ? ->  " + clazz2.equals(clazz3));

		System.out.println("\n\n------------Get Fields for class Person------------");
		/**
		 * Get all fields of class Person.
		 */
		Field[] declaredFields = clazz1.getDeclaredFields(); 
		System.out.println("------------all declared Fields:------------");
		for(Field field: declaredFields){
			System.out.println(field);
		}

		System.out.println("\n------------all Fields:------------");
		Field[] Fields = clazz1.getFields();
		for(Field field: Fields){
			System.out.println(field);
		}

		System.out.println("\n\n------------Get Methods for class Person------------");
		System.out.println("------------all declared declaredMethods:------------");
		Method[] declaredMethods = clazz1.getDeclaredMethods();
		for(Method method : declaredMethods){
			System.out.println(method);
		}
		System.out.println("\n------------all methods:");
		Method[] methods = clazz1.getMethods();
		for(Method method : methods){
			System.out.println(method);
		}

		System.out.println("\n\n------------Invoke Fields for class Person----");
		try {
			clazz1.getDeclaredField("name").set(person, "YueYue");
			Field field_age = clazz1.getDeclaredField("age");
			field_age.setAccessible(true);
			field_age.set(person, 3);
			field_age.setAccessible(false);
			clazz1.getDeclaredField("weight").set(person, 22.3);
			System.out.println("person:-> " + person);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("\n\n------------Invoke Methods for class Person----");
		try {
			Method method1 = clazz1.getDeclaredMethod("getRealAge");
			method1.setAccessible(true);
			System.out.println("invoke1->" + method1.invoke(person));

			Method method2 = clazz1.getDeclaredMethod("getAge");
			System.out.println("invoke2->" + method2.invoke(person));
			
			Method method3 = clazz1.getDeclaredMethod("setAge", int.class);
			method3.invoke(person, 6);
			System.out.println("invoke2->" + person);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		System.out.println("\n\n------------constructors----");
		Constructor[] constructors = clazz1.getConstructors();
		for(Constructor constructor:constructors){
			System.out.println(constructor);
		}
		
		System.out.println("\n\n------------Build new Instance----");
		try {
			Person p1 = (Person)clazz1.newInstance();
			System.out.println("p1->" + p1);
			Person p2 = (Person)clazz1.getConstructor().newInstance();
			System.out.println("p2->" + p2);
			Person p3 = (Person)clazz1.
					getConstructor(String.class, int.class, double.class)
					.newInstance("MinYue", 3, 22.3);
			System.out.println("p3->" + p3);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		/**
		 * int is primitive type, But Integer is a class.
		 */
		System.out.println("\n\n------------Other Reflect Demos----");
		Class clazz_int = int.class;
		Class clazz_Integer = Integer.class;
		Class clazz_void = void.class;
		System.out.println("int.class equals Integer.class? " + clazz_int.equals(clazz_Integer));

		
		System.out.println("\n\n------------Class of Class------------");
		Class clazz_Class = Class.class;
		Constructor[] cs =  clazz_Class.getDeclaredConstructors();
		System.out.println();
		for(Constructor c:cs){
			System.out.println(c.getName());
		}
		
	}
}
