package stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Test1_2 {
    class Student{
        private int stuNum;
        private String stuName;
        private boolean isCome;

        Student(int stuNum, String stuName, boolean isCome) {
            this.stuNum = stuNum;
            this.stuName = stuName;
            this.isCome = isCome;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "stuNum=" + stuNum +
                    ", stuName='" + stuName + '\'' +
                    ", isCome=" + isCome +
                    '}';
        }
    }

    public static void main(String[] args) {
        Test1_2 t = new Test1_2();

        Student stu1 = t.new Student(1, "사카", true);
        Student stu2 = t.new Student(2, "마르티넬리", false);
        Student stu3 = t.new Student(3, "제주스", false);

        //List에 요소 추가하고 스트림 얻기
        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        Stream<Student> stuStream = list.stream();
        stuStream.forEach(a -> System.out.println(a.toString()));
        System.out.println("-------------------------------------------------------");
        Stream<Student> stuStream2 = list.stream();
        stuStream2.forEach(a -> System.out.println(a));
        System.out.println();

        //Set에 요소 추가하고 스트림 얻기
        Set<Student> set = new HashSet<>();
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);

        set.stream().forEach(a -> System.out.println(a));
    }
}
