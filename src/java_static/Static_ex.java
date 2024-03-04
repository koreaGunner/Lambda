package java_static;

class Number{
    static int num = 0; //클래스 필드
    int num2 = 0; //인스턴스 필드
}
public class Static_ex {
    public static void main(String[] args) {
        Number number1 = new Number();
        Number number2 = new Number();

        number1.num++;
        number1.num2++;
        System.out.println("static 변수 : " + number2.num);
        System.out.println("인스턴스 변수  : " + number2.num2);

    }
}
