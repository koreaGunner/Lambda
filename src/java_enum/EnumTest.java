package java_enum;

import java.util.Arrays;
import java.util.Calendar;

public class EnumTest {
    enum Arsenal{
        Henry,
        Saka,
        Rowe,
        Raya,
        Xhaka
    }

    public static void main(String[] args) {
//        열거타입(enum)이란
//        enum 타입은 몇가지 상수의 집합을 정의하는 타입으로 클래스의 특수한 형태이다.
//        집합이 갖는 값이 한정되어있고, 다른 값이 허용되지 않는 경우에 사용한다.
//        * 사계절 : 봄, 여름, 가을, 겨울
//        * 요일 : 월, 화, 수, 목, 금, 토, 일
//        * 성별 : 여성, 남성
        
//        메서드                             내용  
//        boolean equals(Object other)      열거상수와의 동등성 비교
//        String name()                     열거상수 값 리턴
//        int ordinal()                     열거값에서 몇번째에 해당하는지 리턴
//        Static T valueOf(String name)     열거 객체 리턴
//        values()                          모든 열거객체들을 배열로 리턴

//        new 연산자로 열거타입을 생성할 수 없다.
//        Season season = new Season();

        //열거변수 선언하여 값 가져오기
        Season spring = Season.SPRING;
        Season summer = Season.SUMMER;
        Season autumn = Season.AUTUMN;
        Season winter = Season.WINTER;

        //.values() 메서드로 배열 리턴
        Month[] months = Month.values();
        System.out.println(months);
        System.out.println(Arrays.toString(months));

        //Calendar 클래스에서 이번 달 값 받아오기
        Calendar cal = Calendar.getInstance();
        int month = cal.get(2);
        System.out.println("month : " + month);

        //이번 달 숫자에 따른 Month 열거상수 값 가져오기
        Month whichMonth = months[month];
        month += 1;

        //3으로 나눈 정수 값 할당
        //1년 12달을 계절로 표현하기 위한 계산식
        int index = whichMonth.ordinal() / 3;
        System.out.println(whichMonth.ordinal());

        String seasonNow;
        String 지금;
        switch (index){
            case 0:
                seasonNow = winter.name();
                지금 = 계절.겨울.name();
                break;
            case 1:
                seasonNow = spring.name();
                지금 = 계절.봄.name();
                break;
            case 2:
                seasonNow = summer.name();
                지금 = 계절.여름.name();
                break;
            case 3:
                seasonNow = autumn.name();
                지금 = 계절.가을.name();
                break;
            default:
                seasonNow = winter.name();
                지금 = 계절.겨울.name();
        }
        System.out.printf("이번달은 %d월이구요. %s(%s)입니다.", month, 지금, seasonNow);
    }
}
