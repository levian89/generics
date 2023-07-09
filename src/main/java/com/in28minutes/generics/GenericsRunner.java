package com.in28minutes.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsRunner
{
    static double sumOfNumberList(List<? extends Number> numbers) {  // (<? extends Number>) Upper bounded wildcard
        double sum = 0;                                              // this method can take objects from Number and
        for (Number number:numbers) {                                // its subclasses as arguments
            sum += number.doubleValue();
        }
        return sum;
    }

    static void addACoupleOfValues(List<? super Number> numbers) {  // (<? super Number>) Lower bounded wildcard
       numbers.add(1);                                              // this method can take objects from Number and its
       numbers.add(1.0);                                            // superclasses as arguments
       numbers.add(1.0f);
       numbers.add(1l);
    }

    public static void main( String[] args )
    {
        System.out.println(sumOfNumberList(List.of(1,2,3,4,5)));
        System.out.println(sumOfNumberList(List.of(1.1,2.1,3.1,4.1,5.1)));
        System.out.println(sumOfNumberList(List.of(1l,2l,3l,4l,5l)));

        List<Number> emptyList = new ArrayList<>();
        addACoupleOfValues(emptyList);
        System.out.println(emptyList);


        MyCustomList<String> list1 = new MyCustomList<>();
        list1.addElement("Element1");
        list1.addElement("Element2");
        String value = list1.get(0);
        System.out.println(value);
        System.out.println(list1);

        MyCustomList<Integer> list2 = new MyCustomList<>();
        list2.addElement(Integer.valueOf(5));
        list2.addElement(Integer.valueOf(7));
        Integer number = list2.get(0);
        System.out.println(number);
        System.out.println(list2);

    }
}
