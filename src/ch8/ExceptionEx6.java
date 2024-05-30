package ch8;

/* ****************************************************************************************************
 * - 자동 자원 반환
 *  문법 : try.. with.. resource..
 *  
 *  목적 : finally 의 복잡도가 높아지는 경우를 해결.
 *  	   자원 해제 시 사용 가능성이 높음. (ex) 입출력 처리 관련.
 *  	   => close()
 *  
 *  사용 : AutoCloseable interface 를 구현.
 *  	   인터페이스를 구현해야만, 자동 자원 반환 문법을 적용 시킬 수 있음.
 *  
 *  	   try {} block 에서도 예외가 발생하고, AutoCloseable 을 구현한
 *  	   close() 에서도 예외가 발생한다면?
 *  
 *  	   두 군데서 발생할 예외적인 상황을 코드로 만들어야 확인이 가능함.
 *  	   => 사용자 정의 Exception 을 두 개 만든 후,
 *  		  두 개의 Exception 을 throw 하면 됨.
 * 
 * 
 * 
**************************************************************************************************** */
public class ExceptionEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 실제로 발생한 Exception 은 WorkException 으로 하고,
		// CloseException 은 억제된 예외로 두면 됨.
		
		try (CloseableResource cr = new CloseableResource()) {
			cr.resourceWork(false); // WorkException 발생.
		} catch (WorkException we) {
			we.printStackTrace();
		} catch (CloseException e) {
			e.printStackTrace();
		}
		System.out.println("정상 종료됨");
	}

}

// 해제 할 어떤 자원이 있다고 가정하고 class 작성.
class CloseableResource implements AutoCloseable {

	// 자원을 사용한다고 가정한 메소드
	public void resourceWork(boolean exceptionFlag) throws WorkException {
		System.out.println("resourceWork() 호출됨.");

		// true : if 가 조건 만족 => exception 발생.
		// false : if 가 조건 만족 X =>
		if (exceptionFlag)
			// 발생한 예외는 위임 처리 => 메소드 정의 부분에 throw.
			throw new WorkException("WorkException 발생.");
	}

	// 사용자 정의 Exception 적용 전
//	@Override
//	public void close() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("close() 호출");
//	}

	// 사용자 정의 Exception 적용 후
	@Override
	public void close() throws CloseException {
		// TODO Auto-generated method stub
		System.out.println("close() 호출됨.");
		throw new CloseException("CloseException 발생");
	}

}

// 자원 사용시 발생하는 예외 처리용 Exception class
class WorkException extends Exception {
	public WorkException(String msg) {
		super(msg);
	}
}

// 자원 해제시 발생하는 예외 처리용 Exception class
class CloseException extends Exception {
	public CloseException(String msg) {
		super(msg);
	}
}