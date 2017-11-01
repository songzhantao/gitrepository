package org.lanqiao.controller.admin;

/**
 * 1.5 enum类型 枚举类型
 * 
 * @author Administrator
 *
 */
public class Color {

	/*
	 * public static final String RED ="red"; public static final String GREEN
	 * ="GREEN"; public static final String YELLOW ="yellow";
	 */
	final static Color RED = new Color();
	final static Color YELLOW = new Color();
	final static Color GREEN = new Color();

	public static void main(String[] args) {
		MyColor red = MyColor.RED;
		MyColor red2 = MyColor.RED;

		//int  byte short  char    1.7   String    enum 
		switch (MyColor.RED) {
		case RED:

			break;
		case GREEN:

			break;
		case YEllOW:

			break;

		default:
			break;
		}
		//枚举遍历
		MyColor  [] colors =	MyColor.values();
		for(MyColor color:colors){
			//返回枚举实例定义的位置，默认从0开始
			System.out.println(color.ordinal());
			System.out.println(color.name());
			System.out.println(color.getValue());
			
			
		}

	}

}

enum MyColor {
	RED(10), GREEN(100), YEllOW(10000);
	private int i;

	public int getValue(){
		return i;
	}
	
	private MyColor() {

	}

	private MyColor(int i) {
		System.out.println("有参数的构造方法");
		System.out.println(i);
		this.i = i;
	}

}