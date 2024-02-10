package stream.Pipeline;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Pipeline {
    static class Member {
        public static int MALE = 0;
        public static int FEMALE = 1;

        private String name;
        private int sex;
        private int age;

        public Member(String name, int sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public int getSex() {
            return sex;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "name='" + name + '\'' +
                    ", sex=" + sex +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {
//        파이프라인(pipeline)은 데이터의 처리결과가 다시 다음 단계의 입력값으로 들어가 연속적으로 처리되는 구조를 말한다
//        수도관이 길게 연결되어 취수, 정수 등의 과정을 거쳐 개별 가정으로 보급되듯, 파이프라인이란 데이터가 일련의 과정을
//        거쳐 사용자가 원하는 결과값을 내놓도록 처리되는 구조이다

//        파이프라인은 여러개의 스트림을 연결하는데 중간처리 스트림 여러개와 최종처리 스트림 1개로 구성된다
//        필요에 따라 중간처리 스트림을 부품처럼 연결해 사용한다
//        중간처리 스트림은 필요한 데이터를 검색하거나 원하는 형태변환하는 등의 처리를 한다
//        최종처리 스트림은 중간처리 스트림에서 반환하는 값을 토대로 결과값을 내놓는 처리를 한다

//        중간처리(intermediate operators) : 필터링, 매핑, 정렬, 그룹핑 등
//        최종처리(terminal operators) : 합계, 평균, 개수, 최댓값, 최솟값 등

//        대량의 데이터 중에서 우리가 관심있는 데이터만 조건에 걸어 데이터 량을 줄이고 계산(가공)하는 과정을
//        리덕션(reduction)이라고 한다
        List<Member> list = Arrays.asList(
            new Member("사카", Member.MALE, 30),
            new Member("마르티넬리", Member.MALE, 22),
            new Member("윈터", Member.FEMALE, 21),
            new Member("제주스", Member.MALE, 27)
        );
        
        //변수에 대입
        double averageAge =
                        //a. 원본스트림 생성
                        list.stream()

                        //b. 새로운 스트림 생성 -> Male과 일치하는 값으로 필터링
                        .filter(m -> m.getSex() == Member.MALE)

                        //c. 새로운 스트림 생성 -> Member와 age  매핑하기
                        .mapToInt(Member::getAge)

                        //d. 평균값을 계산해서 OptionalDouble 객체에 저장
                        .average()

                        //e. 객체에 저장된 값 읽어들이기
                        .getAsDouble();

        System.out.println("남자 평균 나이 : " + averageAge);
        
        /* 위 코드 한줄씩 실행해보기 */
        //필터링
        Stream stream1 = list.stream()
                            .filter(m -> m.getSex() == Member.MALE);
        stream1.forEach(a -> System.out.println(a));

        //필터링 + 매핑
        IntStream stream2 = list.stream()
                .filter(m -> m.getSex() == Member.MALE)
                .mapToInt(Member::getAge);
        stream2.forEach(a -> System.out.println(a));

        //필터링 + 매핑 + 평균(OptionalDouble로 받기)
        OptionalDouble optionalDouble = list.stream()
                .filter(m -> m.getSex() == Member.MALE)
                .mapToInt(Member::getAge)
                .average();
        System.out.println(optionalDouble);

        //OptionalDouble에 있는 값 얻기
        Double value = optionalDouble.getAsDouble();
        System.out.println(value);
    }
}
