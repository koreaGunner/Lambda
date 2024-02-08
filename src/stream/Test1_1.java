package stream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1_1 {
    public static void main(String[] args) {
//        컬렉션에서 Iterator 반복자를 얻어내듯이 배열, 컬렉션 등 집합에서 Stream을 얻어낼 수 있다
//        - java.util.Arrays - stream() 메서드
//        - java.util.Collection - stream() 메서드
        
        String[] strArr = {"사카", "외데고르", "마르티넬리", "제주스"};
        //Arrays 클래스 - stream() 메서드로 스트림 얻기
        Stream<String> strStream = Arrays.stream(strArr);
        //forEach는 반복하면서 모든 개별요소를 가져올 수 있다
        strStream.forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();

        Stream<String> strStream2 = Arrays.stream(strArr);
        Consumer<String> strConsumer = a -> System.out.print(a + " ");
        strStream2.forEach(strConsumer);
        System.out.println();

        int[]  intArr = {12, 64, 92};
        //요소가 int인 경우 intStream으로 얻는다
        IntStream intStream = Arrays.stream(intArr);
//        IntConsumer intConsumer = i -> System.out.print(i + " ");
//        intStream.forEach(intConsumer);
        intStream.forEach(i -> {
            System.out.print(i + " ");
        });
        System.out.println();

        double[] doubleArr = {145.46, 2.85};
        //요소가 double인 경우 DoubleStream으로 얻는다
        DoubleStream doubleStream = Arrays.stream(doubleArr);
        doubleStream.forEach(a -> System.out.print(a + " "));
    }
}
