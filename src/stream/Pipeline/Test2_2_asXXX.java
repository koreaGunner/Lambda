package stream.Pipeline;

import java.util.Arrays;
import java.util.function.DoubleToIntFunction;
import java.util.stream.IntStream;

public class Test2_2_asXXX {
    public static void main(String[] args) {
//        매핑 - 다른 값으로 변경하기
//        메서드                 내용
//        flatMapXXX()          특정요소가 여러개의 요소로 대체되는 스트림 리턴
//        mapXXX()              요소를 대체하는 새로운 스트림 리턴
//        asXXXStream()         타입변환된 스트림 리턴
//        boxed()               박싱(boxing)된 값을 요소로 하는 스트림 리턴
        int[] intArr = {16, 52, 49, 26, 83};
        IntStream intStream;

        System.out.println("--double로 변환해서 출력하기");
        intStream = Arrays.stream(intArr);
        intStream.asDoubleStream()
                .forEach(a -> System.out.print(a + " "));

        System.out.println("\n--boxing된 값 출력하기");
        intStream = Arrays.stream(intArr);
        intStream.boxed()
                .forEach(a -> System.out.print(a + " "));
    }
}
