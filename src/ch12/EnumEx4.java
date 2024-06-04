package ch12;

/* *
 * 상수를 직접 만드는 것. (enum 을 사용하지 않음.)
 * - enum 의 구조.
 *  - 상수명
 *
 *   1. (기반클래스)
 *   enum Direction {EAST, WEST, SOUTH, NORTH}
 *   - 내부적으로 순서 정보를 관리가 가능해야 함.
 *   - 상수명도 관리가 되어야 함.
 *
 *   2. (파생클래스)
 *   enum Direction {
 *    BUS(100) {
 *    int fare(int distance) { return distance * BASIC_FARE; }
 *      }
 *    }
 *    Direction 은 자기 자신의 클래스 타입임.
 *    자기 자신의 클래스 타입이 Direction 클래스에서 상수 멤버의 형태가 되게 됨.
 *
 *   3. (main())
 *   1, 2 번에서 구현된 기능(메소드)을 사용.
 *
 * - class 를 직접 구현.
 *   상수 (상수명, 상수값, 기능적인 요소)
 *
 * 생성자,
 *
 * 상수명 반환 함수 => name()
 *
 * */

// 기반 클래스
class EnumBase {
  // 순서 정보에 활용되는 정보.
  static int id = 0;

  // enum 의 내부 순서 정보.
  int ordinal;
  // 상수명.
  String name;

  EnumBase(String name) {
    this.name = name;
    ordinal = id++;
  }

  public int getOrdinal() {
    return ordinal;
  }
}

// enumBase 를 바탕으로 사용될 Enum 파생 클래스.
class TransportationEnum extends EnumBase {

  final int BASIC_FARE;

  private TransportationEnum(String name, int basicFare) {
    super(name);
    BASIC_FARE = basicFare;
  }

  // 요금 계산
  public int fare(int distance) {
    return distance * BASIC_FARE;
  }

  // 버스랑 기차의 기본 요금.
  public static final TransportationEnum BUS = new TransportationEnum("BUS", 100);
  public static final TransportationEnum TRAIN = new TransportationEnum("TRAIN", 150);
  public static final TransportationEnum TAXI = new TransportationEnum("TAXI", 130);

  public String name() {
    return name;
  }
}

public class EnumEx4 {
  public static void main(String[] args) {
    TransportationEnum t1 = TransportationEnum.BUS;
    TransportationEnum t2 = TransportationEnum.TRAIN;
    TransportationEnum t3 = TransportationEnum.TAXI;

    System.out.println("2.2번 문제");
    System.out.println("t1.name() : " + t1.name() + " | t1.getOrdinal : " + t1.getOrdinal());
    System.out.println("t2.name() : " + t2.name() + " | t1.getOrdinal : " + t2.getOrdinal());
    System.out.println("t3.name() : " + t3.name() + " | t1.getOrdinal : " + t3.getOrdinal());

    System.out.println("2.3번 문제");
    System.out.println("버스 요금 : " + TransportationEnum.BUS.fare(100));
    System.out.println("기차 요금 : " + TransportationEnum.TRAIN.fare(200));
    System.out.println("택시 요금 : " + TransportationEnum.TAXI.fare(300));

  }
}