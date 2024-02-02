package java_enum;

import org.w3c.dom.ls.LSOutput;

public class SeasonTest {
    public static void main(String[] args) {
        //열거타입으로 변수 선언하기
        Season season2024;

        //열거상수 값 할당하기
        //열거상수는 단독으로 사용할 수 없다. 앞에 "열거타입." 이 붙어야 한다.
        Season summer2024 = Season.SUMMER;
        System.out.println(summer2024);

        //null 값 할당도 가능하다
        Season summer2025 = null;
        System.out.println(summer2025);

//      열거타입 변수에 저장되는 값은 참조변수로서 stack 영역에 주소값이 생성된다.
//      이 때, 열거타입 변수의 주소값은 열거상수의 주소값과 동일하다. 같은 영역을 참조하기 때문에 동일한 값을 가질 수 있다.
//      열거상수의 값이 변경되는 경우, 같은 주소값을 참조하는 열거변수의 값도 변경된다.
    }
}
