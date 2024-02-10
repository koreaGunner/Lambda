package stream.Pipeline;

import java.util.Arrays;
import java.util.List;

public class Test2_2_Map {
    public static void main(String[] args) {
//        매핑 - 다른 값으로 변경하기
//        메서드                 내용
//        flatMapXXX()          특정요소가 여러개의 요소로 대체되는 스트림 리턴
//        mapXXX()              요소를 대체하는 새로운 스트림 리턴
//        asXXXStream()         타입변환된 스트림 리턴
//        boxed()               박싱(boxing)된 값을 요소로 하는 스트림 리턴

        Test2_2_Map test = new Test2_2_Map();
        List<Student> list= Arrays.asList(
            test.new Student("사카", 94),
            test.new Student("외데고르", 100),
            test.new Student("마르티넬리", 85)
        );

        list.stream()
                .mapToInt(Student :: getScore)
                .forEach(a -> System.out.println("점수 : " + a));
    }

    class Student {
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
    }
}
