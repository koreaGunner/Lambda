package stream.Pipeline;

import java.util.Arrays;

public class Test2_4 {
    public static void main(String[] args) {
//        루핑 - 요소 반복하기
//        메서드             내용
//        peek()            -중간처리 메서드
//                          -중간에 호출해야 스트림이 동작한다
//                          -마지막에 호출하면 스트림이 동작하지 않는다
//        forEach()         -최종처리 메서드
//                          -마지막에 호출해야 스트림이 동작한다
//                          -이후에 다른 메서드를 호출 시 컴파일 에러 발생
        int[] intArr = {6, 1, 2, 5, 7, 3, 4, 8};

        System.out.println("--peek 호출(스트림 동작안함)");
        Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)    //짝수 필터링
                .peek(a -> System.out.print(a + " "));

        System.out.println("--peek 호출 + 최종메서트 호출");
        int total = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .peek(a -> System.out.print(a + " "))
                .sum();
        System.out.println("\ntotal : " + total);

        System.out.println("--forEach 호출");
        Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .forEach(a -> System.out.print(a + " "));

        System.out.println("\n--forEach + 메서드 호출(컴파일에러)");
//        Arrays.stream(intArr)
//                .filter(a -> a % 2 == 0)
//                .forEach(a -> System.out.print(a + " "))
//                .count();
    }
}
