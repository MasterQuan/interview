package com.qqmaster.com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DynamicProxyDemos {

	public static void main(String[] args) {
		//		//static proxy
		//		Hello hello1 = new StaticProxyHello();
		//		System.out.println(hello1.sayHello("QuanQuan Matser"));


		//		dynamic proxy
		//		Hello hello = new HelloImpl();
		//		Hello helloProxy = (Hello) Proxy.newProxyInstance(
		//				HelloImpl.class.getClassLoader(), 
		//				hello.getClass().getInterfaces(), 
		//				new helloInvocationHandler(hello));
		//		System.out.println(helloProxy.sayHello("OKOKOKOK!"));

		//cglib dynamic proxy
		Enhancer enhancer =new Enhancer();
		enhancer.setSuperclass(CglibHello.class);
		enhancer.setCallback(new CglibProxy());
		CglibHello hello3 = (CglibHello)enhancer.create();
		System.out.println(hello3.sayHello("ciglib proxy!"));
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

class CglibHello{
	public String sayHello(String str) {
		return "Hello " + str;
	}
}

class CglibProxy implements MethodInterceptor{

	/** 
	 * 重写方法拦截在方法前和方法后加入业务 
	 * Object obj为目标对象 
	 * Method method为目标方法 
	 * Object[] params 为参数， 
	 * MethodProxy proxy CGlib方法代理对象 
	 */ 
	@Override
	public Object intercept(Object obj, Method method, 
			Object[] params, MethodProxy proxy) throws Throwable {
		System.out.println("before cglib Proxy...");
		Object res = proxy.invokeSuper(obj, params);
		System.out.println("after cglib Proxy...");
		return res;
	}

}


