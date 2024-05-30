package ch6;

/**
 * <------------------------------ interface ------------------------------>
 * interface 는 상수, 추상메소드로 구성됨. 작성한 interface 를 이미 사용중임. 필요에 의해서 새로운 추상메소드를
 * 추가해야하는 상황이라서 추상메소드를 추가함.
 * 
 * 기존에 interface 를 implements 한 모든 클래스에서 추가된 새로운 추상메소드를 구현해야함.
 * 
 * 따라서, 새로운 메소드를 interface 에 추가를 하더라도, 다른 곳에 영향이 없으면 좋겠다고 생각함 => default method
 * 
 * interface 의 작성 원칙은 추상메소드만 가능. 다른 곳에서 사용되고 있는 static method 는 인스턴스 없이도 잘 사용중임.
 * 그래서, interface 에도 static method 를 추가해서 사용하면 좋겠다고 생각함. => static method 도
 * 사용가능해짐.
 * 
 * 클래스간의 상속, 인터페이스를 활용한 다중 상속처럼 사용 중인 경우 클래스의 메소드명, interface 의 default 메소드 명이
 * 중복되는 경우가 발생.
 * 
 * => 여러 interface 에서 메소드명이 충돌
 * 
 * => default 메소드와 조상 클래스에서 메소드명이 충돌
 * 
 * default method
 * 
 * 
 * static method
 * 
 * 
 * 
 */
public class OopEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 여러 interface 간의 충돌 => 두 군데의 interface 중에 아무거나 하나를
									// 구현하려는 클래스에 오버라이딩 하면 됨.
									// 결과적으로 클래스에 구현된 오버라이딩 메소드가 호출.
		
		// method1()은 두 군데의 interface 에 존재하고,
		// Child5 클래스에 구현된 상태.
		// 따라서, 코드 기준으로 총 세 군데임.
//		Child5 c = new Child5();
//		c.method1();
		
		// 중복 상황은 클래스와 인터페이스 간의 메소드 충돌임.
		// 결과적으로 클래스의 메소드가 호출됨.
//		c.method2();

		// 원칙은 interface 에서 추상메소드만 가능했으나,
		// 자바 버전이 JDK1.8 부터는 interface 에서도 static method 도 가능해짐.
		MyInterface.staticMethod();
		MyInterface2.staticMethod();

		// default 메소드와 기반 클래스에서 메소드명이 충돌.
	} // end of main

}

//class Parent5 {
//	public void method2() {
//		System.out.println("method2() : Parent5");
//	}
//}
//
//class Child5 extends Parent5 implements MyInterface, MyInterface2 {
//
//	// default method 2개가 충돌되고 있음.
//	// 충돌되고 있는 default 메소드 중에서 아무거나 하나만 구현하면 됨.
//	@Override
//	public void method1() {
//		System.out.println("method1() : Child5");
//	}
//

interface MyInterface {
	// default method
	default void method1() { // MyInterface2 와 충돌
		System.out.println("method1() : MyInterface");
	}

	default void method2() { // Parent5 와 충돌
		System.out.println("method2() : MyInterface");
	}

	// static method
	static void staticMethod() {
		System.out.println("staticMethod() : MyInterface");
	}
}

interface MyInterface2 {
	// default method
	default void method1() { // MyInterface 와 충돌
		System.out.println("method1() : MyInterface2");
	}

	// static method
	static void staticMethod() {
		System.out.println("staticMethod() : MyInterface2");
	}
}