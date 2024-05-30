package ch5;

import java.util.Arrays;

/**
 * 배열 -> 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것. 기본형 타입을 저장하는 배열 다양한 타입을 저장하는 배열 => 객체
 * 배열(상속, 다형성) -> 배열 변수는 참조형. 배열의 첫 번째 요소의 주소값. 배열의 시작 위치 주소 -> 각 요소값을 참조하기 위한
 * 위치정보가 필요. -> 배열의 위치(index) 값은 0부터 시작함. 위치 값은 정수 상수임. score[0], score[1],
 * score[2]... -> 배열은 시작과 끝이 있다 => 배열의 크기 => 배열의 요소 개수 -> 문법에러는 아니지만, 실행 에러 =>
 * indexOFBound... -> 선언방법 타입[] 배열변수명; (추천) 타입 배열변수명[]; -> 선언방법 선언과 동시에 초기화 :
 * 배열의 크기 고정 선언 후 초기화 : 요소를 저장하는데 크기를 지정. 필요시 지정
 */

/*
 * - String 배열 String 클래스는 char 배열에 여러가지 편리한 기능(메소드)을 추가한 타입 String 클래스에 저장된 내용은
 * 읽을수만 있고 변경할 수 없다.
 *
 * - 다차원 배열 1차원 배열 : 행으로만 구성. 2차원 배열 : 행과 열로 구성.
 */

public class ArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] score = { 100, 90, 80, 70, 60 };
		System.out.println(score[4]);
		// System.out.println(score[5]);

		// 배열 선언
		int[] score3; // 추천!
		int score4[];

		int[] iArr1 = new int[10];
		int[] iArr2 = { 10, 20, 30, 40, 50, 60 };
		char[] cArr1 = { 'a', 'b', 'c' };

		iArr1[0] = 10;
		System.out.println(iArr1[0]);
		iArr1[0] = 20;
		System.out.println(iArr1[0]);

		for (int i = 0; i < iArr1.length; i++) {
			System.out.println(iArr1[i]);
		}

		int[] arr2 = { 1, 2, 3, 4, 5 }; // 원본
		int[] tmp = new int[arr2.length]; // 복사본

		for (int i = 0; i < arr2.length; i++) {
			tmp[i] = arr2[i];
		}

		// 원본, 복사본 모두 필요한 경우
		// 복사본이 원본이 되어, 원본이 필요 없게 될 경우 => 가비지 컬렉트 대상.
		arr2 = tmp; // arr2는 기존의 배열의 시작주소는 없어짐. 대신 복사본의 주소가 저장됨 -> arr2는 가비지 컬렉터 대상이 됨.

		// System.arraycopy()
		// 매개변수 : 원본 , 원본시작위치, 복사본, 복사본시작위치, 원본 길이.
		int[] arr3 = { 6, 7, 8, 9, 10 }; // 원본
		int[] tmp2 = new int[arr2.length]; // 복사본

		System.arraycopy(arr3, 0, tmp2, 0, arr3.length);
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(tmp2[i]);
		}

		// 총합과 평균
		int sum = 0;
		float avg = 0;

		int[] score5 = { 100, 95, 90, 87, 65 };

		for (int i = 0; i < score5.length; i++) {
			sum += score5[i];
		}
		avg = sum / (float) score5.length;

		System.out.println(sum);
		System.out.println(avg);

		// 최대값, 최소값 구하기
		int max = score5[0];
		int min = score5[0];

		// tmpScore5은 배열. 참조형은 주소값이 저장됨.
		// 요소값의 변경을 확인하기 위해서 배열의 요소 하나씩 접근해서 확인. -> 반복문 필요함.(가독성 저하) -> 코드 품질 저하.
		// 자바에서 제공되는 api를 사용 -> 유지보수가 편함 -> 코드 품질 향상. 협업에 도움됨.
		for (int i = 0; i < score5.length; i++) {
			if (score5[i] > max) {
				max = score5[i];
			} else if (score5[i] < min) {
				min = score5[i];
			}
		}
		System.out.println(max + ", " + min);

		// 섞기 -> 난수 활용.
//		System.out.println((int) Math.random() * score5.length);

		int[] tmpScore5 = new int[5];
		for (int i = 0; i < tmpScore5.length; i++) {
			int tmpIdx = (int) (Math.random() * score5.length);
			tmpScore5[i] = score5[tmpIdx];
		}
		System.out.println(Arrays.toString(tmpScore5));

		// 빈도수 구하기
		// [65, 100, 100, 90, 95]

		// 데이터 배열
		int[] numArr = new int[10];

		// 집계 배열
		int[] counter = new int[10];

		// 데이터 배열 초기화 - 난수 활용
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = (int) (Math.random() * 10);
			System.out.println(numArr[i]);
		}

		// 집계
		for (int i = 0; i < numArr.length; i++) {
			// 데이터 배열의 요소값을 집계 배열의 인덱스로 사용
			counter[numArr[i]]++;
		}

		// String 배열
		// 선언 후 그 다음에 초기화
		String[] name1 = new String[3];
		name1[0] = "kim";
		name1[1] = "lee";
		name1[2] = "park";

		// 선언과 동시에 초기화
		String[] name2 = { "kim", "lee", "park" };
		System.out.println(Arrays.toString(name2));

		String[] name3 = new String[] { "kim", "lee", "park" };
		System.out.println(Arrays.toString(name3));

		for (String str : name3) {
			System.out.println(str);
		}

		// 참조형 변수, "KIM" 이라는 char 배열을 가지고 있는 변수
		String str1 = "KIM"; // KIM -> MIN 수정하려면?
		String str2 = "lee";
		// 문자열을 가공하는 기능이 있으면 좋겠다고 생각
		// char 배열의 활용도를 높이기 위해서 만든 자료형이 String 임.
		System.out.println(str1.toLowerCase());
		System.out.println(str2.toUpperCase());

		// String 은 값을 수정하지 못하고 읽을수만 있다.
		String str3 = "KIM2";

		// 주소를 비교해서 같으면 동일한 변수임.
		if (str1 == str3) {
			System.out.println("equals");
		}

		if (str1.equals(str3)) {
			System.out.println("문자열 동일");
		}

		// 2차원 배열 선언
		int[][] grade1;
		int[][] grade2 = new int[3][4]; // 3행 4열
		int[][] grade3 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] grade4 = { { 1, 2, 3 }, { 4, 5, 6 } };

		// 2행 3열 요소 모두 조회
		for (int[] grade4tmp : grade4) { // 행 처리, 1행, 2행
			for (int i : grade4tmp) {
				System.out.print(i + " ");
			}
		}

		// 2행 3열 => 2명의 학생에 대한 3개의교과목 점수를 관리
		int[][] grade5 = { { 90, 100, 80 }, { 77, 99, 88 } };

		// 가변 배열
		// 5명의 학생 성적에 대한 교과목 수는 제한하지 않음.
		int[][] grade6 = new int[5][];
		grade6[0] = new int[4]; // 첫 번째 학생의 교과목은 4개
		grade6[1] = new int[2]; // 두 번째 학생의 교과목은 2개
		grade6[2] = new int[3]; // 세 번째 학생의 교과목은 3개

		// 영단어 맞추기 게임
		// chair, 의자 => 1행
		// computer, 컴퓨터 => 2행
		// apple, 사과 => 3행
		// 3행 2열의 다차원 배열

		String[][] words = { { "chair", "의자" }, { "computer", "컴퓨터" }, { "apple", "사과" } };

		// 사용자에게 chair 를 보여줌.
		String inputStr = "의자";

		if (inputStr.equals(words[0][1])) {
			System.out.println("정답");
		}
	}

}
