package stream.Pipeline;

import java.util.Arrays;
import java.util.List;

public class Test2_2_flatMap {
    public static void main(String[] args) {
//        매핑 - 다른 값으로 변경하기
//        메서드                 내용
//        flatMapXXX()          특정요소가 여러개의 요소로 대체되는 스트림 리턴
//        mapXXX()              요소를 대체하는 새로운 스트림 리턴
//        asXXXStream()         타입변환된 스트림 리턴
//        boxed()               박싱(boxing)된 값을 요소로 하는 스트림 리턴

        //String 요소를 공백기준으로 각각의 String 요소로 나누기
        List<String> listString = Arrays.asList(
                "홍 길 동", "임 꺽 정"
        );
        listString.stream()
                .flatMap(a -> Arrays.stream(a.split(" ")))
                .forEach(a -> System.out.print(a + " "));
        System.out.println();

        //String 요소 . 기준으로 분리하기
        //각각의 int 형태로 바꾸기
        List<String> listInt = Arrays.asList(
                "17, 32, 71, 96, 26, 53"
        );
        listInt.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(a -> System.out.print(a + " "));
    }
}
