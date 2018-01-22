package com.qqmaster.com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DynamicProxyDemos {
	
	public static void main(String[] args) {
		//static proxy
//		Hello hello1 = new StaticProxyHello();
//		hello1.sayHello("QuanQuan Matser");
//		
		
		Hello hello = new HelloImpl();
		//dynamic proxy
		Hello helloProxy = (Hello) Proxy.newProxyInstance(
				HelloImpl.class.getClassLoader(), 
				hello.getClass().getInterfaces(), 
				new helloInvocationHandler(hello));
		System.out.println(helloProxy.sayHello("OKOKOKOK!"));
		
		//cglib dynamic proxy
		
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

class CglibProxy implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	
}


