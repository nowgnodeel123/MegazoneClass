package ch14;


/* *
 * lambda, stream..
 * 현재 자바가 어렵다고 생각되면,
 * 지금까지 학습한 자바 지식을 기준으로 자바 활용서의 코드를 이해..
 *
 * 목표 : 자바 교재의 코드를 다른 프로젝트에서 이용 및 활용할 정도.
 * 기간 : react 초반 까지.
 *
 *
 *
 * - 람다의 공부 방법.
 *  1. 람다의 의미 및 특징
 *  2. 함수형 인터페이스
 *     Java API 인 Stream 을 사용하는데, 결국에는 메소드임..
 *     메소드의 매개변수 : 람다 + 지네릭
 *     기존의 매개변수 : 기본형, 참조형
 *     Stream Java API 의 메소드의 매개변수 : 함수형 인터페이스
 *     함수형 인터페이스 : Java API => 종류, 특징.
 *  3. 메소드 참조.
 *
 * - 스트림 공부 방법.
 *  1. 스트림의 개념 및 특징, 왜 스트림을 사용해야 하는지
 *     데이터 소스(Collection, Array, Final)를 사용하기 위한 것.
 *  2. Stream 생성
 *  3. 스트림의 연산.
 *     연산의 차이점, 각 연산별 중요한 연산 Stream Api 메소드
 *     각 API 메소드의 매개변수가 함수형 인터페이스임.
 *     - 중간연산
 *       map(), filter()
 *     - 최종연산
 *       collect(), toList()
 *
 * - 자바의 큰 변화
 *  - 지네릭스 - jdk 1.5
 *  - 람다식 - jdk 1.8
 *          => 함수형 언어가 됨.
 *
 * - 코드상의 람다의 이해
 * int method() {
 *  return (int) (Math.random() * 5) + 1 + i;
 * }
 * (int i) -> (int) (Math.random() * 5) + 1 + i;
 * 1. 기존 함수의 반환타입, 메소드명을 제거.
 * 2. 매개변수와 몸통의 실행 코드 사이에 -> 를 넣음.
 *
 * - 람다의 장점.
 *  1. 간결하고 이해가 쉽다.
 *  2. 람다식 자체로 메소드의 역할을 대신함.
 *  3. 메소드의 매개변수로 람다식을 사용할 수 있음.
 *
 * - 다양한 람다식의 형태
 *  - 반환값이 있는 메소드의 경우, return 문 대신에 "식"으로 대신할 수 있음.
 *  - 따라서, 식의 연산결과가 자동적으로 반환된다고 생각하면 됨.
 *  - 그래서 식이므로 끝에 ";" 을 붙이지 않음.
 *
 *  람다식에서 매개변수의 타입이 없다면, 생략된 것이라고 생각.
 *  추론이 가능하므로 대부분 생략이 됨.
 *
 *  int max(int a, int b) {
 *    return a > b ? a : b;
 *  }
 * - 람다식 형태
 * (int a, int b) -> {return a > b ? a : b;} // return 문
 * (int a, int b) -> a > b ? a : b // 3항식이므로 식임. ";" 제거
 * (a, b) -> a > b ? a : b
 *
 * void printVar(String name, int i) {
 *  System.out.println(name + "=" + i);
 * }
 * - 람다식 형태
 * (String name, int i) -> {System.out.println(name + "=" + i);}
 * (name, i) -> {System.out.println(name + "=" + i);}
 * (name, i) -> System.out.println(name + "=" + i)
 *
 * int square(int x) {
 *  return x * x;
 * }
 * - 람다식 형태
 * (int x) -> {return x * x;}
 * (x) -> x * x
 * x -> x * x
 *
 * int roll() {
 *  return (int) (Math.random() * 9);
 * }
 * - 람다식 형태
 * () -> {return (int) (Math.random() * 9);}
 * () -> (int) (Math.random() * 9)
 *
 * - 기존 메소드 형태
 * int sumArr(int[] arr) {
 *  int sum = 0;
 *  for(int i : arr)
 *    sum += i;
 *  return sum;
 * }
 * - 람다식 형태
 * (int[] arr) -> {
 *  int sum = 0;
 *  for(int i : arr)
 *    sum += i;
 *  return sum;
 * }
 *
 * - 함수형 인터페이스
 *  함수를 메소드의 매개변수로 활용하고 싶음.
 *  매개변수에는 타입이 있음. 함수를 나타내는 타입의 필요성이 나옴.
 *  타입 f = (a, b) -> a > b ? a : b
 *  람다식을 메소드라고 생각하고, 람다식을 호출해서 사용하려고 한다면
 *  기존에는 객체를 생생해서 메소드에 접근해서 사용
 *
 *  위의 람다식 어떤 타입의 변수에 저장되려면,
 *  람다식은 눈에는 보이지 않지만, 지금 람다식이 익명클래스 안에 있는 것 아닌지?
 *
 *  (a, b) -> a > b ? a : b
 *
 *  new Object() { // 익명클래스.
 *    int (int a, int b) {
 *      return a > b ? a : b
 *    }
 *  }
 *
 * 타입 f = (a, b) -> a > b ? a : b;
 * 위 f를 나타내는 타입이 현재 배운 범위에서 적용 가능한게 무엇인지 ?
 * 기본형 x, 참조형이 되는게 논리적으로 옳다.
 *
 * 참조형 중에서 어떤 것을 타입으로 하면 될까? -> 인터페이스 형태로 하면 됨.
 *
 * @FunctionInterface
 * interface MyFunc {
 *  public abstract int max(int a, int b);
 * }
 *
 * MyFunc f = new MyFunc() {
 *  // MyFunc 인터페이스의 추상메소드 max 를 구현.
 *  public int max(int a, int b) {
 *    return (a, b) -> a > b ? a : b;
 *  }
 * };
 *
 * MyFunc f = (a, b) -> a > b ? a : b;
 * int big = f.max(3, b); // 익명객체의 메소드 호출
 *
 * 람다식을 어떤 메소드의 매개변수로 전달이 가능해짐.
 *
 * MyFunction 인터페이스는 람다식을 다루기 위한 인터페이스가 되고,
 * 이를 "함수형 인터페이스" 라고 함.
 *
 * 함수형 인터페이스의 제약.
 *  - 함수형 인터페이스에는 오직 하나의 추상메소드만 정의되어 있어야 함.
 *  -> 그래야만 람다식과 인터페이스가 1:1로 연결이 되기 때문임
 *  하지만, static 메소드, default 메소드의 개수에는 제약이 없음.
 * @FunctionInterface 를 사용하면 함수형 인터페이스가 올바르게 정의 되었는지 확인 가능.
 *
 * - 함수형 인터페이스 매개변수
 * void aMethod(My Func f) {
 *  f.max();
 * }
 * - 참조형 변수를 사용해서 메소드의 매개변수로 전달.
 * MyFunc f = (a, b) -> a > b ? a : b;
 *
 * aMethod(f);
 *
 * - 바로 메소드의 매개변수로 람다식을 전달.
 * aMethod((a, b) -> a > b ? a : b);
 *
 * - 함수형 인터페이스 반환형
 * MyFunc myMethod() {
 *  MyFunc f = () -> {};
 *  return f;
 *
 * - 바로 람다식으로 전달.
 * return () -> {};
 * }
 *
 * // 바로 람다식으로 반환하는 것이 이해가 안되면, 아래의 형태로 메모리상에
 * // 값복사가 일어나서 전달되는 것으로 이해.
 * MyFunc ? = () -> {};
 * */

@FunctionalInterface
interface MyFunc {
  public abstract void run(); // 추상메소드
}

public class LambdaEx1 {

  // 함수형 매개변수를 활용하는 메소드
  static void execute(MyFunc f) {
    f.run();
  }

  // 함수형 매개변수를 반환형으로 하는 메소드
  static MyFunc getMyFunc() {
    MyFunc f = () -> System.out.println("f3.run()");
    return f;
  }

  public static void main(String[] args) {

    // case1 : 함수형 인터페이스로 람다식 선언.
    MyFunc f1 = () -> System.out.println("f1.run()");

    // case2 : 익명클래스 형태의 함수형 인터페이스 구현
    MyFunc f2 = new MyFunc() {
      // 함수형 인터페이스의 추상메소드 구현
      @Override
      public void run() {
        System.out.println("f2.run()");
      }
    };

    // case3 : getMyFunc() 사용
    MyFunc f3 = getMyFunc();

    // case4 : 매개변수 메소드인 execute() 를 사용
    // case4.1 : 함수형 인터페이스를 매개변수로 전달
    execute(f1);

    // case4.2 : 함수형 인터페이스 없이 직접 람다식으로 전달
    execute(() -> System.out.println("run()"));

    f1.run();
    f2.run();
    f3.run();
  }
}
