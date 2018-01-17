package com.qqmaster.com.algorithms;

/**
 * 
 * @author zhaoshiquan 2017年12月7日 下午5:35:55
 *
 */
public class DCSingleton {
	private static volatile DCSingleton singleton = null;
	
	//私有构造方法，不能继承
	private DCSingleton(){	}
	
	//double check，不能防止通过反射创建示例
	public static DCSingleton getSingleton(){
		if(null == singleton){
			synchronized (DCSingleton.class) {
				if(null == singleton)
					singleton =  new DCSingleton();
			}
		}
		return singleton;
	}

	public static void main(String[] args) {
		DCSingleton dcSingleton = DCSingleton.getSingleton();
		SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
		InnerSingleton innerSingleton = InnerSingleton.getSingleton();
	}
}

class InnerSingleton{
	//私有构造方法，不能继承
	private InnerSingleton(){}
	
	//静态内部类, 不能防止通过反射创建示例
	private static class SingletonHolder{
		private static final InnerSingleton singleton= new InnerSingleton();
	}

	public static InnerSingleton getSingleton(){
		return SingletonHolder.singleton;
	}
}

//枚举，能防止通过反射创建示例
enum SingletonEnum{
	INSTANCE;
}

