package ch6;

/**
 * OOP의 4대 특성
 * 1. 캡슐화
 * 		데이터를 외부에서 함부로 변경하지 못하도록 하기 위해서 접근을 제어하는 것.
 * 		데이터 감추기(Data Hiding)
 * 		외부에는 불필요한, 내부적으로만 사용되는, 부분을 감추기 위함.
 * 		복잡성을  줄임.
 * 		문법적: private
 * 				데이터 사용 -> getter, setter, 필요한 비즈니스용 메소드.
 * 				private 생성자 -> 인스턴스를 내부에서 생성하는 목적. -> singleton 디자인패턴
 * 				-> getInstance()
 * 2. 상속
 * 		기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것. 기반클래스, 파생클래스
 * 		상속의 원칙은 단일 상속.(단일 상속을 대신해서 확장: 추상클래스, 인터페이스)
 * 		문법적: extends(단일 상속에서 확장: implements)
 * 				생성자와 초기화 블록은 상속되지 않음. 멤버만 상속됨.
 * 
 * 		클래스 간의 관계에 대한 논리성을 고려. is-a(상속), has-a(포함) 관계 -> 다중상속 같은 용도.
 * 3. 추상화
 * 		클래스간의 공통점을 찾아내서 공통의 기반을 만드는 작업.
 * 		추상클래스는 추상메소드가 존재하는 클래스.(추강메소드는 선언만 된 상태. 몸통이 없는 상태.)
 * 
 * 		추상화의 반대는 구체화. 상속을 통한 클래스 확장하는 작업.
 * 		문법적: extends(인스턴스로 사용 가능한 기반 클래스, 인스턴스로 사용 불가능한 기반 클래스 => 추상 클래스)
 * 4. 다형성(중요)
 * 		단어적인 의미는 여러 가지 형태를 가질 수 있는 능력 또는 특성.
 * 		기반클래스 타입의 참조변수로 파생클래스의 인스턴스를 참조할 수 있도록 하는 것.
 * 		=> 인스턴스의 그룹핑이 가능해짐. => 관리가 편리해짐.(10개의 메소드가 1개의 메소드로 관리)
 * 		문법적: 형변환 연산자, instanceof
*/

/**
 * interface : 추상메소드, 다중 상속처럼 사용 가능, 다형성 => 논리적이지 않은 것도 묶을 수 있음.
 * 
 * 추상메소드 => 메소드 구현을 강제 시킬 수 있음. ex) 신입사원이 실수하지 못하도록 함. 다중 상속 => 2개 이상의 interface
 * 를 사용. 따라서 구현해야 하는 추상 메소드도 2개. 다형성 => Car, Airplane, ship 의 공통점 : 이동체 공격 기능
 * 없지만, 공격 interface 를 만든다면,
 * 
 * 어떤 Airplane 공격 interface 를 구현하지 않고, => 여객기 어떤 Airplane 공격 interface 를 구현하면,
 * => 전투기
 * 
 * 어떤 ship 공격 interface 를 구현하지 않고, => 여객선 어떤 ship 공격 interface 를 구현하면, => 함선
 * 
 * 인터페이스를 기준으로 관계없는 것들도 세분화해서 다형성을 적용할 수 있음.
 * 
 * 전투와 관련된 다형성 전투와 관련되지 않은 다형성 이동과 관련된 다형성
 * 
 * 인터페이스 예제 => 스타크래프트 캐릭터를 만듦. MARINE, SCV, TANK, DROPSHIP.
 * 
 * 클래스 간의 관계 Unit -> GroundUnit -> Marine, SCV, Tank -> AirUnit -> DROPSHIP
 * 
 * 추상클래스 -> 상속 받아서 추상메소드를 오버라이딩(재정의) 해야만 인스턴스로 사용 가능. 논리적인 관계성이 있어야함. 인터페이스 ->
 * 클래스의 부족한면, 단일상속만 가능. 다중상속이 안됨. 관계성이 있는 것들끼리만 다형성을 적용할 수 있음.
 * 
 * 다중상속처럼 사용가능. 관계가 없는 것끼리 다형성을 적용할 수 있음.
 * 
 * SCV 역할. - 수리, 자원 채취, 공격, 건축 등 -> SCV의 수리 대상: Tank, SCV, DROPSHIP 수리 대상과 관련된
 * 공통 부분을 interface 로 만들어서 사용. => 수리와 관련된 다형성을 적용 => 수리 메소드가 하나로 처리 가능.
 * 
 * 인터페이스의 제약사항 모든 멤버변수는 public static final 이어야함. 생략할 수 없음. 모든 메소드는 public
 * abstract 이어야함. 생략할 수 없음. 단 static 메소드와 default 메소드는 예외.
 * 
 * 인터페이스의 상속 인터페이스는 인터페이스로부터만 상속 받을 수 있음. 다중 상속이 가능함.
 * 
 * 인터페이스의 구현 인터페이스의 추상 메소드를 구현하는 클래스에서 implements 를 사용해서 구현.
 * 
 */

/**
 * 
 * 클래스 간의 관계 Unit -> GroundUnit -> marine, scv, tank / AirUnit -> dropship
 * 
 * -> Building -> academy, bunker, barrack(공중), factory(공중)
 * 
 * 1. scv 구현 => 수리(대상: scv, tank, dropship) 고려사항 a. 관계가 없는 Unit 을 수리를 위해 새로운
 * 타입으로 묶음. b. scv 클래스에 repair(수리 interface 수리대상) Unit 의 멤버변수에 접근해서 값을 수정. =>
 * 매개변수의 타입과 멤버변수 접근 타입이 다름. => 형변환
 * 
 * 2. Building 에서 공중으로 띄우는 공통 능력을 interface 작성.
 * 
 * 3. 배럭과, 팩토리의 class 작성.
 * 
 * 
 * 
 * 1. 새로운 건물이 추가될 경우 2. 이륙, 이동, 정지, 착륙 의 기본 메소드의 재활용, 기능 강제성 3. 유지보수 및 확장성을 위해서
 * 
 * 
 * 인터페이스의 장점. 1. 개발시간을 단축. 독립적인 프로그래밍이 가능 2. 표준화 가능 => 생산성과 관련됨. 3. 관계없는 것끼리 맺어줄
 * 수 있음.
 * 
 *
 *
 * 1. main 메소드에서 xml 파싱 기능을 사용시, xml 파싱 버전이 변경되어 코드가 변경 되더라도, main 메소드에는 영향이 없어야
 * 함. -> 인터페이스의 반환형 다형성을 적용
 * 
 * 2. main 메소드에서 xml 파싱에서 html 파싱으로 변경이 되더라도 쉽게 파싱기능을 사용할 수 있도록 해야함.. -> 인터페이스의
 * 반환형 다형성을 적용
 * 
 * 3. 파싱 기능에 대해서는 표준화가 되도록 해야함. 향후에 json 파싱 등의 다른 구문 분석에 대한 요구사항이 발생할 수 있음. 개발팀의
 * 멤버가 변경될 수도 있음.
 * 
 */

// 표준화 용도, main method 에서 쉽게 사용되도록 하는 용도.
interface Parseable {
	public abstract void parse(String fileName);
}

// 파싱 전용 클래스
// 1.0 전용
class XMLParse implements Parseable {

	@Override
	public void parse(String fileName) {
		// TODO Auto-generated method stub
		System.out.println(fileName + " : XML 구문 분석 완료.");
	}

}

// main method 에서 return instance 1.0 or 2.0 몰라도,
// 최신의 parse 가 사용되도록 함. => XMLParse 의 변경이 main method 에서
// 코드 레벨로 영향이 가지 않는 다는 것을 의미함. => 약결함.
// 인터페이스의 다형성, 반환형 다형성.
// 2.0 전용
class NewXMLParse implements Parseable {

	@Override
	public void parse(String fileName) {
		// TODO Auto-generated method stub
		System.out.println(fileName + " : XML 구문 분석 완료.");
	}

}

// 응집도가 높게 구현함.
class HTMLParse implements Parseable {

	@Override
	public void parse(String fileName) {
		// TODO Auto-generated method stub
		System.out.println(fileName + " : HTML 구문 분석 완료.");
	}

}

// parser 인스턴스 생성 대리자 클래스 => 약결합을 위한 클래스. 사용하기 편리함.
class ParserManager {
	public static Parseable getParser() {
//		return new XMLParse();
		return new HTMLParse();
	}
}

// 강결합된 상태
// 다른쪽의 코드가 완성이 될 때까지 기다려야함 => 생산성 떨어짐. 독립적인 프로그래밍이 불가능

// 강겹한 스타일의 A, B
//class A {
//	public void methodA(B b) {
//		b.methodB();
//	}
//}

//class B {
//	public void methodB() {
//		System.out.println("methodB()");
//	}
//}

class A {
	public void methodB(I b) {
		b.methodB();
	}
}

// interface 를 활용하면, class A 쪽에 영향이 가지 않음.
// class A 를 구현하는 팀원 class B2 의 완성까지 기다리지 않아도 됨.
// 독립적인 프로그래밍이 가능 or 유지보수성 높아짐 => 생산성 증가
// => 개발시간의 단축
class B2 implements I {

	// 표준화가가능.
	// 기본틀을 인터페이스로 작성한 다음, 개발자들에게 인터페이스를 구현하도록 함.
	// 항상 일관되게 methodB() 가 구현되어 짐으로써 일관되고 정형화된 개발이 가능해짐.
	@Override
	public void methodB() {
		// TODO Auto-generated method stub
		System.out.println("methodB()");
	}

}

interface I {
	public abstract void methodB();
}

public class OopEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 구체화된 Fighter 클래스 사용
		// 다형성이 적용이 되었는지 확인
		// 클래스 간의 관계가 있는 다형성( Object, Unit )
		// Vector, 배열에서의 Unit 관리 목적의 다형성. => 확인이 완료됨.

		// 클래스 간의 관계가 없는 다형성( Fightable, Attackable, Moveable )
		// => 메소드의 매개변수, 반환형 다형성 적용 가능. => 지금부터 확인 필요.

		Fighter f = new Fighter();

		if (f instanceof Fightable) {
			System.out.println("Fightable 타입임.");
		}

		if (f instanceof Moveable) {
			System.out.println("Moveable 타입임.");
		}

		if (f instanceof Attackable) {
			System.out.println("Attackable 타입임.");
		}

		// ---------- 1번 문제 ----------
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();

		Marine marine = new Marine();

		// Tank 수리 테스트
		tank.currentHP = 10;
		System.out.println("tank 수리 전 = " + tank.currentHP);

		// Tank 수리 후
		// 출력 결과가 150 이면 수리 완료.
		scv.repair(tank);
		System.out.println("tank 수리 후 = " + tank.currentHP);

		scv.repair(dropship);
		scv.repair(scv);

		// scv.repair(marine);

		// ---------- 1번 문제 ----------
		Barrack b = new Barrack();
		b.liftOff();
		b.land();

		Factory factory = new Factory();
		factory.liftOff();
		factory.land();

		// --------------------------------parser 기능 동작 테스트
		// xml, html 관련 parser class 를 직접 호출해서 사용하지 않으면 -> 약겹합
		// 인스턴스 생성을 대리자(별도의 클래스)를 통해서 수정하면
		// main 메소드와의 직접적인 관계는 없어짐. => 약결합.

		// 인터페이스 유형으로 반환이 되도록 해야함. => 약결합.

		// 현재는 Parseable 반환되므로 , NewXMLParse 가 되든, XMLParse 가 되든 사용하는 쪽에서는 모르고 사용.
		Parseable parser = ParserManager.getParser();
	}

}

class Unit {
	int currentHP; // Unit 의 에너지, 부족하면 수리 받아야 함.
	int x; // 이동 좌표
	int y; // 이동 좌표
}

class Building {

}

// 1. 이륙 가능한 건물의 타입으로 사용하려는 목적.
// 2. 이륙 가능한 건물 클래스가 새롭게 추가될 경우
//	이륙, 이동, 정지, 착륙 기능의 강제 구현을 시킬려고.

interface Liftable {
	public abstract void liftOff();

	public abstract void move();

	public abstract void stop();

	public abstract void land();
}

// 구체화 클래스 작성 : barrack, factory
// 응집도 높이고,결합도 낮추려면 해결방안:
// 1. 공통 또는 반복되는 코드는 별도로 뽑아내야 함.
//		4가지 메소드가 한 곳에 있도록 해야함. -> 응집도
// 2. 뽑아낸 코드를 쉽게 사용할 수 있도록 해야 함.
// 3. 뽑아낸 곳의 코드에 기능 추가, 성능 개선, 요구 사항 반영을 하더라도,
//		사용되어지고 있는 곳에 영향이 가면 안됨. => 결합도를 낮추어야 함.

class LiftableImpl implements Liftable {

	// 진정한 결합도가 낮다고 볼 수는 없다.
	// 수정이 발생하더라도 다른 곳에 영향 X
	@Override
	public void liftOff() {
		// TODO Auto-generated method stub
		System.out.println("이륙");
		System.out.println("이륙 중");
		System.out.println("이륙 완료");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("이동");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("정지");
	}

	@Override
	public void land() {
		// TODO Auto-generated method stub
		System.out.println("착륙");
	}

}

class Barrack extends Building implements Liftable {

	// 건물의 이동과 관련된 기능의 인스턴스만 생성 후,
	// 필요한 기능의 메소드만 호출만 하기만 하면됨. -> 사용 편리성이 높아짐.
	LiftableImpl l = new LiftableImpl();

	@Override
	public void liftOff() {
		// TODO Auto-generated method stub
		l.liftOff();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		l.move();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		l.stop();
	}

	@Override
	public void land() {
		// TODO Auto-generated method stub
		l.land();
	}

}

class Factory extends Building implements Liftable {

	LiftableImpl l = new LiftableImpl();

	@Override
	public void liftOff() {
		// TODO Auto-generated method stub
		l.liftOff();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		l.move();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		l.stop();
	}

	@Override
	public void land() {
		// TODO Auto-generated method stub
		l.land();
	}

	public void liftOffAndMove() {
		this.liftOff();
		this.move();
	}
}

// interface 의 상속

// interface(이동, 공격)
interface Moveable {
	void move(int x, int y);
}

interface Attackable {
	// 스타크래프트에서 모든 대상은 공격 받을 수 있는 대상임.
	// 모든 대상이 포함되도록 다형성 적용. 관계도상의 최상위 기반타입으로 하면 됨.
	void attack(Unit u);
}

interface Repair {
}

// interface 의 상속
interface Fightable extends Moveable, Attackable {

}

// -------------------------------------------------- 추상화 레벨. (기반클래스, 인터페이스, 추상메소드)

// -------------------------------------------------- 구체화 레벨. (공격자클래스)
class Fighter extends Unit implements Fightable {

	@Override
	public void move(int x, int y) {

	}

	@Override
	public void attack(Unit u) {

	}

}

class Unit2 {
	int currentHP;
	int x;
	int y;
	final int MAX_HP;

	// Unit 별로 체력이 다르기 때문에,
	// 생성자에서 상수인 MAX_HP 를 초기화 하도록 함.
	public Unit2(int hp) {
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit2 {

	public GroundUnit(int hp) {
		super(hp);
	}
}

class AirUnit extends Unit2 {

	public AirUnit(int hp) {
		super(hp);
	}
}

class Marine extends GroundUnit {

	public Marine() {
		super(40);
		currentHP = MAX_HP;
	}
}

class SCV extends GroundUnit implements Repair {
	public SCV() {
		super(60);
		currentHP = MAX_HP;
		// TODO Auto-generated constructor stub
	}

	void repair(Repair r) {
		if (r instanceof Unit2) {
			// 체력 인스턴스 변수에 접근하기 위해서
			// 인스턴스 변수는 타입을 따라감으로 Unit2 로 형변환함.
			Unit2 u = (Unit2) r;

			while (u.currentHP != u.MAX_HP) {
				u.currentHP++;
			}
			System.out.println(u.toString() + " 의 수리가 완료됨.");
		}
	}
}

class Tank extends GroundUnit implements Repair {

	public Tank() {
		super(150);
		currentHP = MAX_HP;
	}

	public String toString() {
		return "Tank";
	}
}

class Dropship extends AirUnit implements Repair {

	public Dropship() {
		super(150);
		currentHP = MAX_HP;
	}

	public String toString() {
		return "dropship";
	}
}