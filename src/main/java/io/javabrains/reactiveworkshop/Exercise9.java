package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        ReactiveSources.intNumbersFlux()
                .count()
                .subscribe(size -> System.out.println("Size: " + size));

        // Collect all items of intNumbersFlux into a single list and print it
        ReactiveSources.intNumbersFlux()
                .collectList()
                .subscribe(list -> System.out.println(list));

        // Transform to a sequence of sums of adjacent two numbers
        ReactiveSources.intNumbersFlux()
                .buffer(2)
                .map(list -> {
                    Integer first = list.get(0);
                    Integer second = 0;
                    try {
                        second = list.get(1);
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println(ex.getMessage());
                    }
                    return first + second;
                })
                .subscribe(sum -> System.out.println(sum));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
