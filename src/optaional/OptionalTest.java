package optaional;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.XMLFormatter;

public class OptionalTest {
    public static void main(String[] args) {
        String str1 = "hi";
        Optional<String> optional1 = Optional.of(str1);

        String str2 = null;
        Optional<String> optional2 = Optional.ofNullable(str2);
        Optional<String> optional3 = Optional.of(str2);

//        1. static Optional<T> empty()
//                Optional이 감싼 객체를 제거한다.
//
//        2. boolean isPresent()
//                Optional이 감싸고 있는 객체가 null이 아니면 true, null이면 false를 반환
//
//        3. boolean isEmpty()
//                isPresent()와 반대로 null인 경우 true를 반환
//
//        4. T get()
//                감싼 객체를 반환한다.
        String result = optional1.get();

//        5. void ifPresent(Consumer<? super T> action)
//                비어있지 않다면 할 action을 정의한다. Consumer는 함수형 인터페이스이므로 람다로 구현한다
//                isPresent()와 헷갈리지 않도록 하자
        optional1.ifPresent((act) -> System.out.println(act));

//        6. void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)
//                ifPresent와 비슷하지만 Runnable emptyAction이 추가되었다
//                객체가 들어있다면 action을, 없다면 emptyAction을 실행한다
//                위의 간단한 메소드 말고 Optional은 이 메소드같이 null일 때, 핸들링 처리를 위해 나온게 아닌가 싶다.

        String str4 = null;
        Optional<String> optional4 = Optional.ofNullable(str4);

        //str이 null인지 아닌지에 따라 달라진다.
        optional4.ifPresentOrElse((act) -> {
            System.out.println("들어있으면 이걸 실행한다.");
        }, () -> {
            System.out.println("안들어있으면 이걸 실행한다.");
        });

//        7. <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X
//                    객체가 있으면 반환, 없다면 Throwable을 구현한 구현체의 Supplier를 반환한다.
//                    Supplier도 함수형 인터페이스이므로 람다로 구현해야 한다.

        optional4.orElseThrow(() -> new RuntimeException("비어있어요..")); //custom message
        optional4.orElseThrow(RuntimeException::new); //default

//        8. T orElseThrow()
//                위와 같지만 exception을 구현하지 않아도 된다. 내부 구현방식응ㄹ 보면 NoSuchElementException을 던진다.

//        9. Optional<T> filter(Predicate<? super T> predicate)
//                Predicate 객체를 통과하지 못하면 빈 값을 return한다
//                통과에 대한 로직 또한 위와 같이 따로 구현한다
//
//        10. <U> Optional<U> map(Fuction<? super T, ? extends U> mapper)
//                객체가 null이 아닐경우, mapper를 통해 변환된 Optional객체를 반환한다
//                mapper를 통과하지 못한 경우 empty()를 반환한다

        Optional<Integer> i = Optional.of(5);
        Optional<String> s = i.map(String::valueOf);

        System.out.println(s.get()); //5가 출력된다
//        위에서 봤듯이 대부분이 큰 로직만 제공하고, 내부는 개발자가 직접 구현해서 쓸 수 있도록 해놓았다
//        간단한 로직에서는 가독성면에서 오히려 if-else가 좋을 수 있으나,
//        연속 if-if-if-else-else-else과 같은 조건문 지옥이 있는 상황에서는 써볼만 할 것 같다.


        // 예제!!!!!
        String str5 = null;

        //기존
        if (str5 == null || str5.equals("")) {
            str5 = "alternative";
        }

        //대체
        str5 = Optional.ofNullable(str5).filter(Predicate.not(String::isBlank)).orElseGet(() -> "alternative");


        String str6 = null;
        //기존
        if (str6 == null || str6.equals("")) {
            throw new IllegalArgumentException();
        }

        //대체
        Optional.ofNullable(str6).filter(Predicate.not(String::isBlank)).orElseThrow(IllegalArgumentException::new);

    }
}
