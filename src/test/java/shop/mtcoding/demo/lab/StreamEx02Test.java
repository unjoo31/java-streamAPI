package shop.mtcoding.demo.lab;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class StreamEx02Test {

    @Test
    public void ex05(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // skip() : 데이터 건너뜀
        // peek() : 스트림 연산 결과 확인
        List<Integer> newList = list.stream()
                .skip(1)
                .peek(t -> {
                    System.out.println("peek : " + t);
                })
                .limit(2)
                .map(t -> t * 2)
                .collect(Collectors.toList());
        newList.stream().forEach(t -> System.out.println(t));
    } 

    @Test
    public void ex04(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // limit() : 데이터 제한
        List<Integer> newList = list.stream().limit(2).collect(Collectors.toList());
        newList.stream().forEach(t -> System.out.println(t));
    } 

    @Test
    public void ex03(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // 중계연산 두번 하기
        List<Integer> newList = list.stream() // 스트림 생성
                .filter(t -> t != 3) // 스트림 가공 : filter은 boolean 타입을 리턴함
                .map(t -> {
                    Integer r = t * 2;
                    return r; // 람다식의 경우 두줄일경우 {}를 넣어서 작성해야함
                }) // 스트림 가공 : map은 R(Stream에 떠다디는 타입)(Integer) 타입을 리턴함
                .collect(Collectors.toList()); // 스트림 수집
        
        newList.stream().forEach(t -> System.out.println(t));
    }

    @Test
    public void ex02(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // 숫자 3을 날린다
        List<Integer> newList = list.stream().filter(t -> t%3 != 0).collect(Collectors.toList());
        newList.stream().forEach(t -> System.out.println(t));
    }
    
    @Test
    public void ex01(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // filter() : return타입이 true이면 남겨두고 false면 제외시킨다
        // filter(t -> t%2 != 0) : 짝수를 날린다
        List<Integer> newList = list.stream().filter(t -> t%2 != 0).collect(Collectors.toList());
        newList.stream().forEach(t -> System.out.println(t));
    }
}
