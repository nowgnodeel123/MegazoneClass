package ch8;

/* *
 * ------------------------------ 메소드에서 Exception 발생 시켜서 던지기 ------------------------------
 * 
 * 
 * 
 * ------------------------------ Exception 처리 문제. (요구 사항) ------------------------------
 * 
 * 파일을 처리하는 예외가 발생할 수 있음을 가정하고 프로그램 구현.
 * - 기능 : 복사 공간 여유 확인, 메모리 여유 확인, 파일 복사, 설치, 임시 파일 삭제
 * - 예외 처리 : 복사 공간의 여유가 없을 때, 메모리가 부족 할 때.
 * - 프로그램 동작 순서.
 *  - 설치 시작 => 복사 공간 여유 확인 > 메모리 여유 확인 > 파일 복사 > 설치 완료
 *  - 설치 완료 => 임시 파일 삭제
 *  
 * - 좋은 코드로 작성하기 위한 기준
 *  - 응집도 높다 => 관련있는 것들 끼리 묶음 => 메소드 형태
 *  										=> 설치 메소드, 파일 복사 메소드, 파일 삭제 메소드, 메모리 체크, 디스크 용량.
 *  - 재사용성이 높은 것 => 예외 클래스 작성.
 * 
*/

public class ExceptionEx3 {

	static void method1() throws Exception {

		method2();

//		try {
//			method2();
//		} catch (Exception e) {
//			
//		}
	}

	static void method2() throws Exception {
		throw new Exception("method2() : 예외 발생."); // 예외 처리 위임.
	}

	public static void main(String[] args) {

//		try {
//			method1(); // 위임 받은 예외를 처리함.
//		} catch (Exception e) {
//
//		}

//		method1(); // 비정상 종료 => JVM 에서 예외 처리함.

		System.out.println("정상 종료됨.");

	} // end of main

}