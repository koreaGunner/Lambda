package lamdba.Execute4;

public class Execute4 {
    public static void main(String[] args) {
        //매개변수가 있고, 리턴값이 있는 람다식

        JavaCoding4 jc;
        String str1 = "가위";
        String str2 = "바위";
        String str3 = "보";

        jc = (s) -> {
            return s + str1;
        };
        System.out.println(jc.nowCoding("내가 "));

        jc = (s) -> { return s + str2; };
        System.out.println(jc.nowCoding("너는 "));

        //실행코드가 reuturn만 있는 경우 {}와 return문 생략 가능
        jc = (s) -> s + str3;
        System.out.println(jc.nowCoding("마지막 : "));
    }
}
