package lamdba.Supplier_FunctionIalnterface;

import java.util.function.*;

public class SupplierTest {
    public static void main(String[] args) {
        //역할 : 생산자. 매개값이 없고, 리턴값이 있다.
        //메서드 : getXXX();
        //인터페이스 행태          내용
//        Supplier<T>           T형 반환
//        XXXSuppler            XXX형 반환

        String stringValue = "helloWorld";
        boolean booleanValue = true;
        double doubleValue = 1235214.123523423;
        int intValue = 123;
        long longValue = 512341213;

        Supplier<String> supplier = () -> stringValue;
        BooleanSupplier booleanSup = () -> booleanValue;
        DoubleSupplier doubleSup = () -> doubleValue;
        LongSupplier longSup = () -> longValue;
        IntSupplier intSup = () -> intValue;

        SupplierTest test = new SupplierTest();

        String s = supplier.get();
        System.out.println("String 값 : " + s);

        boolean b = booleanSup.getAsBoolean();
        System.out.println("boolean 값 : " + b);

        double d = doubleSup.getAsDouble();
        System.out.println("double 값 : " + d);

        long l = longSup.getAsLong();
        System.out.println("long 값 : " + l);

        int i = intSup.getAsInt();
        System.out.println("int 값 : " + i);
    }
}
