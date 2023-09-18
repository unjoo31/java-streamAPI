package shop.mtcoding.demo.lab;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamEx04Test {

    @Test
    public void ex07(){
        Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "PHP");
        Map<Boolean, List<String>> patition = stream.collect(Collectors.partitioningBy(s -> (s.length() % 2) == 0));
        List<String> oddLengthList = patition.get(false);
        System.out.println(oddLengthList);
        List<String> evenLengthList = patition.get(true);
        System.out.println(evenLengthList);
    }

    @Test
    public void ex06(){
        Stream<String> stream = Stream.of("넷", "둘", "하나", "셋");
        List<String> list = stream.collect(Collectors.toList());
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }

    @Test
    public void ex05(){
        IntStream stream1 = IntStream.of(30, 90, 70, 10);
        DoubleStream stream2 = DoubleStream.of(30.3, 90.9, 70.7, 10.1);

        System.out.println(stream1.sum());
        System.out.println(stream2.average().getAsDouble());
    }

    @Test
    public void ex04(){
        IntStream stream1 = IntStream.of(30, 90, 70, 10);
        IntStream stream2 = IntStream.of(30, 90, 70, 10);

        System.out.println(stream1.count());
        System.out.println(stream2.max().getAsInt());
    }

    @Test
    public void ex03(){
        IntStream stream1 = IntStream.of(30, 90, 70, 10);
        IntStream stream2 = IntStream.of(30, 90, 70, 10);

        System.out.println(stream1.anyMatch(n -> n > 80));
        System.out.println(stream2.allMatch(n -> n > 80));
    } 
    
    @Test
    public void ex02(){
        IntStream stream1 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
        IntStream stream2 = IntStream.of(4, 2, 7, 3, 5, 1, 6);

        OptionalInt result1 = stream1.sorted().findFirst();
        System.out.println(result1.getAsInt());

        OptionalInt result2 = stream2.sorted().findAny();
        System.out.println(result2.getAsInt());
    } 

    @Test
    public void ex01(){
        Stream<String> stream = Stream.of("넷", "둘", "셋", "하나");
        stream.forEach(System.out::println);
    } 

}
