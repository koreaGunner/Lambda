package lamdba.Function_FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;

public class Test01 {
    class Student{
        private int stuNum;
        private String stuName;
        private int math;
        private int english;

        Student(int stuNum, String stuName, int math, int english) {
            this.stuNum = stuNum;
            this.stuName = stuName;
            this.math = math;
            this.english = english;
        }
    }

    public static void main(String[] args) {
        //역할 : 매핑(타입변환)하기
        //메서드 : applyXXX()
        //예를 들어, List 항목중에서 int값을 추출하거나 다른 타입으로 변환하는 등의 작업에 사용한다.
        //앞서 실행한 함수적 인터페이스의 결과값이 다음 함수적 인터페이스의 인자값으로 할당되어 최종값을 도출한다.
        //인터페이스 행태            내용
//        Function<T, U>          T받아서 U 리턴
//        BiFunction<T, U, R>     T, U 형태를 받아서 R 리턴
//        XXXFunction<T>          XXX 받아서 T 리턴
//        XXXtoYYYFunction        XXX 받아서 YYY 리턴
//        ToXXXFunction<T>        T 받아서 XXX 리턴
//        ToXXXBiFunction<T, U>   T, U 받아서 XXX 리턴

        Test01 test = new Test01();
        Student st1 = test.new Student(123, "홍길동", 11, 36);

        //매핑 : Student객체 - Student의 Integer 값
        Function<Student, Integer> function = a -> a.stuNum;
        int result01 = function.apply(st1);
        System.out.println("홍길동 번호 : " + result01);

        //매핑 : 두 Integer 값 - Double 값
        BiFunction<Integer, Integer, Double> biFunction = (a, b) -> (double) (a + b) / 2;
        double result02 = biFunction.apply(3, 6);
        System.out.println("두 숫자 평균 : " + result02);

        //매핑 : Double 값 - Integer 값
        DoubleFunction<Integer> doubleFunction = a -> {
          Double d = Math.floor(a);
          return d.intValue();
        };
        int result03 = doubleFunction.apply(246.71);
        System.out.println("소수점 버리기 : " + result03);

        //매핑 : Integer, Integer - Double
        ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction;
        toDoubleBiFunction = (math, english) -> (double) (math + english) / 2;
        double result04 = toDoubleBiFunction.applyAsDouble(st1.math, st1.english);
        System.out.println("홍길동의 수학 영어 평균 : " + result04);

    }
}
