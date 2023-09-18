package shop.mtcoding.demo.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamEx01Test {

    @Test
    public void ex05(){
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

        // 중복 제거, 정렬
        List<Integer> newList = list.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        
        // 값 출력하기
        newList.forEach(i -> System.out.print(i + " ")); 
    }

    @Test
    public void ex04(){
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        List<Integer> newList = new ArrayList<>();

        // 1. list -> newList에 깊은 복사하기
        for (Integer t : list) {
            newList.add(t);
        }

        // 2. newList에서 동일한 값 제거하기
        for (int i = 0; i < newList.size(); i++) {
            for (int j = i + 1; j < newList.size(); j++) {
                if (newList.get(i) == newList.get(j)) {
                    newList.remove(j);
                }
            }
        }
        
        // 3. 값 출력하기
        for (Integer i : newList) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void ex03(){
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        List<Integer> lowList = new ArrayList<>();
        List<Integer> highList = new ArrayList<>();

        // 얕은 복사 (주소가 복사 됨)
        lowList = list;

        // 깊은 복사 (주소만 복사하는 것이 아니고 값이 복사 되는 것))
        for(Integer i : list){
            highList.add(i);
        }
    }

    @Test
    public void ex02(){
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

        Stream<Integer> stream = list.stream();

        // 1. distinct() : 중복제거
        stream.distinct().forEach(t -> {
            System.out.println(t);
        });
    }

    @Test
    public void ex01(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(1);

        // 스트림 생성
        Stream<Integer> stream = list.stream();

        // 스트림을 순회한다.
        // 람다식에서는 타입을 넣지 않아도 된다.
        stream.forEach(t -> {
            System.out.println(t);
        });
        
        // 람다식을 쓰지 않으면 이렇게 만들어야 한다.
        stream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }            
        });
    }
}
