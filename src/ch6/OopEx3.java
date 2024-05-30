package ch6;

/* *
 *  - 다형성(polymorphism)
 *     다양한 형태를 가지고 있음. => 일반적인 의미
 *     한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함. => OOP 에서의 의미
 *     => 타입 변환 => 형 변환(casting)
 *
 *     Tv tv = new Tv(); // 기반 클래스
 *     TvVcr tVcr = new TvVcr(); // 파생 클래스
 *     TvCation tvCa = new TvCation(); // Tv 로 부터 파생된 클래스.
 *
 *     Tv tv = new TvVcr(); // 다형성, 인스턴스는 TvVcr 인데, 참조변수의 타입은 Tv 인 기반 클래스.
 *     Tv tv = new TvCation();
 *
 *     => Tv 라는 하나의 타입으로 TvVcr, TvCation 의 인스턴스 타입으로 표현.
 *
 *  - 다형성으로 표현된 클래스가 인스턴스가 되었을 때.
 *     Tv tv = new TvVcr(); // 메모리의 인스턴스는 TvVcr.
 *                         // 참조변수의 타입이 기반.
 *                         // 따라서, 기반 클래스의 범위 내에서 사용 가능.
 *                         // 인스턴스사용에 제한 있음.
 *                         // 비록 인스턴스는 TvVcr 이지만, Tv의 멤버들만 사용 가능.
 *
 *                         // 그래서, TvVcr 의 모든 것을 사용하려면 down casting 임.
 *
 *    TvVcr tVcr = new TvVcr(); // 메모리의 인스턴스는 TvVcr.
 *                              // 참조변수의 타입이 자기 자신.
 *                              // 따라서, 파생 클래스 자신의 범위 내에서 사용 가능. (사용 제한 X)
 *
 *    - 현재까지 배운 내용에서 다형성에 대한 장점.
 *
 *    Tv tv = new Tv();
 *    Tv tv = new TvVcr();
 *    Tv tv = new TvCamera();
 *    Tv tv = new TvGame();
 *    Tv tv = new TvCdPlayer();
 *
 *    다양한 타입의인스턴스들을 하나의 타입으로 표현.
 *    Tv[] tvArr = new Tv[4];
 *
 *    Tv[0] = new TvVcr();
 *    Tv[1] = new TvCamera();
 *    Tv[2] = new TvGame();
 *    Tv[3] = new TvCdPlayer();
 *
 *    형변환(casting)
 *      1. up casting : 파생(자식) -> 기반(부모), 자동형변환
 *                      자바는 단일 상속만 지원. 파생 입장에서 부모는 하나이므로 자동형변환.
 *      2. down casting : 기반(부모) -> 파생(자식), 명시적인 형변환
 *                        기반 입장에서는 자식이 여러개일 수 있기 때문에, down casting 대상이 누가 될 지 알 수 없음.
 *                        명시적 형변환을 해야함.
 *
 *  - instanceof 연산자
 *      메모리상의 인스턴스 상태까지 고려해주는 것은 아님.
 *      그래서, 상속관계의 상태만 고려해주는 것임.
 *
 *      참조변수가 참조하고 인스턴스의 실제 타입을 알아보는 용도로 사용.
 *
 *      - 다형성의 활용과 instanceof 의 용도
 *        매개변수를 활용한 다형성 => 메소드의 매개변수가 다형성을 띄고있다.
 *          전달된 인스턴스의 참조변수의 타입에 따라 해당 인스턴스의 멤버변수 사용시 범위를 알 수 있기 때문.
 *
 *        반환타입을 활용한 다형성 => 메소드의 반환타입이 다형성을 띄고있다.
 *          메소드를 호출한 쪽에서 현재 참조 변수가 누구의 인스턴스인지 확인이 필요한 경우가 있기 때문.
 *
 *        매개변수를 활용하는 메소드의 경우, 반환형이 있는 메소드 (void 제외) 경우,
 *        오버로딩을 통해서 동일한 기능을 하는 메소드가 많아지면, 유지보수가 힘들어 짐,
 *        기반클래스 타입으로 매개변수와 반환형을 적용하면, 관리해야 할 메소드가 줄어듦,
 *        유지보수가 간편해 질 수  있는 장점이 있다.
 *
 *  - 참조변수와 인스턴스의 연결.
 *
 * */
class Parent5 {
  int x = 100;

  void method() {
    System.out.println("Parent4 : method()");
  }
}

class Child5 extends Parent5 {
}

// 참조변수와 인스턴스의 연결 관련 클래스
class Parent4 {
  int x = 100;

  void method() {
    System.out.println("Parent4 : method()");
  }
}

class Child4 extends Parent4 {
  int x = 200;

  // 메소드 오버라이딩.
  void method() {
    System.out.println("Child4 : method()");
  }
}


// 참조변수 형변환 관련 클래스.
class Car1 {
  String color;
  int door;

  void drive() {
    System.out.println("운행중");
  }

  void stop() {
    System.out.println("정지");
  }
}

class FireEngine extends Car1 {
  void water() {
    System.out.println("화재 진압중");
  }
}

class Ambulance extends Car1 {
  void siren() {
    System.out.println("사이렌");
  }
}

public class OopEx3 {
  public static void main(String[] args) {
    Car1 c1 = null;
    FireEngine fe1 = new FireEngine();
    FireEngine fe2 = null;

    fe1.water();

    // 다형성 고려한 코드
    c1 = fe1; // 인스턴스는 파생 클래스인데 참조변수는 타입은 기반 클래스임.
    // up casting, 자동 형변환.
    c1 = (Car1) fe1;

    // car 참조 변수의 인스턴스 사용 범위 고려.
    // car.water(); // 파생 인스턴스의 멤버를 사용할 수 없음.

    fe2 = (FireEngine) c1; // down casting, 명시적 형변환
    fe2.water();

    // fe2 = c1;

    // ############################## down casting 시 고려할 사항 ##############################
    // 업, 다운이 모두 다 되는 경우가 있고, 아닌 경우가 있음.
    Car1 car1 = new Car1();
    Car car3 = null;
    FireEngine fe3 = null;

    car1.drive();
    // fe3 = (FireEngine) car1; // down casting
    // down casting 의 본질적인 목적은 파생 클래스 인스턴스의 멤버들을 사용하기 위함.

    /* *
     * 현재의 인스턴스는 Car2 임. FireEngine 이 아님.
     * 메모리에 있는 인스턴스는 Car2 이므로
     * FireEngine 으로 다운 캐스팅 하더라도 Car2 만 존재하고 있으므로,
     * FireEngine 의 멤버들을 사용할 수 없음.
     *
     * 에러의 종류 : 문법 에러, 실행(runtime) 에러.
     *               문법적으로는 정상적인 것이지만, 실제 메모리상의 존재 인스턴스에 위배되는 코드로 실행 되므로
     *               runtime 에러가 발생.
     *
     * 다형성을 활용하는 코드 작성시, 반드시 메모리상의 인스턴스 상태를 고려해서 코드를 작성.
     * */

    // instanceof 연산자
    FireEngine fe4 = new FireEngine();

    // up casting 가능 여부를 확인하는 코드
    if (fe4 instanceof FireEngine) {
      System.out.println("up casting - FireEngine instance");
      FireEngine fe5 = (FireEngine) fe4;
    }
    if (fe4 instanceof Car1) {
      System.out.println("up casting - Car1 instance");
      Car1 car4 = (Car1) fe4;
    }
    if (fe4 instanceof Object) {
      System.out.println("up casting - Object instance");
      Object o = (Object) fe4;
    }

    Object fe5 = new FireEngine();

    // down casting 확인
    if (fe5 instanceof Car1) {
      System.out.println("down casting - Car1 instance");
      Car1 o = (Car1) fe5;
    }
//    if (fe5 instanceof Car3) {
//      System.out.println("down casting - Car1 instance");
//      Car3 o = (Car3) fe5;
//    }
    if (fe5 instanceof FireEngine) {
      System.out.println("down casting - Car1 instance");
      FireEngine o = (FireEngine) fe5;
    }

//    if (fe5 instanceof Ambulance) {
//      System.out.println("down casting - Ambulance instance");
//      Ambulance a = (Ambulance) fe5;
//    } 실행안됨.


    // ################### 참조변수와 인스턴스의 연결 관련 1
    // casting 후 사용되는 멤버변수와 멤버메소드를 확인.
    Parent4 p = new Child4();
    Child4 c = new Child4();

    // 오버라이드 된 상태에서 up casting 인 경우
    // 멤버변수를 사용하는 경우 -> 참조 변수의 타입을 따라감.
    // 멤버함수를 사용하는 경우 -> 인스턴스의 클래스 타입을 따라감.

    // 참조변수의 타입이 Parent4 인 경우 Child4 의 멤버변수 및 멤버메소드 사용.
    // up casting 이 되었다고 가정 => 기반 클래스의 멤버를 사용하려는 목적.
    System.out.println("p.x = " + p.x); // 성공. 기반 멤버.
    p.method();                         // 실패. 파생 멤버.

    // 참조변수의 타입이 Child4 인 경우 Child4 의 멤버변수 및 멤버메소드 사용.
    System.out.println("c.x = " + c.x); // 파생 멤버.
    c.method();                         // 파생 멤버.

    // ################### 참조변수와 인스턴스의 연결 관련 2
    // 기반 클래스에만 멤버가있는 경우, 파생 클래스에는 멤버가없는 경우.
    Parent5 p4 = new Child5();
    Child5 c4 = new Child5();

    System.out.println("p4.x = " + p4.x);
    p4.method();

    System.out.println("c4.x = " + c4.x);
    c4.method();

  } /* end of main() */
}