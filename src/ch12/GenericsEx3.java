package ch12;

/* *
 * 지네릭 메소드
 * 메소드의 선언부에 지네릭 타입이 선언된 메소드임.
 *
 * static 멤버에서는 지네릭을 사용하지 못함.
 * 지네릭 메소드에서는 지네릭 타입이 지역 변수처럼 메소드 내에서 지역적으로 사용되므로
 * 사용 가능함.
 *
 * Collections.sort();
 *
 * public static <T extends Comparable> void sort(List<T> list) { => 지네릭 메소드
 *  list.sort(null);
 * }
 *
 * 지네릭 메소드의 지네릭 부분만 확인.
 * <T extends Comparable>
 * 제한된 지네릭 클래스 => 관계성 적용 => Comparable 과의 관계를 적용 =>
 * Comparable 인터페이스를 구현
 * => List<T>의 요소는 Comparable 인터페이스를 구현한 것이어야 함.
 *
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GenericsEx3 {
  public static void main(String[] args) {

    // sort(List<Object> list, Comparator<? super Object> c)
    // 1. list, Comparator<Apple3>
    // 2. list, Comparator<Grape3>
    // 3. list, Comparator<Fruit3>

    // Collections.sort() 의 두 번째 매개변수가
    // 왜 하한 제한 와일드 카드를 적용되어 있는지를 생각해봐야 함.
    FruitBox3<Apple3> appleBox = new FruitBox3<Apple3>();
    FruitBox3<Grape3> grapeBox = new FruitBox3<Grape3>();

    appleBox.add(new Apple3("YellowApple", 300));
    appleBox.add(new Apple3("BlueApple", 100));
    appleBox.add(new Apple3("RedApple", 200));


    grapeBox.add(new Grape3("GreenGrape", 700));
    grapeBox.add(new Grape3("PurpleGrape", 500));
    grapeBox.add(new Grape3("GreyGrape", 200));

    Collections.sort(appleBox.getList(), new AppleComparator());
    Collections.sort(grapeBox.getList(), new GrapeComparator());

    System.out.println(appleBox);
    System.out.println(grapeBox);

    // ------------------------------------------------------------

    Collections.sort(appleBox.getList(), new FruitComparator());
    Collections.sort(grapeBox.getList(), new FruitComparator());

    System.out.println(appleBox);
    System.out.println(grapeBox);
  } // end of main
}

// Collections.sort() 의 두 번 매개변수로 사용 될 Comparator 을 구현해야 함.
// Comparator<Apple3> 구현
class AppleComparator implements Comparator<Apple3> {

  @Override
  public int compare(Apple3 o1, Apple3 o2) {
    return o2.weight - o1.weight;
  }
}

// Comparator<Grape3> 구현
class GrapeComparator implements Comparator<Grape3> {

  @Override
  public int compare(Grape3 o1, Grape3 o2) {
    return o2.weight - o1.weight;
  }
}

// Comparator<Fruit3> 구현
class FruitComparator implements Comparator<Fruit3> {

  @Override
  public int compare(Fruit3 o1, Fruit3 o2) {
    return o2.weight - o1.weight;
  }
}


class Fruit3 {
  String name;
  int weight;

  Fruit3(String naem, int weight) {
    this.name = naem;
    this.weight = weight;
  }

  public String toString() {
    return name + "( " + weight + " )";
  }
}

class Apple3 extends Fruit3 {
  Apple3(String name, int weight) {
    super(name, weight);
  }
}

class Grape3 extends Fruit3 {
  Grape3(String name, int weight) {
    super(name, weight);
  }
}

class FruitBox3<T extends Fruit3> extends Box3<T> {
}

class Box3<T> {
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