package ch12;

/* *
 * 상수의 구성 정보
 *  - 불연속적인 상수 값.
 *  - 기능적인 메소드.
 *      1. 추상메소드 선언
 *      2. 선언된 추상메소드를 각 상수에 구현
 *      3. 메소드 내에서 인스턴스 변수 사용 못함.
 *         참조할 수 있도록 별도의 상수를 만들어서 참조(우회 참조).
 *  - 기능 구현 제한(강제)
 *
 *
 * */

enum Transportation {
  BUS(100) {
    // 요금 계산 기능.
    int fare(int distance) {
      return distance * this.BASIC_FARE;
    }
  },
  TRAIN(150) {
    @Override
    int fare(int distance) {
      return distance * this.BASIC_FARE;
    }
  };

  private final int basicFare;
  final int BASIC_FARE;

  Transportation(int basicFare) {
    this.basicFare = basicFare;
    BASIC_FARE = basicFare;
  }

  public int getBasicFare() {
    return basicFare;
  }

  abstract int fare(int distance);
}

public class EnumEx3 {

  public static void main(String[] args) {
    System.out.println(Transportation.BUS.fare(300));
    System.out.println(Transportation.TRAIN.fare(500));
  }
}
