package ch8;

public class ExceptionEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			install();
		} catch (InstallException e) {
			// InstallException 에는 SpaceException or MemoryException 을 원인 예외로 가지고 있음.

			if (e.getCause() instanceof SpaceException)
				System.out.println("InstallException 의 원인 : SpaceException");
			if (e.getCause() instanceof MemoryException)
				System.out.println("InstallException 의 원인 : MemoryException");

			System.out.println("Error MSG : " + e.getMessage());
			e.printStackTrace();
		} finally {
			deleteTempFiles();
		}

		// checked 예외를 unchecked 로 변경하는 경우
		// Exception -> RuntimeException 으로 형변환.
		// 연결된 예외임.
		MemoryException met = new MemoryException("unchecked 예외용");

		// Exception -> RuntimeException 으로 변경됨.
		// 하지만 실제로는 연결된 예외임.
		// RuntimeException(met)
		// -> super((Throwable)met) -> Exception((Throwable)met) ->
		// -> super((Throwable)met) -> Throwable((Throwable)met) ->
		// this.cause = (Throwable)met;

		// Throwalbe class 의 cause 인스턴스 변수에 저장
		// 원인이 되는 예외 => 연결된 예외.

		// 결론적으로 checked -> unchecked 로 변경됨. 컴파일 체크를 하지 않게 됨.
		RuntimeException rex = new RuntimeException(met);
	}

	static void install() throws InstallException {
		try {
			startInstall();
		} catch (SpaceException se) {
			InstallException ie = new InstallException("설치중 예외 발생.");
			// InstallException 의 원인 예외를 등록할 수 있음.
			// 원인 예외를 InstallException 의 인스턴스 멤버변수로 관리하고 있으니,
			// 연결된 예외라고 말할 수 있음.

			// 원인 예외(cause)의 실제 소유 클래스는 Throwable 임.
			// 즉, Throwable 클래스의 멤버변수(cause)임.

			// 모든 예외는 자신을 발생시킨 원인 예외를 가질 수 있음.
			ie.initCause(se);
			throw ie;

		} catch (MemoryException me) {
			InstallException ie = new InstallException("설치중 예외 발생.");
			ie.initCause(me);
			throw ie;
		}
	}

	// 프로그램 설치와 관련된 메소드 작성.
	static void startInstall() throws SpaceException, MemoryException {
		if (!enoughSpace())
			throw new SpaceException("설치 실패!! 설치 공간 부족.");

		if (!enoughMemory())
			throw new MemoryException("설치 실패!! 메모리 부족.");
	}

	static void copyFile() {

	}

	static void deleteTempFiles() {
		System.out.println("임시 파일 삭제 성공.");
	}

	static boolean enoughSpace() {
		// 디스크 공간을 확인하는 로직 생성

		return true;
		// false -> 공간부족, 예외 발생 시켜야함.
		// true -> 디스크의 설치 공간이 충분 -> 예외 발생하지 않음.
	}

	static boolean enoughMemory() {
		// 메모리 공간을 확인하는 로직 생성

		return false;
	}
}

// 예외 클래스 정의

/*
 * * - 사용자에러 100개 - 시스템에러 100개 - 서비스에러 100개 - 운영에러 100개 - 400개 예외에 대해서 try {}
 * catch () {} 초반에는 엄격하게 하는게 맞을 수 있음, 정말 안정화 되고, 운영이 잘 되고 있는 상황에서, 신규개발시, 수정시
 * try{} catch() {} 를 하지 않아도 되도록 개발 및 유지보수 정책을 수립할 수 있음.
 * 
 * RuntimeException class 를 사용하게 되면, try{} catch() {} 를 하지 않아도 되게 해줌.
 * 
 * - checked, unchecked 옵션 checked : 컴파일러가 검사 -> Exception 의 관계를 맺어주면 됨. -> 상속
 * 예외처리를 강제하겠다는 의미. -> 직접 예외처리 -> 위임처리
 *
 * unchecked : 컴파일러가 검사 안함. -> RuntimeException 의 관계를 맺어주면 됨. -> 상속.
 *
 *
 *
 *
 */

/**
 * 연결된 예외
 * 
 * 큰 분류로 묶어서 관리하는 경우, checked 예외를 unchecked 로 변경하는 경우를 주로 사용 가능성이 높음.
 * 
 * 발생한 예외를 그냥 처리하면 되는데, 왠지 복잡해진 것 같은.. - 하나의 큰 분류의 예외로 묶어서 관리하고 싶은 경우. 큰 분류의 예외로
 * catch 해서 처리하려고 하는데, 실제로 발생한 예외를 알 수가 없게 됨.
 * 
 * 목적 : 추상화 또는 상속을 통해서 다형성을통해 관리의 편리성을 높이기 위함. => 반복되는 코드가 줄어들게됨. (다형성이 적용된
 * 매개변수, 반환타입)
 * 
 * - 상속 관계로 exception 을 정의하면 casting 이 필요해짐. 파생된 exception 이 많아지게 되면, casting 의
 * 부담이 증가.
 * 
 * casting 대신에 initCause(), getCause()
 * 
 * - checked 예외를 unchecked 로 변경하려고 하는 경우. new RuntimeException((new
 * MemoryException())) => unchecked
 */

// 설치 예외
class InstallException extends Exception {
	public InstallException(String msg) {
		super(msg);
	}
}

// 설치 예외의 원인 예외(디스크 용량)
class SpaceException extends Exception {
	public SpaceException(String msg) {
		super(msg);
	}
}

//설치 예외의 원인 예외(메모리 용량)
class MemoryException extends Exception {
	public MemoryException(String msg) {
		super(msg);
	}
}