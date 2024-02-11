package stream.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Test2_6_2 {
    public static void main(String[] args) {
//        Optional 클래스 사용하기
//        집계된 값을 저장하고, 집계값이 존재하지 않는 경우 대체값을 설정할 수 있다
//        메서드                 내용
//        isPresent()           값이 저장되었는지 여부
//        orElse()              값이 저장되지 않았다면 대체값 설정
//        ifPresent()           값이 저장된 경우 Consumer에서 처리하기

        List<Integer> list = new ArrayList<>();
        OptionalDouble optionalDouble = list.stream()
                .mapToInt(Integer :: intValue)
                .average();
        //값이 존재하는지 확인하고 대체값 설정
        if (optionalDouble.isPresent()) {
            System.out.println(optionalDouble.getAsDouble());
        } else {
            System.out.println("avg1 : 0.0");
        }

        //값이 존재하는지 확인하고 대체값 설정
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("avg2 : " + avg);

        //값이 존재하는지 확인하고 있다면 값 출력하기
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(a -> System.out.println("avg3 : " + a));
    }
}
