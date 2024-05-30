package ch6;

/*
 * - 객체지향의 특성
 *   캡슐화, 상속, 추상화, 다형성
 *
 *   논리적인 개념을 코드로 어떻게 표현 하는지? => 문법.
 *
 *  4대 특성이 어떤 경우에 활용하는지?
 *
 *  클래스 설계시 유지보수 고려하려면 어떻게 해야 하는지..
 *
 * - 객체지향의 장점
 *  코드의 재사용성이 높다. => 기존 코드를 활용.
 *  코드의 관리가 용이. => 쉽게 코드를 변경 가능.
 *  신뢰성이 높은 프로그래밍이 가능. => 재사용성이 높고, 변경이 쉬워 코드 불일치가 줄어듦.
 *
 * - 클래스와 객체
 *  클래스는 객체를 정의해 놓은 것. => 객체를 생성하는데 사용.
 *
 * 변수 -> 배열 -> 구조체(C, 여러가지 기본형 타입을 하나로 묶음)
 *                stuGrade(학생 정보, 교과목 정보, 평가 정보)
 *                학생 성적을 관리할 수 있는 새로운 자료형
 *
 *                단점으로는 정보만 관리되고 있어, 기능이 없음.
 *                학생의 주소를 쉽게 변경을 위한 기능이 없음.
 *
 *                -> 클래스
 *                    정보(학생 정보, 교과목 정보, 평가 정보) + 기능(주소 변경)
 *                    정보 : 속성, 필드, 멤버 변수
 *                    기능 : 메소드(함수)
 *
 *                  String 클래스
 *                  정보(char 배열), 기능(대문자 바꾸기, 잘라내기, 치환하기)
 *
 *  객체의 정의 : 설제로 존재. 사물 또는 개념.
 *  객체의 용도 : 객체가 가지고 있는 기능과 속성(정보)에 따라 다름.
 *              객체를 사용 한다는 것은 객체가 가지고 있는 속성과 기능을 사용한다는 의미.
 *
 *  유형의 객체 : 컴퓨터, 강의실, 학생 등
 *  무형의 객체 : 논리적인 것들.
 *
 *  객체(object)와 인스턴스(instance)
 *    클래스로 부터 객체를 만드는 과정을 클래스의 인스턴스화(메모리에 적재)라고 함.
 *    어떤 클래스로 부터 만들어진 객체를 그 클래스의 인스턴스라고 함.
 *    인스턴스는 객체화라고 함.
 *
 *  - 객체의 구성 요소
 *    속성(property) : 필드, 상태, 멤버 변수, 특성
 *    기능(function) : 메소드(함수), 행위
 *
 *  - instance 는 참조 변수를 통해서만 access 가능.
 *    참조 변수의타입은 instance 의 타입과 일치해야 함.
 *
 *  - 객체 배열
 *    객체 배열에 저장 되는 값은 instance 의 address.
 *
 *  - 변수와 메소드
 *    변수 : 클래스 변수, 인스턴스 변수, 지역 변수 등..
 *          구분 기준은 선언된 위치에 따라 다름.
 *
 *  클래스 변수 : 모든 인스턴스에서 공유할 수 있는 변수. 인스턴스화를 거치지 않아도 사용 가능.
 *  인스턴스 변수 : 인스턴스마다 고유한 상태를 유지해야 하는 변수, 객체가 생성 되어야만 사용 가능.
 *  지역 변수 : 해당 area 에서 사용 가능하고, 그 area 밖에서 사용 X. (Method 내에 선언된 변수, 매개변수)
 *
 *  - Method
 *    특정 작업을  수행하는 일련의 묶음.
 *
 *    사용하는 이유 : 높은 재사용성, 중복 코드 감소, 프로그램의 구조화.
 *                  리팩토링시 Method 를 자주 활용하게 됨.
 *
 *    구조 : 선언부(Method 의 머리), 구현부(Method 의 몸통)
 *    반환 타입의 메소드 : 반환 X -> void / 반환형에 맞추어서 반환 타입 사용. 마지막에 return 필요.
 *                      반환 타입과 return 타입이 동일해야 함.
 *
 *    매개변수 : 기본형과 참조형.
 *      기본형 : 변수의 값을 읽기만 가능 (read only)
 *      참조형 : 변수의 값을 수정할 수 있음 (can be read & write)
 *
 *    참조형 반환 타입 : 참조변수의 값(instance 의 주소)이 반환.
 *
 *    클래스 메소드와 인스턴스 메소드
 *      클래스 메소드 : static 키워드를 사용.
 *                   인스턴스와 관련 없는 작업을 수행
 *      인스턴스 메소드 : static 키워드를 사용 X.
 *                     인스턴스 변수와 관련된 작업을 수행
 *                     인스턴스로 생성되어야만 호출 가능
 *
 *    - 클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 공통으로 사용하는 것에 static 을 붙임.
 *    - 클래스 변수(static 변수)는 인스턴스를 생성하지 않아도 사용 가능.
 *    - 클래스 메소드(static 메소드)는 인스턴스 변수를 사용할 수 없다.
 *    - 메소드 내에서 인스턴스 변수를 사용하지 않는다면, static 을 붙이는 것을 고려함.
 *
 *  - 오버로딩(overloading)
 *    한 클래스 내에서 같은 이름의 메소드를 여러 개 정의하는 것.
 *    조건 : 메소드 이름이 동일. 매개변수의 개수와 타입으로 구분.
 *          static, 메소드의 반환타입은 조건에 해당되지 않음.
 *
 *    장점 : 메소드의 이름만 보더라도 이 메소드의 기능을 예상할 수 있음.
 *          메소드의 이름을 절약할 수 있다.
 *
 *  - 가변 매개변수
 * */

class Tv {
  // 속성, 멤버 변수
  String color;
  boolean power;
  private int channel; // private 은 접근제어 지시자.

  // channel setter, 멤버 변수의 값을 변경.
  // public 은 접근제어 지시자.
  // void 는 return 이 없음.
  public void setChannel(int ch) {
    // 유효한 channel 인지 체크
    if (ch < 0) return; // channel 이 음수이면 적용하지 않음.

    channel = ch; // 양수이면 멤버 변수에 적용.
  }

  public int getChannel() {
    return channel;
  }

  // 기능, 메소드
  void power() {
    power = !power;
  }

  void channelUp() {
    ++channel;
  }

  void channelDown() {
    --channel;
  }
}

// 하트, 다이아몬드, 스페이스, 클로버
// 숫자와 무늬는 각각 고유, 공통적인 것은 카드의 크기(폭, 높이)
// 클래스 변수의 대상은 카드의 크기
// 인스턴스 변수의 대상 : 숫자, 무늬
class Card {
  // 멤버 변수(클래스, 인스턴스)

  // instance 멤버 변수 => 객체 생성  후 사용 가능. (고유)
  private String kind;
  private int number;

  // 클래스 멤버 변수 => 객체 생성하지 않고 사용 가능. (공유)
  static int width = 100;
  static int height = 250;
}

// 기본형 매개변수, 참조형 매개변수 용 클래스.
class Data {
  int x;
};

public class OopEx1 {

  // 프로그램의 시작점.
  public static void main(String[] args) {

    // 다른 클래스를 재사용해서 코딩.
    // String 과 같은 API 대신에 사용자 정의 클래스를 사용.

    // 변수만 선언 된 상태, 인스턴스 상태가 아님. t는 참조 변수이고 초기화가 안된 상태.
    // 기본 초기화인 상태. null 로 초기화가 되어 있음.
    Tv t;

    // 참조 변수가 null 에서 실제 Tv 객체의 주소로 초기화 됨.
    // 사용할 수 있는 상태. 메소드 호출 가능.
    t = new Tv();

    // 멤버 변수 초기화 전의 상태
    // color => null
    // power => false
    // channel => 0

    // 속성, 멤버 변수 초기화.
    // t.channel = 10;
    // t.channel = -100; 논리적으로 채널이 마이너스인 경우는 없음.
    // 문제점은 멤버 변수를 함부로 접근하도록 하면 안됨.
    // 해결 방법은 직접 접급이 아닌 간접 접근이 되도록 하는 기능.
    // 기능에서 유효한 값으로 멤버 변수 초기화 되도록 체크.
    // 체크해서 문제가 없다면 멤버 변수에 그대로 적용.

    // 정리
    /* *
     * 멤버 변수에 접근제어자가 필요.
     * 메소드가 필요(setter)
     * */

    t.setChannel(-100);
    System.out.println(t.getChannel());

    t.channelUp();
    System.out.println(t.getChannel());

    t.channelDown();
    System.out.println(t.getChannel());

    Tv t2 = new Tv();

    // Tv 객체 배열
    Tv t3, t4, t5; // 3개로 관리
    Tv[] tvArr = new Tv[3]; // 하나의 배열로 한 번에 관리

    /*
      위의 new Tv는 ()가 없음.
      object 3개로 만들어질 것이라고 생각하면 안됨.
      주소값 3개를 저장할 수 있는 Array 가 만들어진 상태. (null)인 상태.

      각 요소에 객체를 생성해서 주소값을 배열의 요소에 저장해야 함.
      객체 배열을 생각한대로 사용 가능해짐.
      */

    // 객체 배열의 요소 초기화
    tvArr[0] = new Tv();
    tvArr[1] = new Tv();
    tvArr[2] = new Tv();

    int tmp;
    {
      int tmp2;
      {
        int tmp3;
      }
      // int tmp3 = 0; tmp3는 접근 유효 범위를  벗어난 상태, 사용 X.
    }
    // tmp2 = 0; tmp2는 접근 유효 범위를 벗어난 상태임. 사용 X.

    // 클래스 변수와 인스턴스 변수.
    //카드 클래스
    Card c1;
    c1 = new Card();
    System.out.println(c1.width);

    // 참조 변수를 통한 멤버 변수 사용은 인스턴스화가 되어야만 가능.
    Card c2;
    // 클래스 이름으로 접근을 해야함.
    System.out.println(Card.height);
    /* *
     * 논리적으로 문제가 없는지 생각?
     * 클래스 멤버 변수에 final 추가.
     * */
    Card.height = 100;
    System.out.println(Card.height);

    // 기본형, 참조형 매개 변수.
    Data d = new Data();
    d.x = 10;
    System.out.println(d.x);

    // 기본형 매개 변수
    change(d.x); // d.x가 전달 X, d.x의 값인 10이 전달.
    System.out.println("final1 = " + d.x);

    change(d);
    System.out.println("final2 = " + d.x);

    Data d2 = copy(d);
    System.out.println(d2.x);

    MyMath mm = new MyMath(); // 기본 생성자 호출.

    // 클래스 메소드 호출
    System.out.println("MyMath.add = " + MyMath.add(100L, 200L));

    // 인스턴스 메소드 호출 => 인스턴스 생성이 필수
    mm.a = 400L;
    mm.b = 200L;
    System.out.println("mm.add = " + mm.add()); // 인스턴스 메소드

    // 클래스(static) 메소드
    // 인스턴스 변수를 매개변수로 사용
    System.out.println("mm.add = " + mm.add(mm.a, mm.b));

    // 인스턴스 변수를 ㅡ사용하지 않고 매개변수 초기화.
    System.out.println(mm.add(500L, 500L));
    mm.add(500L, 500L); // 현재의 매개변수 500L은 상수임, 상수 500L이 값복사로 메소드에 전달됨.

    // 가변 매개변수 메소드 호출
    String[] strArr = {"100", "200", "300"};
    System.out.println(concatenate("--", strArr));

    String[] strArr2 = {"100", "200", "300", "400", "500", "600"};
    System.out.println(concatenate("--", strArr2));

    concatenate(null);
    concatenate2(null);

    concatenate("", new String[0]);
    concatenate2(new String[0]);

    concatenate("", "");

    // 배열 매개변수 메소드
    concatenate2(new String[0]);
    // concatenate2();

    // 가변 매개변수 메소드
    concatenate3();
  } // end of Main()

  // 가변 매개변수 메소드
  // String...strings : 배열의 요소가 2개 or 3개 이상.
  static String concatenate(String delim, String... strings) {
    String result = "";

    for (String str : strings) {
      result += str + delim;
    }
    return result;
  }

  static String[] concatenate2(String[] strings) {
    return strings;
  }

  static String[] concatenate3(String... strings) {
    return strings;
  }

  // 참조형 반환타입의 메소드
  // 사용되는 쪽이 main() 이라서 static 메소드로 만듦.
  static Data copy(Data d) {
    Data tmp = new Data();
    tmp.x = d.x; // 인스턴스변수의 값을 복사.
    return tmp;
  }

  // 기본형 매개변수의 메소드 (overloading Method)
  static void change(int x) { // int x = 10;
    x = 1000;
    System.out.println("int x = " + x);
  }

  // 참조형 매개변수의 메소드 (overloading Method)
  static void change(Data d) { // instance 의 주소값이 넘어옴.
    d.x = 100;
    System.out.println("Data d = " + d.x);
  }
}

class MyMath {
  long a, b;

  // 인스턴스 메소드
  // 인스턴수 변수임을 명시적으로 나타내기 위해 자기참조변수(this)를 사용하면 확실하게 구분이 됨.
  long add() {
    return a + b;
  }

  // 클래스(static) 메소드
  // 오버로딩에 static 은 관계가 없다. 매개변수로 차이가 됨.
  // 클래스 메소드는 인스턴스 상태이던 아니던 모두 사용(호출) 가능.
  // 단, 클래스 메소드는 자체 내에서는 인스턴스 사용할 수 없음.
  static long add(long a, long b) {

    // static 메소드 안에서는 instance 는 사용 불가.
    // this.add(); // Non-static method 'add()' cannot be referenced from a static context
    // 아래의 a, b는 지역변수, 인스턴스 변수가 아님.
    return a + b;
  }

  // 오버로딩
  static long add(int a, long b) {
    return a + b;
  }

  // 오버로딩
  static long add(int a, long b, long c) {
    return a + b;
  }
}