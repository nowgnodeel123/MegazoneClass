package ch4;

public class FlowEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (0 < 10) {
			System.out.println("0은 10보다 작음.");
		} else {
			System.out.println("0은 10보다 작지 않음.");
		}

		int a = 10;
		if (a == 10) {

		} else if (a > 10) {

		} else if (a > 100) {

		} else {

		}

		if (0 < 10) {
			System.out.println("0은 10보다 작음.");

			if (0 < 100) {

			}
		}

		// switch
		/*
		 * 1. 조건식을 계산 조건식의 결과는 정수, 상수 또는 문자열 2. 조건의 결과와 맞는 case로 이동 3. 이후의 문장을 실행 4.
		 * break를 만나기 전까지 실행.
		 */
		// 중첩 switch는 가독성을 악화
		switch (3) {
		case 3:
			System.out.println("3");
		case 2:
			System.out.println("2");
			break;
		case 1:
			System.out.println("1");
			break;
		}

		// for, while
		// => for/each, stream, lambda 를 적용할 수 있는지 고려. (리팩토링)
		// => 코드 품질이 향상됨

		for (int i = 1; i < 5; i++) {
			System.out.println(i);

			if (i == 3) {
				break;
			}

		}

		// 배열을 처리하는 경우
		int[] arr = { 1, 2, 3, 4, 5 };

		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}

		// 배열 처리하는 경우 -> 향상된 for 활용
		for (int tmp : arr) {
			System.out.println(tmp);
		}

		// while
		int i = 1;
		while (i <= 5) {
			System.out.println(i);
			i++;
		}

		int j = 5;
		while (j-- != 0) {
			System.out.println(j); // 4,3,2,1,0
		}

		j = 5;
		while (--j != 0) {
			System.out.println(j); // 4,3,2,1
		}

		// do-while(조건식) { } 무조건 한 번 실행은 하고 조건을 만족하는지 확인.
		// break; 종료 용도
		// continue; 반복은 유지 하는데 해당 되면 건너뛰기

		// continue 사용
		/*
		 * 이름 붙은 반복문 : 가독성 매우 낮음.
		 * 
		 */
		for (i = 0; i < 11; i++) {
			if (i % 3 == 0)
				continue;

			System.out.println(i);

		}

		// 이름 붙은 반복문 -> 가능하면 다른 방법을 사용.
		Loop1: for (i = 2; i < 9; i++) {
			if (i == 7)
				break Loop1;
		}
	}

}
