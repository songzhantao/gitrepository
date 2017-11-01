package org.lanqiao.controller.admin;

//  懒汉式单例       ----- 饿式单例    双重检查锁单例     枚举单例  

public class Singleton {
	private static Singleton singleton = null;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

	
	public static void main(String[] args) {
		Singleton3  s =	Singleton3.INSTANCE;
		Singleton3  s1 =	Singleton3.INSTANCE;
		Singleton3  s2 =	Singleton3.INSTANCE;
		
		
		
	}
}

// 饿式单例
class Singleton1 {
	private static Singleton1 singleton = new Singleton1();

	private Singleton1() {

	}

	public static Singleton1 getInstance() {
		return singleton;
	}

}

// 双重检查锁单例

class Singleton2 {
	private   static Singleton2 singleton = null;

	private Singleton2() {

	}

	public static Singleton2 getInstance() {
		if (singleton == null) {
			synchronized (Singleton2.class) {
				if (singleton == null) {
					singleton = new Singleton2();

				}
			}

		}

		return singleton;
	}

}

//枚举单例  

enum   Singleton3{
	INSTANCE;
	Singleton3(){
		System.out.println("Singleton3");
	} 
}






