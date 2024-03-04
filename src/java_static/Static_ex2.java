package java_static;

class Name{
    static void print() { //클래스 method
        System.out.println("내 이름은 몰라도돼");
    }
    
    void print2() {
        System.out.println("내 이름은 더 몰라도돼");
    }
}
public class Static_ex2 {
    public static void main(String[] args) {
        Name.print(); //인스턴스를 생성하지 않아도 호출이 가능

        Name name = new Name(); //인스턴스 생성
        name.print(); //인스턴스를 생성하지 않아도 호출이 가능하지만, 생성해도 가능
        name.print2(); //인스턴스를 생성해야만 호출이 가능
    }
}
