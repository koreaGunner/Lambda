package stream.Pipeline;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test2_7 {
    public enum Sex {MALE, FEMALE};
    public enum City {SEOUL, BUSAN};

    class Student {
        private String name;
        private int score;
        private Sex sex;
        private City city;

        public Student(String name, int score, Sex sex, City city) {
            this.name = name;
            this.score = score;
            this.sex = sex;
            this.city = city;
        }

        public String getName() {
            return  name;
        }

        public int getScore() {
            return score;
        }

        public Sex getSex() {
            return sex;
        }

        public City getCity() {
            return city;
        }
    }
    public static void main(String[] args) {
//        수집
//        Student 클래스를 요소로 하는 컬렉션에서 조건에 일치하는 요소로 새로운 컬렉션 생성하기

        Test2_7 t = new Test2_7();
        List<Student> list = Arrays.asList(
                t.new Student("이순신", 25, Sex.MALE, City.BUSAN),
                t.new Student("이순령", 55, Sex.FEMALE, City.SEOUL),
                t.new Student("이순자", 74, Sex.FEMALE, City.BUSAN),
                t.new Student("이순근", 17, Sex.MALE, City.SEOUL),
                t.new Student("이순혜", 35, Sex.FEMALE, City.SEOUL)
        );

        System.out.println("--List -Male");
        List<Student> listMale = list.stream()
                .filter(a -> a.getSex() == Sex.MALE)
                .collect(Collectors.toList());
        listMale.stream()
                .forEach(a -> System.out.print(a.getName() + " "));

        System.out.println("\n--Set -부산");
        Set<Student> setFemale = list.stream()
                .filter(a -> a.getCity() == City.BUSAN)
                .collect(Collectors.toCollection(HashSet::new));
        setFemale.stream()
                .forEach(a -> System.out.print(a.getName() + " "));
    }
}
