package lamdba.Consumer_FunctionalInterface;

import java.util.function.*;

public class ConsumerTest {
        //역할 : 소비자. 매개값이 있고, 리턴값이 없다
        //메서드 : accept()
//        인터페이스 형태            내용
//        XXXConsumer<T>          XXX 형태의 인자값을 받는다
//        BiConsumer<T, U>        T, U 형태의 인자값 2개를 받는다
//        ObjXXXConsumer<T>       T, XXX 형태의 인자값 2개를 받는다

    Consumer<String> c1 = a -> System.out.println("입력값 : " + a);

    BiConsumer<String, Integer> c2 = (a, b) -> System.out.println("입력값1 : " + a + " 입력값2 : " + b);

    IntConsumer c3 = a -> System.out.println("입력값 : " + a);

    DoubleConsumer c4 = a -> System.out.println("입력값 : " + a);

    LongConsumer c5 = a -> System.out.println("입력값 : " + a);

    ObjIntConsumer<Student> c6 = (a, b) -> System.out.println("이름 : " + a.name + " 숫자 : " + b);

    ObjDoubleConsumer<Student> c7 = (a, b) -> System.out.println("이름 : " + a.name + " 숫자 : " + b);

    ObjLongConsumer<Student> c8 = (a, b) -> System.out.println("이름 : " + a.name + " 숫자 : " + b);

    ObjLongConsumer<String> c9 = (a, b) -> System.out.println("이름 : " + a + " 숫자 : " + b);

    class Student{
        private String name;
        Student(String name){this.name = name;};
    }

    public static void main(String[] args) {
        ConsumerTest test = new ConsumerTest();
        
        test.c1.accept("김유신");
        test.c2.accept("홍길동", 123);
        test.c3.accept(456);
        test.c4.accept(123.124123124124213123124124123123);
        test.c5.accept(1232344123);
        
        Student student = test.new Student("이순신");
        test.c6.accept(student, 12);
        test.c7.accept(student, 23.131234);
        test.c8.accept(student, 1612345);
        test.c9.accept("되나", 56406540);
    }
}
