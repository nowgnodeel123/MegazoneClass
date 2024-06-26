package ch12;

import java.util.ArrayList;
import java.util.Iterator;

/* ********************************************************************************
 * - 제한된 지네릭 클래스
 *
 * 1. 클래스 관계에 대한 제한.
 *
 * Box<T> b = new Box<T>();
 * T 대신에 어떤 것이라도 올 수 있음. Apple, Grape, Toy 등..
 * 제한을 두고 싶은데, 클래스 간의 관계를 통해서 제한을 둘 수 있음.
 *
 * Object
 * Fruit
 * Apple
 *
 * 현재는 타입변수 T에 하나만 올 수 있고, 뭐든지 올 수 있음.
 * Fruit 를 상속 받은 것들만 T에 올 수 있도록 하고 싶다. (제한 = 관계 제한)
 *
 * class FruitBox<T> {
 *   ArrayList<T> list = new ArrayList<T>();
 * }
 *
 * Fruit 를 상속 받은 것들만 T에 올 수 있도록
 * ( T가 어떤 것이 올지는 모르겠지만, Fruit 를 상속 받은 것만 올 수 있음.
 *   따라서, 제한이 생김. Fruit 를 상속 받은 것만. => Apple, Grape )
 *
 * class FruitBox<T extends Fruit> { => 다형성.
 *   // 컴파일 전
 *   ArrayList<T> list = new ArrayList<T>();
 *   // 컴파일 후
 *   ArrayList<Fruit> list = new ArrayList<Fruit>();
 * }
 *
 * 2. 인터페이스 구현에 대한 제한.
 *
 * T extends Fruit
 * T에 오는 실제 타입 클래스에 인터페이스 구현을 강제시키고 싶음.
 *
 * - 인터페이스의 작성시 구성 요소
 *   상수, 추상 메소드(강제성 임), 디폴트 메소드(강제성 아님).
 *
 * Fruit, Apple, Grape => 공통적인 쇼소인 먹다를 추상 메소드로 강제성을 부여하고 싶음.
 *
 * interface Eatable {}
 *
 * T extends Fruit & Eatable
 * - Fruit 자신과 Fruit 를 상속 받는 것만 올 수 있도록 제한
 * and
 * - Eatable interface 를 구현한 것만 올 수 있도록 제한.
 *
 * 주의사항.
 *  1. interface 를 구현 시 implements 키워드를 사용했지만, Generics 에서는 implements 사용하지 않고,
 *     extends 를 사용.
 * T extends Fruit : Fruit 자신과 Fruit 를 상속 받은 것만
 * T extends Eatable : Eatable interface 를 구현 한 것만
 *
 * ********************************************************************************/
public class GenericsEx2 {
  public static void main(String[] args) {
    // ArrayList<T> list = new ArrayList<T>(); => 컴파일 전
    // ArrayList<Friut2> list = new ArrayList<Fruit2>(); => 컴파일 후 (Apple, Grape 담기 가능)
    // 지네릭 제한 => 다형성 적용된 것을 확인.

    // Fruit2 Box
    FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
    fruitBox.add(new Fruit2());
    fruitBox.add(new Apple2());
    fruitBox.add(new Grape2());
    System.out.println("fruitBox - " + fruitBox);

    // ArrayList 에 저장할 수 있는 타입은 파생 클래스 타입.
    // - Fruit 를 담을 수 없고, Grape 와 Apple 은 서로 관계가 없음.
    // => 그래서, ArrayList 에는 Apple 만 담을 수 있음.

    // Apple2 Box
    // Apple 만 담을 수 있는 Box
    FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
    appleBox.add(new Apple2());
    System.out.println("appleBox - " + appleBox);

    // Grape2 Box
    // Grape 만 담을 수 있는 Box
    FruitBox2<Grape2> grapeBox = new FruitBox2<Grape2>();
    grapeBox.add(new Grape2());
    System.out.println("grapeBox - " + grapeBox);

    /* *
     * 2. 인터페이스 구현에 대한 제한 관련 코드
     *
     * 2.1 Eatable 을 기반 쪽에 구현하지 않은 경우. => 모두 에러
     *
     * 2.2 Eatable 을 파생 쪽에만 구현 한 경우. => 기반만 에러
     *
     * 2.3 Eatable 을 기반 쪽에 구현 한 경우. => 모두 정상
     *
     * 2.4
     *
     * */

    /* *
     * 문제.
     * 1. 현재 사용중인 Collection 에서 Iterator 구하기.
     * 2. 표준 api 이용해서 오버라이딩 된 toString()을 사용.
     * 3. Fruit2 기반 클래스의 interface 를 구현 한,
     *    eat_String()을 사용하시오.
     * 4. 3번이 왜 안되는지 생각해보기.
     * */

    // Q1
    Iterator<Fruit2> it = fruitBox.list.iterator();

    // Q2
    while (it.hasNext()) {
      // Q3
      System.out.println(it.next().toString());
      // Object <- Fruit2 <- Apple
      // Object 오버라이딩 된 파생 클래스의 메소드를 호출

      // it.next().eat_String();
      // eat_String() 메소드는 Fruit 가 가지고 있음.
      // 그래서, Fruit2 로 다운캐스팅 해야함.
      // => 제네릭스에서 형변환 필요 없는 것이 장점이라고 했지만, 케이스 바이 케이스임.
    }

    // 현재 interface 에 구현된 쪽은 기반 클래스만 되어 있음.
    // 자식의 eat_String() 을 해도 기반 쪽의 메소드가 호출됨.
    // 만약에, 파생 클래스 쪽에 eat_String() 모두 구현하면?
    // => 파생의 메소드 접근은 인스턴스 타입을 따라감.
    //    down casting 필요함.
    // Q4
//    ((Fruit2) it.next()).eat_String();

    // instanceof Apple 로 형변환 가능한지, Grape 로 형변환 가능한지 확인 후
    // 다시 down casting 해야 함.

    /* *
     * Juice class 로 Juice 만들기
     *
     *
     * */
    System.out.println(Juice.makeJuice(fruitBox));

  } // end of main
}

// Box class : row type class => 제네릭 클래스를 적용.
class Box2<T> {
  ArrayList<T> list = new ArrayList<>();

  ArrayList<T> getList() {
    return list;
  }

  void add(T item) {
    list.add(item);
  }

  T get(int i) {
    return list.get(i);
  }

  int size() {
    return list.size();
  }

  public String toString() {
    return list.toString();
  }
}

// FruitBox : 클래스 간의 관계 제한 => 제네릭을 활용.
// Fruit2 또는 파생 클래스는 반드시 Eatable 을 구현해야함.
// Fruit2 에서 implements Eatable 을 작성하지 않으면, 컴파일 에러가 발생.
// => 강제 구현 시키고 있다는 것.
class FruitBox2<T extends Fruit2 & Eatable> extends Box2<T> {
}

// 제네릭 제한용 인터페이스
interface Eatable {
  abstract void eat();

  abstract String eat_String();
}

// Fruit 의 공통 기능(추상 메소드)을 강제 구현 => 제네릭을 활용
class Fruit2 implements Eatable {
  public String toString() {
    return "Fruit";
  }

  @Override
  public void eat() {
  }

  @Override
  public String eat_String() {
    return "과일 먹기";
  }
}

// Fruit 의 파생 클래스
class Apple2 extends Fruit2 {
  public String toString() {
    return "Apple2";
  }

  @Override
  public String eat_String() {
    return "Apple 먹기";
  }
}

class Grape2 extends Fruit2 {
  public String toString() {
    return "Grape2";
  }

  @Override
  public String eat_String() {
    return "Grape 먹기";
  }
}

class Toy2 {
}

// FruitBox 를 이용한 주스를 만드는 클래스
/*
 * FruitBox 의 종류 : FruitBox(Apple, Grape), AppleBox, GrapeBox
 *
 *
 * */

class Juice {
  String name;

  public Juice(String name) {
    this.name = name + "Juice";
  }

  public String toString() {
    return name;
  }
  /*// 컴파일 전.
  static Juice makeJuice(FruitBox<Fruit>) {
    // 작업 후 Juice 를 반환하면 됨.
  }
  static Juice makeJuice(FruitBox<Apple>) {
    // 작업 후 Juice 를 반환하면 됨.
  }
  static Juice makeJuice(FruitBox<Grape>) {
    // 작업 후 Juice 를 반환하면 됨.
  }
  // 컴파일 후. => 메소드 중복 정의가 발생하게 됨.
  static Juice makeJuice(FruitBox box) {
    // 작업 후 Juice 를 반환하면 됨.
  }
  static Juice makeJuice(FruitBox box) {
    // 작업 후 Juice 를 반환하면 됨.
  }
  static Juice makeJuice(FruitBox box) {
    // 작업 후 Juice 를 반환하면 됨.
  }*/

  // 와일드 카드를 적용. => 메소드의 중복 선언을 막기 위한 용도로 사용.
  // 메소드 중복의 해결 방법은 기반 타입으로 매개변수 타입이 되도록 하는 것임.
  // <? super T> : 하한 제한. T와 그 기반(조상)들만 가능. <= 사용된 와일드 카드
  // <? extends T> : 상한 제한. T 와 그 파생(자식)들만 가능.
  // <?> : 제한이 없음. 모든 타입이 가능. <? extends Object>
  public static Juice makeJuice(FruitBox2<? super Fruit2> box) {
    // 작업 후 Juice 를 반환하면 됨.
    String tmp = "";

    for (Fruit2 f : box.getList())
      tmp += f + " ";

    return new Juice(tmp);
  }
}