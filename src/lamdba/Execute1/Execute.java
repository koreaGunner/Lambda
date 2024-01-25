package lamdba.Execute1;

public class Execute {
    public static void main(String[] args) {
        //매개변수가 없고, 리턴값이 없는 람다식
        //객체 선언
        JavaCoding jc;

        //{} 실행코드 뒤에 세미콜론(;)을 붙어야한다.
        jc = () -> {
            System.out.println("Rollin' Rollin' Rollin' Rollin'");
        };
        jc.nowCoding();

        //{} 실행코드가 1줄인 경우 {} 생략가능
        jc = () -> System.out.println("Rollin' Rollin' Rollin' Rollin'");
        jc.nowCoding();

    }
}
