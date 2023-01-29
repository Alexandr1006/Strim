import java.util.*;
import java.util.function.*;
import java.util.stream.*;


public class Main {
//Task1
    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer){

        List<T> arrayList;
        T min = null;
        T max = null;
        arrayList = stream
                .sorted(order).
                collect(Collectors.toList());
        if(arrayList.size() != 0){

            min = arrayList.get(0);
            max = arrayList.get(arrayList.size()-1);
        }
        minMaxConsumer.accept(min, max);
    }
    //Task2
    public static void evenNumbers(List<Integer> list){
        System.out.println("Четных чисел " + list.stream().
                                                filter(i -> i % 2 == 0).count());

    }
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(28);
        list.add(4);
        list.add(6);
        Stream<Integer> integerStream = list.stream();
        findMinMax(integerStream, Comparator.comparing(i -> i),
                (x, y) -> System.out.println("Минимальное значение " + x + "\n" + "Максимальное значение " + y));

        //Task2
        evenNumbers(list);


    }
}