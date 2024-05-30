package ch8;

/* *
 * -------------------------------------------------- Exception --------------------------------------------------
 * 에러의 종류 : 컴파일 에러, 런타임 에러, 논리 에러.
 * 
 * error 와 exception
 * 	error(에러) : 코드로 해결할 수 없는 오류
 * 	exception(예외) : 코드로 해결 할 수 있는 오류(컴파일 에러 아님)
 * 					일어날 수 있는 오류에 대비해서 Java 에서 제공 되는 문법을 활용해서 해결.
 * 
 * 예외 처리의 목적
 * 	프로그램의 비정상적인 종료를 막고, 정상적인 실행 상태를 유지. (중요)
 * 
 * 
 * 
*/
public class ExceptionEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 100;
		int result = 0;

		for (int i = 0; i < 10; i++) {

			// 실행 유지 or 정상 종료 처리 되도록 Exception Handling 함.

			try { // exception 이 발생 될 부분을 기입.
				result = number / (int) (Math.random() * 10);
				System.out.println(result);
			} catch (ArithmeticException e) { // 발생한 예외에 대한 리포팅 처리.
				System.out.println("0으로 나눔.");
			}

			// 0으로 나누는 경우 => java.lang.ArithmeticException 발생
			// 비정상 종료 => 문제점 리포팅 => 정상 종료가 되도록 해야함.
		}
	}

}
