package ch2;

public class VarEx1 {

	public static void main(String[] args) {
		// 변수 예제
		int year = 0;
		int age = 26;

		System.out.println(year);
		System.out.println("연 나이: " + age);

		year = age + 1999 - 1;
		age = age - 1;

		System.out.println(year);
		System.out.println("만 나이: " + age);

		// 상수 예제
		final int speed = 10;
		// speed += 10; 변경 불가

		System.out.println(speed);

		// 문자
		char c1 = 'c';
		// char는 문자 한 개만 저장 가능
		// char c2 = 'aa';
		// char c3 = "cc";

		String str = "str";

		System.out.println(c1);
		System.out.println(str);

		// 실수
		float f = 12.3456789123f;
		double d = 12.3456789123456789123d;

		System.out.println(f);
		System.out.println(d);

		// 형 변환
		// 자동 형변환 규칙
		// -> 기본의 값을 최대한 보존할 수 있는 타입으로 자동으로 형변환 됨.
		// byte > short > int > long > float > double > char
		// char > int

		double d2 = 12.34;
		int num = (int) d2;

		System.out.println(d2);
		System.out.println(num);

		double d3 = 56.78;
		int num2 = (int) d3;

		System.out.println(d3);
		System.out.println(num2);

		char c4 = 'A';
		int intA = (int) c4;
		System.out.println(c4);
		System.out.println("A ->" + " " + intA);
	}

}
