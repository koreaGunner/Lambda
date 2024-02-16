package stream.findAny;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void createStreamFindFirst() {
        //findFirst()
        //해당 스트림에서 첫번째 요소를 참조하는 Optional 객체를 반환합니다.

        List<String> strings = Arrays.asList("A1", "A2", "A3", "A4", "A5");
        Optional<String> stringFirst = strings.stream()
                .filter(s -> s.startsWith("A"))
                .findFirst();
        System.out.println("createStreamFindFirst");
        stringFirst.ifPresent(System.out::println);
    }

    public static void createStreamFindAny() {
        //findAny()
        //해당 스트림에서 첫번째 요소를 참조하는 Optional 객체를 반환합니다
        //findFirst() 와 findAny()의 차이는 병렬 처리 시 발생합니다

        List<String> strings = Arrays.asList("A1", "A2", "A3", "A4", "A5");
        Optional<String> stringAny = strings.stream()
                .filter(s -> s.startsWith("A"))
                .findAny();
        System.out.println("createStreamFindAny");
        stringAny.ifPresent(System.out::println);
    }

    public static void createStreamParallelFindFirst() {
        //findFirst() 병렬 처리 시
        //병렬 처리 시에도 첫번째 요소를 참조하는 Optional 객체를 반환합니다

        List<String> strings = Arrays.asList("A1", "A2", "A3", "A4", "A5");
        Optional<String> stringFirst = strings.stream()
                .parallel()
                .filter(s -> s.startsWith("A"))
                .findFirst();
        System.out.println("createStreamParallelFindFirst");
        stringFirst.ifPresent(System.out::println);
    }

    public static void createStreamParallelFindAny() {
        //findAny() 병렬 처리 시
        //병렬 처리 시 가장 먼저 찾은 요소를 참조하는 Optional 객체를 반환합니다

        List<String> strings = Arrays.asList("A1", "A2", "A3", "A4", "A5");
        Optional<String> stringAny = strings.stream()
                .parallel()
                .filter(s -> s.startsWith("A"))
                .findAny();
        System.out.println("createStreamParallelFindAny");
        stringAny.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        createStreamFindFirst();
        createStreamFindAny();
        createStreamParallelFindFirst();
        createStreamParallelFindAny();
    }
}
