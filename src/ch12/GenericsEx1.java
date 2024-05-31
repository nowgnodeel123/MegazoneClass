package ch12;

import java.util.ArrayList;

/* *
 * Generics
 * - 꺼낼 때
 *    down casting 이 되는지 안되는지가 고려사항.
 *    casting 전에 타입 체크가 필요. (instanceof 연산자)
 *
 * - 저장 될 때
 *    원하지 않는 객체가 포함 되지는 않을까 하는 고려사항.
 *
 * 상기의 고려사항을 해결하면 Collection 을 사용하는데 부담이 없어짐 -> 지네릭스.
 *
 * 지네릭스의 장점.
 *  1. 타입 안정성을 제공.
 *  2. 타입 체크와 형변환을 생략할 수 있음. => 코드가 심플해짐.
 *
 * class Box {
 *  Object item;
 *  void setItem(Object item) {
 *    this.item = this;
 *  }
 *  Object getItem() { return item; }
 * }
 *
 * class Box<T> {
 *  T item;
 *  void setItem(T item) {
 *    this.item = this;
 *  }
 *  T getItem() { return item; }
 * }
 *
 * 용어 정리
 *  - Box<T> : 지네릭 클래스.
 *  - T      : 타입(Type) 변수.
 *  - Box    : 원시 타입(Type)
 *
 * 인스턴스 생성
 *
 * Box<String> b = new Box<String>();
 * - String : 대입된 타입.
 * - Box<String> : 지네릭 타입의 클래스를 호출
 *
 * Box<Integer> b = new Box<Integer>();
 *
 * 지네릭의 사용 제한.
 * - static 멤버에 타입 변수 T를 사용할 수 없음.
 * - 지네릭 타입의 배열 생성을 할 수 없음.
 * - instanceof 연산자, new 연산자에서 타입 변수 T를 피연산자로 사용할 수 없음.
 *
 * 지네릭스란?
 * - 지네릭스는 인스턴스 별로 다르게 동작되도록 만들려고 하는 자바의 기능임.
 * - 인스턴스별로 원하는타입을 지정해서 사용함, 그렇기 때문에
 * */
public class GenericsEx1 {
	public static void main(String[] args) {
//    ArrayList arrlist = new ArrayList();

		// Box class
		// Box 에 담을 수 있는 타입 :
		// Fruit - Apple
		// Fruit - Grape

		// Box 에 담을 수 있는 타입을 지정. Fruit Box, Apple Box, Grape Box
		// Fruit Box 에 담을 수 있는 대상 : Fruit, Apple, Grape
		// Apple Box 에 담을 수 있는 대상 : Apple
		// Grape Box 에 담을 수 있는 대상 : Grape

		// 과일 전용 박스
		Box<Fruit> fruitBox = new Box<Fruit>();

		// 사과 전용 박스
		Box<Apple> appleBox = new Box<Apple>();

		// 포도 전용 박스
		Box<Grape> grapeBox = new Box<Grape>();

		// 장난감 전용 박스
		Box<Toy> toyBox = new Box<Toy>();

		// 원하지 않는 타입이 저장되지 않도록 타입 체크.
//    Box<Fruit> fruitBox2 = new Box<Apple>();
//    Box<Toy> toyBox2 = new Box<Apple>();

		// add() Fruit 타입으로 다형성 매개변수로 적용됨.
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
//    fruitBox.add(new Toy());
		// 매개변수의 타입이 Fruit 임. Toy class 와 전혀 관계가 없음.

		appleBox.add(new Apple());
//    appleBox.add(new Grape());
//    appleBox.add(new Fruit());
//    appleBox.add(new Toy());

		System.out.println(fruitBox);
		System.out.println(appleBox);
	}
}

// 박스 클래스 => 지네릭 클래스
class Box<T> {
	ArrayList<T> list = new ArrayList<>();

	void add(T item) {
		list.add(item);
	}

	T get(int i) {
		return get(i);
	}

	int size() {
		return list.size();
	}

	public String toString() {
		return list.toString();
	}
}

// 과일 클래스들
class Fruit {
	public String toString() {
		return "Fruit";
	}
}

class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}

class Toy {
	public String toString() {
		return "Toy";
	}
}