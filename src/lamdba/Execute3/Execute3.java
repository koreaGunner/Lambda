package lamdba.Execute3;

public class Execute3 {
    public static void main(String[] args) {
        //매개변수가 없고, 리턴값이 있는 람다식

        JavaCoding3 jc;
        String str1 = "가위";
        String str2 = "바위";
        String str3 = "보";

        jc = () -> {
            return str1;
        };
        System.out.println(jc.nowCoding());

        jc = () -> { return str2; };
        System.out.println(jc.nowCoding());

        //실행코드가 reuturn만 있는 경우 {}와 return문 생략 가능
        jc = () -> str3;
        System.out.println("마지막 : " + jc.nowCoding());
    }
}
