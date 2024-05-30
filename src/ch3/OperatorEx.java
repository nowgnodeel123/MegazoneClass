package ch3;

public class OperatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 5;
		i++;

		System.out.println(i);

		i = 5;
		++i;

		System.out.println(i);

		int a = 5, b = 0;
		b = a++;

		System.out.println("a: " + a + ", " + "b: " + b);

		// 산술변환
		byte b2 = 10;
		byte b3 = 20;
		byte b4 = (byte) (b2 + b3); // 값 소실 가능성 있음

		// 변수 초기화 표현 스타일 => 가독성
		int read1 = 1000000;
		int read2 = 1_000_000;
		System.out.println(read1 + read2);

		long long1 = 1_000_000 * 1_000_000;
		long long2 = 1_000_000 * 1_000_000L;
		System.out.println(long1 + long2);

		// 비교연산
		System.out.println('0' == 0);
		System.out.println('0' != 0);
		System.out.println('A' < 'B');
		System.out.println('B' == 65);

		// 문자열인 경우의 논리연산. 문자열은 참조형, 주소값임.
		String str = "abc";

		System.out.println(str.equals("abc"));
		System.out.println(str.equals("def"));

		System.out.println(0 < 10 && 10 < 20);
		System.out.println(100 < 10 || 10 < 20);
		
		// !(논리 부정) 연산
		System.out.println(!(0 < 10 && 10 < 20));
		
		// 조건 연산자 (3항식)
		System.out.println((10 < 20) ? true : false);
		
		// 복합 대입연산자
		// i = i + 1; i += 1;
	}

}
