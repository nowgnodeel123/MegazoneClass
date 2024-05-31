package ch11;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

/*
 * Collections class 활용.
 *
 * Collection(자료 묶음)을 쉽게 사용하기 위해 다양한 기능의 메소드가 정의되어 있는 클래스.
 *
 *  - 현재의 Collections 의 인스턴스들은 용도가 데이터 저장용.
 *  - 현재는 실행 환경이 싱글 쓰레드임.
 *  - 프로세스 하나가 데이터 저장소를 전용으로 혼자서 사용하고 있음.
 *
 *    프로세스 두 개가 같은 데이터 저장소를 사용하게 되면 어떻게 될까.
 *
 *
 *
 *
 * */
public class CollectionFWEx2 {
  public static void main(String[] args) {

    // 동기화 Collections 메소드임.
    // 메소드명 앞에 synchronizedList 로 prefix 가 시작되는 메소드를 사용.
    // 멀티 쓰레드 환경, 다중 프로세스 환경인 경구가 언제인지만 알면됨.
    // 멀티 쓰레드 환경 : 채팅 서버(멀티쓰레드 대상 : Socket)
    //                          (Collection 관리 대상 : 주고 받는 메세지)
    // TCP/IP, Socket(IP, PORT)
//    Collections.synchronizedList(null);

    List list = new ArrayList();
    System.out.println(list);

    // Collection 메소드 사용.
    addAll(list, 1, 2, 3, 4, 5);
    System.out.println(list);

    rotate(list, 2); // 오른쪽으로 2칸 이동.
    System.out.println(list);

    swap(list, 0, 2); // 해당 위치의 값을 교환.
    System.out.println(list);

    shuffle(list); // 섞기
    System.out.println(list);

    sort(list); // 정렬
    System.out.println(list);

    sort(list, reverseOrder()); // reverse(list)와 동일.
    System.out.println(list);

    int idx = binarySearch(list, 3); // 해당 데이터의 위치 값.
    System.out.println("index: " + idx);

    List newList = nCopies(list.size(), 2); // 새로운 배열을 생성 후, 모두 2로 초기화
    System.out.println(newList);

    System.out.println("max = " + max(list));
    System.out.println("min = " + min(list));

    fill(list, 9); // 요소를 모두 9로 변경.
    System.out.println(list);

    replaceAll(list, 2, 1);
    System.out.println(list);
  }
}
