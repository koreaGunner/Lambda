package stream.Pipeline;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Test2_3 {
    public static void main(String[] args) {
//        정렬
//        숫자는 오름차순, 내림차순으로 정렬할 수 있다. 혹은 Comparator를 구현해 정렬기준을 제시할 수 있다
//        메서드                     내용
//        sorted()                  오름차순 정렬
//        sorted()                  Comparable 구현기준에 따라 정렬
//        sorted(Comparator<T>)     Comparator 구현기준에 따라 정렬

        Test2_3 t = new Test2_3();
        IntStream intStream = Arrays.stream(new int[]{2, 64, 37, 19, 82});
        System.out.println("--int[] 오름차순 정렬하기");
        intStream.sorted()
                .forEach(a -> System.out.print(a + " "));

        System.out.println();
        List<Student> list = Arrays.asList(
            t.new Student("사카", 95),
            t.new Student("마르티넬리", 85),
            t.new Student("제수스", 90),
            t.new Student("외데고르", 100),
            t.new Student("라이스", 99)
        );

        System.out.println("--List - Student 기준에 따라 정렬하기");
        list.stream()
                .sorted()
                .forEach(a -> System.out.println("이름 : " + a.getName() + " | 점수 : " + a.getScore()));

        System.out.println("--List - Student 기준 반대로 정렬하기");
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(a -> System.out.println("이름 : " + a.getName() + " | 점수 : " + a.getScore()));

    }

    class Student implements Comparable<Student> {
        private String name;
        private int score;

        private Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        //compareTo 오버라이드해서 정렬기준(=점수) 제시
        @Override
        public int compareTo(Student o) {
            return Integer.compare(score, o.score);
        }
    }
}
