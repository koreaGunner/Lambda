package stream;

import java.util.stream.IntStream;

public class Test1_3 {
    public static void main(String[] args) {
        //마지막 숫자 포함
        IntStream intStream1 = IntStream.rangeClosed(1, 10);
        intStream1.forEach(a -> System.out.print(a + " "));
        System.out.println();

        //마지막 숫자 제외
        IntStream intStream2 = IntStream.range(1, 10);
        intStream2.forEach(a -> System.out.print(a + " "));
    }
}
