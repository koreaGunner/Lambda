package stream.Pipeline;

import java.util.Arrays;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.stream.Stream;

public class Test2_1 {
    public static void main(String[] args) {
//        필터링 - 요소 걸러내기
//        메서드           내용
//        distinct()      중복 제거하기
//        filter()        조건에 맞는 값 찾기
        List<String> list = Arrays.asList("사과", "사과", "딸기", "바나나", "복숭아", "수박", "딸기", "바나나", "수박", "토마토");

        System.out.println("--중복제거");
        Stream<String> stream = list.stream().distinct();
        stream.forEach(a -> System.out.print(a + " "));

        System.out.println("\n--이름이 3글자");
        list.stream()
                .filter(fruit -> fruit.length() == 3)
                .forEach(a -> System.out.print(a + " "));

        System.out.println("\n--이름이 3글자, 중복 제거");
        list.stream()
                .distinct()
                .filter(fruit -> fruit.length() == 3)
                .forEach(a -> System.out.print(a + " "));

        System.out.println("\n--이름이 3글자, 중복 제거, 첫글자가 '바'");
        list.stream()
                .distinct()
                .filter(fruit -> fruit.length() == 3)
                .filter(fruit -> fruit.startsWith("바"))
                .forEach(a -> System.out.print(a + " "));
    }
}
