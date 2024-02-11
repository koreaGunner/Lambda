package stream.Pipeline;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test2_6_1 {
    public static void main(String[] args) {
//        기본집계 - 합계, 평균, 최댓값, 최솟값, 카운트 등 최종값 구하기
//        메서드                 내용
//        count()               개수
//        findFirst()           첫번째 요소
//        max()                 최댓값
//        min()                 최솟값
//        sum()                 합계
//        average()             평균
        int[] intArr ={6, 1, 2, 5, 7, 3, 4, 8};

        long count = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .count();
        System.out.println("count : " + count);

        long sum = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .sum();
        System.out.println("sum : " + sum);

        double average = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .average()
                .getAsDouble();
        System.out.println("average : " + average);

        int max = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .max()
                .getAsInt();
        System.out.println("max : " + max);

        int min = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .min()
                .getAsInt();
        System.out.println("min : " + min);

        int first = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .findFirst()
                .getAsInt();
        System.out.println("first : " + first);
    }
}
