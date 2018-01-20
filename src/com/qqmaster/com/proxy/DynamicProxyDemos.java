package com.qqmaster.com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DynamicProxyDemos {
	
	public static void main(String[] args) {
		//static proxy
		Hello hello1 = new StaticProxyHello();
		hello1.sayHello("QuanQuan Matser");
		
//		Hello hello2 = (Hello) Proxy.newProxyInstance(
//				Hello.getClass().getClassLoader(), 
//				new Class<?>[] {Hello.class}, 
//				new helloInvocationHandler(new HelloImpl()));
		
	}
	
}
interface Hello{
	String sayHello(String str);
}

class HelloImpl implements Hello{

	@Override
	public String sayHello(String str) {
		return "Hello " + str;
	}
}

class StaticProxyHello implements Hello{
	private Hello hello = new HelloImpl();

	@Override
	public String sayHello(String str) {
		System.out.println("static Log : will say Hello " + str);
		return hello.sayHello(str);
	}
	
}

class helloInvocationHandler implements InvocationHandler{

	private Hello hello;
	
	public helloInvocationHandler(Hello hello){
		this.hello = hello;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if("sayHello".equals(method.getName())){
			System.out.println("dynamic Log : will say Hello " + Arrays.toString(args));
		}
		return method.invoke(hello, args);
	}
}



